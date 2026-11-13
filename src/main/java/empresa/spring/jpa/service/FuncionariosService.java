package empresa.spring.jpa.service;

import empresa.spring.jpa.dto.funcionariosDto.FuncionariosRequestDto;
import empresa.spring.jpa.dto.funcionariosDto.FuncionariosResponseDto;
import empresa.spring.jpa.dto.projetoDto.ProjetoResponseDto;
import empresa.spring.jpa.entity.FuncionarioResumoProjection;
import empresa.spring.jpa.entity.departamento.DepartamentoEntity;
import empresa.spring.jpa.entity.funcionarios.FuncionarioEntity;
import empresa.spring.jpa.entity.projetos.ProjetoEntity;
import empresa.spring.jpa.exception.BadRequestExceptionHandler;
import empresa.spring.jpa.exception.ResouceExceptionHandler;
import empresa.spring.jpa.repository.DepartamentoRepository;
import empresa.spring.jpa.repository.FuncionariosRepository;
import empresa.spring.jpa.repository.ProjetoRepository;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class FuncionariosService {

    private final FuncionariosRepository funcionariosRepository;
    private final DepartamentoRepository departamentoRepository;

    @Transactional
    public void saveFuncionario(FuncionariosRequestDto dto){
        DepartamentoEntity departamento = departamentoRepository.findById(dto.getIdDepartamento())
                .orElseThrow(() -> new ResouceExceptionHandler("Departamento não encontrado"));

        validarEmail(dto.getEmail());

         funcionariosRepository.save(FuncionarioEntity.builder()
                .nome(dto.getNome())
                .idade(dto.getIdade())
                .email(dto.getEmail())
                .senha(dto.getSenha())
                .departamento(departamento)
                .build());
    }


    public void validarEmail(String email){
        if (funcionariosRepository.existsByEmail(email)) {
            throw new BadRequestExceptionHandler("Email ja existente");
        }
    }

    public List<FuncionariosResponseDto> findAllFuncionarios(){
        List<FuncionarioEntity> funcionarios = funcionariosRepository.findAll();


        return funcionarios.stream()
                .map(this::toResponse)
                .toList();
    }

    private FuncionariosResponseDto toResponse(FuncionarioEntity f){
        return new FuncionariosResponseDto(f.getId(), f.getDataCriacao(), f.getNome(), f.getIdade(),f.getEmail(), f.getDepartamento().getId(), f.getDepartamento().getNome(), f.getEndereco());
    }


    public Page<FuncionarioResumoProjection> findAllFuncionariosPage(Integer page, Integer size) {
        return funcionariosRepository.getAllFuncionarioPage(PageRequest.of(page, size));
    }

    public List<FuncionariosResponseDto> listFuncionariosName(String name){
        List<FuncionarioEntity> funcionarioEntities = funcionariosRepository.findByNomeContainingIgnoreCase(name);

        if (funcionarioEntities == null){
            throw new ResouceExceptionHandler("Nao existe nenhum funcionario cadastrado");
        }
        return funcionarioEntities.stream()
                .map(this::toResponse)
                .toList();
    }


    public void delete(Long id){
        funcionariosRepository.deleteById(id);
    }

    @Transactional
    public FuncionariosResponseDto update(Long id, FuncionariosRequestDto dto) {
        FuncionarioEntity funcionario = funcionariosRepository.findById(id)
                .orElseThrow(() -> new BadRequestExceptionHandler("Este id de funcionario nao existe"));

        DepartamentoEntity departamento = departamentoRepository.findById(dto.getIdDepartamento())
                        .orElseThrow(() -> new BadRequestExceptionHandler("Este departemento nao existe"));

        funcionario.setNome(dto.getNome());
        funcionario.setEmail(dto.getEmail());
        funcionario.setSenha(dto.getSenha());
        funcionario.setDepartamento(departamento);

        FuncionarioEntity funcionarioUpdate = funcionariosRepository.save(funcionario);
        return toResponse(funcionarioUpdate);

    }
}
