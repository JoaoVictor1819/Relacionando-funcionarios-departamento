package empresa.spring.jpa.repository;

import empresa.spring.jpa.dto.projetoDto.ProjetoResponseDto;
import empresa.spring.jpa.entity.ProjetosResumoProjection;
import empresa.spring.jpa.entity.projetos.ProjetoEntity;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.NativeQuery;

public interface ProjetoRepository extends JpaRepository<ProjetoEntity, Long> {

    @NativeQuery(
            value = """
        SELECT p.id AS id,
               p.Nome_Projeto AS nome,
               p.Descricao_Projeto AS descricao,
               p.Criacao_Projeto_Data AS data
        FROM Projetos p
        ORDER BY p.id
        """,
            countQuery = "SELECT COUNT(*) FROM Projetos"
    )
    Page<ProjetosResumoProjection> getAllProjetePageable(Pageable pageable);
}
