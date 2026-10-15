package empresa.spring.jpa.dto.funcionariosDto;


import empresa.spring.jpa.entity.departamento.DepartamentoEntity;
import empresa.spring.jpa.entity.funcionarios.FuncionarioEntity;
import lombok.*;

import java.util.Date;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Builder
public class FuncionariosResponseDto {

    public Long id;

    public Date dataCriacao = new Date();

    public String nome;

    public String email;

    public Long idDepartamento;

    public String nomeDepartamento;

    public FuncionariosResponseDto(FuncionarioEntity f) {
        this.id = f.getId();
        this.dataCriacao = f.getDataCriacao();
        this.nome = f.getNome();
        this.email = f.getEmail();
        this.idDepartamento = f.getDepartamento().getId();
        this.nomeDepartamento = f.getDepartamento().getNome();
    }
}
