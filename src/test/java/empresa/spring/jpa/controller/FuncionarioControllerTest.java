package empresa.spring.jpa.controller;

import empresa.spring.jpa.service.FuncionariosService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(SpringExtension.class)
class FuncionarioControllerTest {
    @InjectMocks
     private FuncionarioController funcionarioController;
    @Mock
    private FuncionariosService funcionariosServiceMock;

    @Test
    void test(){

    }
}