package empresa.spring.jpa.service;

import empresa.spring.jpa.dto.funcionariosDto.FuncionariosRequestDto;
import empresa.spring.jpa.entity.funcionarios.FuncionarioEntity;
import empresa.spring.jpa.repository.FuncionariosRepository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;

import static org.mockito.Mockito.*;


@ExtendWith(MockitoExtension.class)
class FuncionariosServiceTest {

    @InjectMocks
    FuncionariosService funcionariosService;

    @Mock
    FuncionariosRepository funcionariosRepository;

    @BeforeEach
    void setUp() {
        FuncionarioEntity funcionario = new FuncionarioEntity(
                FuncionariosRequestDto.builder()
                        .nome("Victor")
                        .email("Exemplo@gmail.com")
                        .senha("senha123")
                        .build());


        lenient().when(funcionariosRepository.findAll()).thenReturn(List.of(funcionario));
    }

    @Test
    public void deveRetornarUmaList() {
        List<FuncionarioEntity> funcionarios = funcionariosRepository.findAll();

        Assertions.assertEquals(1, funcionarios.size());

        verify(funcionariosRepository).findAll();
        verifyNoMoreInteractions(funcionariosRepository);

    }
}