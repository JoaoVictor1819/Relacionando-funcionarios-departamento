package empresa.spring.jpa.entity;

public interface FuncionarioResumoProjection {

    Long getId();
    String getNome();
    String getEmail();
    Long getIdDepartamento();
    String getNomeDepartamento();
}
