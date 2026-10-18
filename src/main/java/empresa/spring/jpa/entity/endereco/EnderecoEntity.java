package empresa.spring.jpa.entity.endereco;


import jakarta.persistence.*;
import lombok.*;


@Entity
@Table(name = "Enderecos")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Builder
public class EnderecoEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public Long id;

    @Column(name = "Cep_Funcionario")
    public String cep;

    @Column(name = "Estado_Funcionario")
    public String estado;

    @Column(name = "Cidade_Funcionario")
    public String cidade;

    @Column(name = "Rua_Funcionario")
    public String rua;

    @Column(name = "NumeroResidencia_Funcionario")
    public Integer numeroCasa;

}
