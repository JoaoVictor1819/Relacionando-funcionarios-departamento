package empresa.spring.jpa.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import empresa.spring.jpa.dto.funcionariosDto.FuncionariosRequestDto;
import empresa.spring.jpa.dto.funcionariosDto.FuncionariosResponseDto;
import empresa.spring.jpa.entity.FuncionarioResumoProjection;
import empresa.spring.jpa.entity.funcionarios.FuncionarioEntity;
import empresa.spring.jpa.service.FuncionariosService;
import empresa.spring.jpa.util.FuncionarioCreator;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.data.jpa.test.autoconfigure.DataJpaTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.webmvc.test.autoconfigure.WebMvcTest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.test.context.bean.override.mockito.MockitoBean;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(SpringExtension.class)
@DataJpaTest
class FuncionarioControllerTest {

    @Autowired
    FuncionariosService funcionariosService;



    @Test
    public void return_the_sucessfully_created_employee(){
        FuncionariosRequestDto funcionario = FuncionariosRequestDto.builder()
                .nome("Joao")
                .senha("123")
                .build();

        FuncionarioEntity funcionarioToSaved = this.funcionariosService.saveFuncionario(funcionario);

        Assertions.assertNotNull(funcionarioToSaved);

    }
}