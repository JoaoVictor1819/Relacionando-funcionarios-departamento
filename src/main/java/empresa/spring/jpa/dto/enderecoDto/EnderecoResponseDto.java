package empresa.spring.jpa.dto.enderecoDto;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Builder
public class EnderecoResponseDto {

    public Long id;

    public String cep;

    public String estado;

    public String cidade;

    public String rua;

    public Integer numeroCasa;
}
