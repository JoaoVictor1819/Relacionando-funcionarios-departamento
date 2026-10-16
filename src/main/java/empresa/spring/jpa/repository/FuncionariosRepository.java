package empresa.spring.jpa.repository;

import empresa.spring.jpa.entity.funcionarios.FuncionarioEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface FuncionariosRepository extends JpaRepository<FuncionarioEntity, Long> {


    Optional<FuncionarioEntity> findByDepartamento(Long IdDepartamento);
}
