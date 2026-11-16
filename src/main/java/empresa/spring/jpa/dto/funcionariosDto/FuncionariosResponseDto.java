package empresa.spring.jpa.dto.funcionariosDto;


import empresa.spring.jpa.entity.endereco.EnderecoEntity;
import empresa.spring.jpa.entity.funcionarios.FuncionarioEntity;
import lombok.*;

import java.time.LocalDateTime;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Builder
public class FuncionariosResponseDto {

    public Long id;

    public LocalDateTime dataCriacao;

    public String nome;

    public Long idade;

    public String email;

    public Long idDepartamento;

    public String nomeDepartamento;

    public EnderecoEntity endereco;




    public FuncionariosResponseDto(FuncionarioEntity f) {
        this.id = f.getId();
        this.dataCriacao = f.getDataCriacaoFuncionario();
        this.nome = f.getNome();
        this.idade = f.getIdade();
        this.email = f.getEmail();
        this.idDepartamento = f.getDepartamento().getId();
        this.nomeDepartamento = f.getDepartamento().getNome();
        this.endereco = f.getEndereco();

    }


    
}
