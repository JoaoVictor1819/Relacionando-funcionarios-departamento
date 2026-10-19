package empresa.spring.jpa.repository;

import empresa.spring.jpa.entity.endereco.EnderecoEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface EnderecoRepository extends JpaRepository<EnderecoEntity, Long> {

    List<EnderecoEntity> findByEstadoContainingIgnoreCase(String estado);
}
