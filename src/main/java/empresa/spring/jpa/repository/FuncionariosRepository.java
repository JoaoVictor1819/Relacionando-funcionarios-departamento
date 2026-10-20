package empresa.spring.jpa.repository;

import empresa.spring.jpa.entity.FuncionarioResumoProjection;
import empresa.spring.jpa.entity.funcionarios.FuncionarioEntity;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.NativeQuery;

import java.util.Optional;

public interface FuncionariosRepository extends JpaRepository<FuncionarioEntity, Long> {


    Optional<FuncionarioEntity> findByDepartamento(Long IdDepartamento);

    @NativeQuery(
            value = """
        SELECT f.id AS id,
               f.Nome_Funcionario AS nome,
               f.Email_Funcionario AS email,
               d.id AS idDepartamento,
               d.Nome_Departamento AS nomeDepartamento
        FROM funcionarios f
        JOIN departamento d ON d.id = f.departamento_id
        ORDER BY f.id
        """,
            countQuery = "SELECT COUNT(*) FROM funcionarios"
    )
    Page<FuncionarioResumoProjection> getAllFuncionarioPage(Pageable pegeable);
}
