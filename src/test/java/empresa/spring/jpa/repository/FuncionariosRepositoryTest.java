package empresa.spring.jpa.repository;

import empresa.spring.jpa.entity.funcionarios.FuncionarioEntity;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.data.jpa.test.autoconfigure.DataJpaTest;


@DataJpaTest
@DisplayName("Test Funcionario Repository")
class FuncionariosRepositoryTest {
    @Autowired
    private FuncionariosRepository funcionariosRepository;

    @Test
    @DisplayName("Save create Funcionários when Successful")
    void save_PersisteFuncionario_WhenSuccessful(){
        FuncionarioEntity funcionarioToBeSaved = createFuncionarioToBeSaved();
        FuncionarioEntity savedFuncionario = this.funcionariosRepository.save(funcionarioToBeSaved);
        Assertions.assertThat(savedFuncionario).isNotNull();
        Assertions.assertThat(savedFuncionario.getId()).isNotNull();
        Assertions.assertThat(savedFuncionario.getNome()).isEqualTo(funcionarioToBeSaved.getNome());

    }

    private FuncionarioEntity createFuncionarioToBeSaved(){
        return FuncionarioEntity.builder()
                .nome("Eduarda")
                .build();
    }
}