package empresa.spring.jpa.dto.projetoDto;


import empresa.spring.jpa.dto.funcionariosDto.FuncionariosResponseDto;
import empresa.spring.jpa.entity.funcionarios.FuncionarioEntity;
import lombok.*;

import java.util.List;
import java.util.Set;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Builder
public class ProjetoResponseDto {

    public Long id;

    public String name;

//    public List<FuncionariosResponseDto> funcionarios;

}
