package empresa.spring.jpa.entity.departamento;


import empresa.spring.jpa.entity.funcionarios.FuncionarioEntity;
import jakarta.persistence.*;
import lombok.*;

import java.math.BigDecimal;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "departamento")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Builder
public class DepartamentoEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public Long id;

    @Column(name = "Nome_Departamento",length = 100)
    public  String nome;

    @Column(name = "Salario_Departamento")
    public BigDecimal salarioFixo;

    @Column(name = "Descricao_Departamento", length = 250)
    public String descricao;



    @OneToMany(mappedBy = "departamento", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    public Set<FuncionarioEntity> funcionarios = new HashSet<>();


}
