package empresa.spring.jpa.dto.projetoDto;


import empresa.spring.jpa.dto.funcionariosDto.FuncionariosResponseDto;
import empresa.spring.jpa.entity.funcionarios.FuncionarioEntity;
import jakarta.persistence.Column;
import lombok.*;

import java.util.Date;
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

    public Date data = new Date();

    public String nome;

    public String descricao;

//    public List<FuncionariosResponseDto> funcionarios;

}
