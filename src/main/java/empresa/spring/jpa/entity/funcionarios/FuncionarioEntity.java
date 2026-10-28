package empresa.spring.jpa.entity.funcionarios;


import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import empresa.spring.jpa.dto.funcionariosDto.FuncionariosResponseDto;
import empresa.spring.jpa.entity.departamento.DepartamentoEntity;
import empresa.spring.jpa.entity.endereco.EnderecoEntity;
import empresa.spring.jpa.entity.projetos.ProjetoEntity;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotEmpty;
import lombok.*;

import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "funcionarios")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Builder
public class FuncionarioEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public Long id;

    @Column(name = "Data_Criacao_Funcionario")
    public Date dataCriacao = new Date();

    @Column(name = "Nome_Funcionario")
    public String nome;

    @Column(name = "Email_Funcionario", unique = true)
    public String email;

    @Column(name = "Senha_Funcionario")
    public String senha;


    @OneToOne(cascade =  CascadeType.ALL, fetch = FetchType.LAZY)
    @JoinColumn(name = "endereco_id")
    public EnderecoEntity endereco;

    @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinColumn(name = "departamento_id")
    public DepartamentoEntity departamento;


    @ManyToMany
    @JoinTable(
            name = "Funcionarios_Projetos",
            joinColumns = @JoinColumn(name = "funcionario_id"),
            inverseJoinColumns = @JoinColumn(name = "projetos_id")
    )
    public Set<ProjetoEntity> projetos = new HashSet<>();

}
