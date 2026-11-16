package empresa.spring.jpa.entity;

import java.util.Date;

public interface ProjetosResumoProjection {


        Long getId();
        String getNome();
        String getDescricao();
        Date getData();

}
