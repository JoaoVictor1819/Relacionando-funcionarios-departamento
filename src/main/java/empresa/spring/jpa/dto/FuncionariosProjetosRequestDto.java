package empresa.spring.jpa.dto;

import lombok.*;

import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Builder
public class FuncionariosProjetosRequestDto {

    public List<Long> idFuncionario;

    public List<Long> idProjeto;
}
