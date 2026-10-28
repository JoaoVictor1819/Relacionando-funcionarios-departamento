package empresa.spring.jpa.repository;

import empresa.spring.jpa.entity.funcionarios.FuncionarioEntity;
import lombok.extern.log4j.Log4j2;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.data.jpa.test.autoconfigure.DataJpaTest;

import java.util.Date;
import java.util.List;
import java.util.Optional;


@DataJpaTest
@DisplayName("Test Funcionario Repository")
@Log4j2
class FuncionariosRepositoryTest {
    @Autowired
    private FuncionariosRepository funcionariosRepository;

    @Test
    @DisplayName("Save persists Funcionários when Successful")
    void save_PersisteFuncionario_WhenSuccessful(){
        FuncionarioEntity funcionarioToBeSaved = createFuncionarioToBeSaved();

        FuncionarioEntity savedFuncionario = this.funcionariosRepository.save(funcionarioToBeSaved);

        Assertions.assertThat(savedFuncionario).isNotNull();

        Assertions.assertThat(savedFuncionario.getId()).isNotNull();

        Assertions.assertThat(savedFuncionario.getNome()).isEqualTo(funcionarioToBeSaved.getNome());

    }

    @Test
    @DisplayName("Save update Funcionários when Successful")
    void save_UpdatesFuncionario_WhenSuccessful(){
        FuncionarioEntity funcionarioToBeSaved = createFuncionarioToBeSaved();

        FuncionarioEntity savedFuncionario = this.funcionariosRepository.save(funcionarioToBeSaved);

        savedFuncionario.setNome("Gilmar");

        FuncionarioEntity updateFuncionarios = this.funcionariosRepository.save(savedFuncionario);

        Assertions.assertThat(updateFuncionarios).isNotNull();

        Assertions.assertThat(updateFuncionarios.getId()).isNotNull();

        Assertions.assertThat(updateFuncionarios.getNome()).isEqualTo(funcionarioToBeSaved.getNome());

    }


    @Test
    @DisplayName("Delete removes Funcionários when Successful")
    void Delete_RemovesFuncionario_WhenSuccessful(){
        FuncionarioEntity funcionarioToBeSaved = createFuncionarioToBeSaved();

        FuncionarioEntity savedFuncionario = this.funcionariosRepository.save(funcionarioToBeSaved);

        this.funcionariosRepository.delete(savedFuncionario);

        Optional<FuncionarioEntity> funcionarioEntityOptional = this.funcionariosRepository.findById(savedFuncionario.getId());

        Assertions.assertThat(funcionarioEntityOptional.isEmpty()).isTrue();
    }


    @Test
    @DisplayName("Find by name Funcionários when Successful")
    void FindByName_ReturnListOfFuncionario_WhenSuccessful(){
        FuncionarioEntity funcionarioToBeSaved = createFuncionarioToBeSaved();

        FuncionarioEntity savedFuncionario = this.funcionariosRepository.save(funcionarioToBeSaved);

        String nome = savedFuncionario.getNome();

        List<FuncionarioEntity> funcionarios = this.funcionariosRepository.findByNomeContainingIgnoreCase(nome);

        Assertions.assertThat(funcionarios).isNotEmpty();

        Assertions.assertThat(funcionarios).contains(savedFuncionario);

    }


    @Test
    @DisplayName("Find by name returns empty list when on funcionarios is found")
    void FindByName_ReturnEmptyListOfFuncionario_WhenSuccessful(){
        List<FuncionarioEntity> funcionarios = this.funcionariosRepository.findByNomeContainingIgnoreCase("nenhum");

        Assertions.assertThat(funcionarios).isEmpty();

    }

    private FuncionarioEntity createFuncionarioToBeSaved(){
        return FuncionarioEntity.builder()
                .nome("Eduarda")
                .dataCriacao(new Date())
                .build();
    }
}