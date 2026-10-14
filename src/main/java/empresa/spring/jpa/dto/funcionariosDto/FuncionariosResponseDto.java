package empresa.spring.jpa.dto.funcionariosDto;


import empresa.spring.jpa.entity.departamento.DepartamentoEntity;
import empresa.spring.jpa.entity.funcionarios.FuncionarioEntity;
import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Builder
public class FuncionariosResponseDto {

    public Long id;

    public String nome;

    public Long idDepartamento;

    public String nomeDepartamento;

    public FuncionariosResponseDto(FuncionarioEntity f) {
        this.id = f.getId();
        this.nome = f.getNome();
        this.idDepartamento = f.getDepartamento().getId();
        this.nomeDepartamento = f.getDepartamento().getNome();
    }
}
