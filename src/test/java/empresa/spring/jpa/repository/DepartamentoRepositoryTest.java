package empresa.spring.jpa.repository;

import empresa.spring.jpa.dto.departamentoDto.DepartamentoRequestDto;
import empresa.spring.jpa.entity.departamento.DepartamentoEntity;
import jakarta.persistence.EntityManager;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.data.jpa.test.autoconfigure.DataJpaTest;
import org.springframework.test.context.ActiveProfiles;

import java.math.BigDecimal;
import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;

@DataJpaTest
@ActiveProfiles("testdb")
class DepartamentoRepositoryTest {

    @Autowired
    DepartamentoRepository departamentoRepository;

    @Autowired
    EntityManager entityManager;

    @Test
    @DisplayName("Should get User successfully from DB")
    void findByNomeSuccessCase1() {
        DepartamentoEntity departamento = new DepartamentoEntity(
                DepartamentoRequestDto.builder()
                        .nome("Victor")
                        .descricao("Descricao")
                        .salarioFixo(new BigDecimal(2032))
                        .build());

        this.departamentoRepository.save(departamento);

        Optional<DepartamentoEntity> resultByNome = this.departamentoRepository.findByNome(departamento.getNome());

        assertThat(resultByNome.isPresent()).isTrue();

    }

    @Test
    @DisplayName("Should not get User from DB when user not exists")
    void findByNomeSuccessCase2() {
        DepartamentoEntity departamento = new DepartamentoEntity(
                DepartamentoRequestDto.builder()
                        .build());


        Optional<DepartamentoEntity> resultByNome = this.departamentoRepository.findByNome(departamento.getNome());

        assertThat(resultByNome.isEmpty()).isTrue();

    }


    private DepartamentoEntity creatDepartamento(DepartamentoRequestDto dto){
         DepartamentoEntity newDepartamento = new DepartamentoEntity(dto);
         this.entityManager.persist(newDepartamento);
         return newDepartamento;
    }
}