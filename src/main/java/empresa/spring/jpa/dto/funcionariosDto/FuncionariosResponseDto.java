package empresa.spring.jpa.dto.funcionariosDto;


import empresa.spring.jpa.dto.enderecoDto.EnderecoResponseDto;
import empresa.spring.jpa.dto.projetoDto.ProjetoResponseDto;
import empresa.spring.jpa.entity.endereco.EnderecoEntity;
import empresa.spring.jpa.entity.funcionarios.FuncionarioEntity;
import empresa.spring.jpa.entity.projetos.ProjetoEntity;
import lombok.*;

import java.util.Date;
import java.util.List;
import java.util.Optional;
import java.util.Set;

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

    public EnderecoEntity endereco;

    public List<ProjetoResponseDto> projeto;



    public FuncionariosResponseDto(FuncionarioEntity f) {
        this.id = f.getId();
        this.dataCriacao = f.getDataCriacao();
        this.nome = f.getNome();
        this.email = f.getEmail();
        this.idDepartamento = f.getDepartamento().getId();
        this.nomeDepartamento = f.getDepartamento().getNome();
        this.endereco = f.getEndereco();

    }

    public FuncionariosResponseDto(Long id, Date dataCriacao, String nome, String email, Long id1, String nome1, EnderecoEntity endereco, Set<ProjetoEntity> projetos) {
    }
}
