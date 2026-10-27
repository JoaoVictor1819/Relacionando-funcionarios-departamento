package empresa.spring.jpa.util;

import empresa.spring.jpa.dto.funcionariosDto.FuncionariosRequestDto;
import empresa.spring.jpa.entity.funcionarios.FuncionarioEntity;

public class FuncionarioCreator {

    public static FuncionarioEntity createFuncionarioToBeSaved(){
        return FuncionarioEntity.builder()
                .nome("Eduarda")
                .build();
    }

    public static FuncionarioEntity createValidFuncionarios(){
        return  FuncionarioEntity.builder()
                .nome("Eduarda")
                .id(1L)
                .build();
    }

    public static FuncionarioEntity createValidUpdateFuncionario(){
        return FuncionarioEntity.builder()
                .nome("Eduarda 2")
                .id(1L)
                .build();
    }

}
