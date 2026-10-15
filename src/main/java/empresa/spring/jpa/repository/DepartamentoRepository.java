package empresa.spring.jpa.repository;

import empresa.spring.jpa.entity.departamento.DepartamentoEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.NativeQuery;

import java.util.List;
import java.util.Optional;

public interface DepartamentoRepository extends JpaRepository<DepartamentoEntity, Long> {


    List<DepartamentoEntity> findByNomeContainingIgnoreCase(String name);

    Optional<DepartamentoEntity> findByNome(String name);


}
