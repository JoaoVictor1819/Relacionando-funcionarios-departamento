package empresa.spring.jpa.service;

import empresa.spring.jpa.dto.departamentoDto.DepartamentoResponseDto;
import empresa.spring.jpa.repository.DepartamentoRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(MockitoExtension.class)
class DepartamentoSeviceTest {


    @InjectMocks
    private DepartamentoSevice departamentoSevice;

    @Mock
    private DepartamentoRepository departamentoRepository;

    @Test
    public void deveRetornarUmaListaDeDepartamento(){
        List<DepartamentoResponseDto> departamento = departamentoSevice.findAll();

    }

}