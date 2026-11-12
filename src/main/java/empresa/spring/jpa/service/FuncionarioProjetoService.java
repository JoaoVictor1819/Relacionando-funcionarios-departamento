package empresa.spring.jpa.service;


import empresa.spring.jpa.dto.funcionariosDto.FuncionariosResponseDto;
import empresa.spring.jpa.dto.projetoDto.ProjetoResponseDto;
import empresa.spring.jpa.entity.funcionarios.FuncionarioEntity;
import empresa.spring.jpa.entity.projetos.ProjetoEntity;
import empresa.spring.jpa.repository.FuncionarioProjetoRepository;
import empresa.spring.jpa.repository.FuncionariosRepository;
import empresa.spring.jpa.repository.ProjetoRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class FuncionarioProjetoService {

    private FuncionarioProjetoRepository funcionarioProjetoRepository;
    private FuncionariosRepository funcionariosRepository;
    private ProjetoRepository projetoRepository;


    public void SalvarFuncionarioProjeto(FuncionariosResponseDto dtoFuncionario) {
        FuncionarioEntity funcionario = funcionariosRepository.findById(dtoFuncionario.getId())
                .orElseThrow(() -> new RuntimeException("Funcionario nao encontrado"));

        List<ProjetoEntity> projetosEntity = projeto(dtoFuncionario.getProjeto());


    }

    public List<ProjetoEntity> projeto(List<ProjetoResponseDto> ids){
        List<ProjetoEntity> projetos = projetoRepository.findAllById(ids);
        if (projetos.isEmpty()){
            throw  new RuntimeException("Projeto nao encontrado");
        }
        return projetos;
    }


}
