package empresa.spring.jpa.repository;

import empresa.spring.jpa.entity.FuncionariosProjetosEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FuncionarioProjetoRepository extends JpaRepository<FuncionariosProjetosEntity, Long> {
}
