package empresa.spring.jpa.entity.projetos;

import empresa.spring.jpa.entity.funcionarios.FuncionarioEntity;
import jakarta.persistence.*;
import lombok.*;

import java.util.HashSet;
import java.util.Set;


@Entity
@Table(name = "Projetos")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Builder
public class ProjetoEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public Long id;

    @Column(nullable = false)
    public String nome;

    @ManyToMany(mappedBy = "projetos")
    public Set<FuncionarioEntity> funcionarios = new HashSet<>();
}
