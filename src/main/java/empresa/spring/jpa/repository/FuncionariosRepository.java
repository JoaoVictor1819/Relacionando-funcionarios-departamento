package empresa.spring.jpa.repository;

import empresa.spring.jpa.entity.funcionarios.FuncionarioEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FuncionariosRepository extends JpaRepository<FuncionarioEntity, Long> {
}
