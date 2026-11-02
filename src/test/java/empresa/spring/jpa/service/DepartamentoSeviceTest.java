package empresa.spring.jpa.service;

import empresa.spring.jpa.dto.departamentoDto.DepartamentoRequestDto;
import empresa.spring.jpa.dto.departamentoDto.DepartamentoResponseDto;
import empresa.spring.jpa.entity.departamento.DepartamentoEntity;
import empresa.spring.jpa.repository.DepartamentoRepository;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;

import java.math.BigDecimal;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.when;

class DepartamentoSeviceTest {

    @Mock
    private DepartamentoRepository departamentoRepository;

    @InjectMocks
    private DepartamentoSevice departamentoSevice;


    @Test
    @DisplayName("Should create departamento successfully everything is OK")
    void save() {
        // Arrange: Configurar o comportamento do mock
        DepartamentoEntity departamentoCreate1 = new DepartamentoEntity(
                DepartamentoRequestDto.builder()
                        .nome("Test nome")
                        .salarioFixo(new BigDecimal(4324))
                        .descricao("Test Descricao")
                        .build()
        );

        DepartamentoEntity departamentoCreate2 = new DepartamentoEntity(DepartamentoRequestDto.builder()
                .nome("Test nome2")
                .salarioFixo(new BigDecimal(4324))
                .descricao("Test Descricao2")
                .build());


        when(departamentoSevice.findById(1L)).thenReturn(DepartamentoResponseDto.builder()
                        .id(1L)
                        .nome(departamentoCreate1.getNome())
                        .salarioFixo(departamentoCreate1.getSalarioFixo())
                        .descricao(departamentoCreate1.getDescricao())
                        .build());

        this.departamentoRepository.save(departamentoCreate1);

        when(departamentoSevice.findById(2L)).thenReturn(DepartamentoResponseDto.builder()
                        .id(2L)
                        .nome(departamentoCreate2.getNome())
                        .salarioFixo(departamentoCreate2.getSalarioFixo())
                        .descricao(departamentoCreate2.getDescricao())
                        .build());
        this.departamentoRepository.save(departamentoCreate2);

    }
}