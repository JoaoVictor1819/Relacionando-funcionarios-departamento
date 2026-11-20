package empresa.spring.jpa.dto.projetoDto;


import empresa.spring.jpa.dto.funcionariosDto.FuncionariosResponseDto;
import lombok.*;

import java.time.LocalDateTime;
import java.util.Date;
import java.util.List;
import java.time.LocalDate;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Builder
public class ProjetoResponseDto {

    public Long id;

    public LocalDateTime data;

    public String nome;

    public String descricao;

    public List<FuncionariosResponseDto> funcionario;

    public LocalDate prazoFinal;

}
