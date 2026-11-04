package empresa.spring.jpa.service;

import empresa.spring.jpa.dto.departamentoDto.DepartamentoRequestDto;
import empresa.spring.jpa.entity.departamento.DepartamentoEntity;
import empresa.spring.jpa.repository.DepartamentoRepository;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.util.Assert;

import java.math.BigDecimal;
import java.util.Optional;

class DepartamentoSeviceTest {

    @Mock
    DepartamentoRepository departamentoRepository;

    @InjectMocks
    DepartamentoSevice departamentoSevice;


    @Test
    @DisplayName("It should successfully save the Department to the database.")
    void SaveDepartamento() {
        // Given / Arrange

        DepartamentoEntity departamento = new DepartamentoEntity(
                DepartamentoRequestDto.builder()
                        .nome("Victor")
                        .descricao("Descricao")
                        .salarioFixo(new BigDecimal(2032))
                        .build()
        );

        //when / Act

        DepartamentoEntity save = this.departamentoRepository.save(departamento);


        //then / Assert

        Assert.notNull(save.getNome(), "Departamento salvo com sucesso");


    }




}