package empresa.spring.jpa.entity.projetos;

import empresa.spring.jpa.entity.funcionarios.FuncionarioEntity;
import jakarta.persistence.*;
import lombok.*;

import java.util.Date;
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

    @Column(name = "Criacao_Projeto_Data")
    public Date data = new Date();

    @Column(name = "Nome_Projeto",nullable = false)
    public String nome;

    @Column(name = "Descricao_Projeto",nullable = false)
    public String descricao;

    @ManyToMany(mappedBy = "projetos")
    public Set<FuncionarioEntity> funcionarios = new HashSet<>();
}
