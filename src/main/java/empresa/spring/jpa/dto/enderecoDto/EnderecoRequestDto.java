package empresa.spring.jpa.dto.enderecoDto;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Builder
public class EnderecoRequestDto {

    public String cidade;

    public Long idFuncionario;

}
