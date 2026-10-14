package empresa.spring.jpa.service;

import empresa.spring.jpa.dto.funcionariosDto.FuncionariosRequestDto;
import empresa.spring.jpa.dto.funcionariosDto.FuncionariosResponseDto;
import empresa.spring.jpa.entity.departamento.DepartamentoEntity;
import empresa.spring.jpa.entity.funcionarios.FuncionarioEntity;
import empresa.spring.jpa.exception.ResouceExceptionHandler;
import empresa.spring.jpa.repository.DepartamentoRepository;
import empresa.spring.jpa.repository.FuncionariosRepository;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class FuncionariosService {

    private final FuncionariosRepository funcionariosRepository;
    private  final DepartamentoRepository departamentoRepository;

    @Transactional
    public FuncionarioEntity saveFuncionario(FuncionariosRequestDto dto){
        DepartamentoEntity departamento = departamentoRepository.findById(dto.idDepartamento)
                .orElseThrow(() -> new ResouceExceptionHandler("Departamento não encontrado"));

        FuncionarioEntity funcionario = new FuncionarioEntity();
        funcionario.setNome(dto.nome);
        funcionario.setDepartamento(departamento);

        return funcionariosRepository.save(funcionario);
    }


    public List<FuncionariosResponseDto> findAll(){
        List<FuncionarioEntity> funcionarios = funcionariosRepository.findAll();

        return funcionarios.stream()
                .map(this::toResponse)
                .toList();
    }

    private FuncionariosResponseDto toResponse(FuncionarioEntity funcionario){
        return new FuncionariosResponseDto(funcionario.getId(), funcionario.getNome(), funcionario.getDepartamento().getId(), funcionario.getDepartamento().getNome());
    }



    public void delete(Long id){
        funcionariosRepository.deleteById(id);
    }
}
