package empresa.spring.jpa.dto.departamentoDto;


import empresa.spring.jpa.dto.funcionariosDto.FuncionariosResponseDto;
import empresa.spring.jpa.entity.funcionarios.FuncionarioEntity;
import lombok.*;

import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Builder
public class DepartamentoResponseDto {

    public Long id;

    public  String nome;

    public List<FuncionariosResponseDto> funcionarios;
}
