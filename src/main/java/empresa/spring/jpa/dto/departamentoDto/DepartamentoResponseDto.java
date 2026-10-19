package empresa.spring.jpa.dto.departamentoDto;


import empresa.spring.jpa.dto.funcionariosDto.FuncionariosResponseDto;
import empresa.spring.jpa.dto.projetoDto.ProjetoResponseDto;
import empresa.spring.jpa.entity.funcionarios.FuncionarioEntity;
import jakarta.persistence.Column;
import lombok.*;

import java.math.BigDecimal;
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

    public BigDecimal salarioFixo;

    public String descricao;

    public List<FuncionariosResponseDto> funcionarios;

}
