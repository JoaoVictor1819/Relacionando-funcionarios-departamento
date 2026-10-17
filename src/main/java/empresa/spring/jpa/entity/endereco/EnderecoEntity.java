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

    public String cidade;
}
