package empresa.spring.jpa.dto.funcionariosDto;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Builder
public class FuncionariosRequestDto {


    public String nome;

    public Long idDepartamento;
}
