package empresa.spring.jpa.service;

import empresa.spring.jpa.dto.departamentoDto.DepartamentoRequestDto;
import empresa.spring.jpa.dto.departamentoDto.DepartamentoResponseDto;
import empresa.spring.jpa.entity.departamento.DepartamentoEntity;

import empresa.spring.jpa.repository.DepartamentoRepository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import java.math.BigDecimal;
import java.util.Collections;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(MockitoExtension.class)
class DepartamentoSeviceTest {


    @InjectMocks
    private DepartamentoSevice departamentoSevice;

    @Mock
    private DepartamentoRepository departamentoRepository;

    @Test
    @DisplayName("Deve retornar uma lista de departamento")
    public void deveRetornarUmaListaDeDepartamento(){
        DepartamentoEntity departamentoRequest = new DepartamentoEntity(
                DepartamentoRequestDto.builder()
                        .nome("Departamento Teste")
                        .descricao("Descricao")
                        .salarioFixo(new BigDecimal(3432))
                        .build()
        );

        Mockito.when(departamentoRepository.findAll()).thenReturn(Collections.singletonList(departamentoRequest));
        List<DepartamentoResponseDto> departamento = departamentoSevice.findAll();

        Assertions.assertEquals(1, departamento.size());

    }

    @Test
    public void deveLancarExcecaoAoTentarSalvarDepartamentoExistente(){
        DepartamentoRequestDto departamentoRequest = DepartamentoRequestDto.builder()
                .nome("Departamento Teste")
                .descricao("Descricao")
                .salarioFixo(new BigDecimal(3432))
                .build();

        DepartamentoEntity departamentoEntity = new DepartamentoEntity(departamentoRequest);

        Mockito.when(departamentoRepository.findByNome(departamentoRequest.getNome()))
                .thenReturn(java.util.Optional.of(departamentoEntity));

        Assertions.assertThrows(RuntimeException.class, () -> {departamentoSevice.save(departamentoRequest);});
    }

}