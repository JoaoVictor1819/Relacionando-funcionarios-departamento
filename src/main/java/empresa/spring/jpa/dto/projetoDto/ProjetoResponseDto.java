package empresa.spring.jpa.dto.projetoDto;


import empresa.spring.jpa.dto.funcionariosDto.FuncionariosResponseDto;
import lombok.*;

import java.util.Date;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Builder
public class ProjetoResponseDto {

    public Long id;

    public Date data = new Date();

    public String nome;

    public String descricao;

    public List<FuncionariosResponseDto> funcionario;

}
