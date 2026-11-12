package empresa.spring.jpa.entity.projection;

import java.util.Date;

public interface ProjetosResumoProjection {

    public interface ProjetoResumoProjection {
        Long getId();
        String getNome();
        String getDescricao();
        Date getData();
    }
}
