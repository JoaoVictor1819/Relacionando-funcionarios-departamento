package empresa.spring.jpa.repository;

import empresa.spring.jpa.entity.departamento.DepartamentoEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DepartamentoRepository extends JpaRepository<DepartamentoEntity, Long> {
}
