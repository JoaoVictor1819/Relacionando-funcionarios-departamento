package empresa.spring.jpa.service;

import empresa.spring.jpa.dto.departamentoDto.DepartamentoRequestDto;
import empresa.spring.jpa.dto.departamentoDto.DepartamentoResponseDto;
import empresa.spring.jpa.dto.funcionariosDto.FuncionariosResponseDto;
import empresa.spring.jpa.dto.projetoDto.ProjetoResponseDto;
import empresa.spring.jpa.entity.departamento.DepartamentoEntity;
import empresa.spring.jpa.exception.BadRequestExceptionHandler;
import empresa.spring.jpa.exception.ResouceExceptionHandler;
import empresa.spring.jpa.repository.DepartamentoRepository;
import empresa.spring.jpa.repository.FuncionariosRepository;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.apache.coyote.BadRequestException;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.Set;

@Service
@RequiredArgsConstructor
public class DepartamentoSevice {

    private final DepartamentoRepository departamentoRepository;
    private final FuncionariosRepository funcionariosRepository;



    public void save(DepartamentoRequestDto dto) {
        DepartamentoEntity departamento = departamentoRepository.findByNome(dto.getNome())
                .orElse(null);

        if (departamento != null){
            throw new BadRequestExceptionHandler("Departamento ja existe");
        }

         departamentoRepository.save(DepartamentoEntity.builder()
                 .nome(dto.getNome())
                 .salarioFixo(dto.getSalarioFixo())
                 .descricao(dto.getDescricao())
                 .build());
    }

    public List<DepartamentoResponseDto> findAll(){
        List<DepartamentoEntity> departamento = departamentoRepository.findAll();

        return departamento.stream()
                .map(this::toResponse)
                .toList();
    }

    private DepartamentoResponseDto toResponse(DepartamentoEntity departamentoEntity){
       List<FuncionariosResponseDto> funcionarios = departamentoEntity.getFuncionarios().stream()
               .map(f -> new FuncionariosResponseDto(f.getId(),
                       f.getDataCriacao(),
                       f.getNome(),
                       f.getEmail(),
                       f.getDepartamento().getId(),
                       f.getDepartamento().getNome(),
                       f.getEndereco(),
                       f.getProjetos()))
               .toList();

       return new DepartamentoResponseDto(departamentoEntity.getId(),
               departamentoEntity.getNome(),
               departamentoEntity.getSalarioFixo(),
               departamentoEntity.getDescricao(),
               funcionarios);
    }

    public List<DepartamentoResponseDto> findByName(String name){
        List<DepartamentoEntity> departamentoNome = departamentoRepository.findByNomeContainingIgnoreCase(name);

        if (departamentoNome == null){
            departamentoRepository.findAll();
        }

        return departamentoNome.stream()
                .map(this::toResponse)
                .toList();
    }

    public DepartamentoResponseDto findById(Long id){
        DepartamentoEntity departamento = departamentoRepository.findById(id)
                .orElseThrow(() -> new BadRequestExceptionHandler("Departamento não encontrado"));

        List<FuncionariosResponseDto> funcionariosResponseDto = departamento.getFuncionarios().stream()
                .map(f -> new FuncionariosResponseDto(f.getId(),f.getDataCriacao(),f.getNome(),f.getEmail(),f.getDepartamento().getId(), f.getDepartamento().getNome(), f.getEndereco(), f.getProjetos()))
                .toList();

        return new DepartamentoResponseDto(departamento.getId(),
                departamento.getNome(),
                departamento.getSalarioFixo(),
                departamento.getDescricao(),
                funcionariosResponseDto);

    }

    @Transactional
    public void delete(Long id){
        DepartamentoEntity departamento = departamentoRepository.findById(id)
                .orElseThrow(() -> new BadRequestExceptionHandler("Departamento não encontrado"));

        if (!departamento.getFuncionarios().isEmpty()){
            throw new RuntimeException("Não é possível excluir o departamento, pois existem funcionários associados a ele.");
        }

        departamentoRepository.delete(departamento);
    }

    @Transactional
    public DepartamentoResponseDto UpdateDepartamento(Long id, DepartamentoRequestDto dto){
        DepartamentoEntity departamento = departamentoRepository.findById(id)
                .orElseThrow(() -> new ResouceExceptionHandler("Este id nao faz parte de nenhum departamento existente"));

        departamento.setNome(dto.getNome());
        departamento.setSalarioFixo(dto.getSalarioFixo());
        departamento.setDescricao(dto.getDescricao());

        DepartamentoEntity departamentoUpdate = departamentoRepository.save(departamento);
        return toResponse(departamentoUpdate);
    }

}
