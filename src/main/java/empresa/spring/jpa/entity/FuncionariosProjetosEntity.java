package empresa.spring.jpa.entity;


import empresa.spring.jpa.entity.funcionarios.FuncionarioEntity;
import empresa.spring.jpa.entity.projetos.ProjetoEntity;
import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "funcionarios_projetos")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Builder
public class FuncionariosProjetosEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public Long id;


    public FuncionarioEntity funcionario;

    public ProjetoEntity projeto;
}
