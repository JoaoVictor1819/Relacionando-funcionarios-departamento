package empresa.spring.jpa.repository;

import empresa.spring.jpa.entity.projetos.ProjetoEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProjetoRepository extends JpaRepository<ProjetoEntity, Long> {
}
