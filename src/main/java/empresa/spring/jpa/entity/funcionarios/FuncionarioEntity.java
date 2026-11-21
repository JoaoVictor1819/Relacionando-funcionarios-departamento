package empresa.spring.jpa.entity.funcionarios;


import empresa.spring.jpa.dto.funcionariosDto.FuncionariosRequestDto;
import empresa.spring.jpa.entity.departamento.DepartamentoEntity;
import empresa.spring.jpa.entity.endereco.EnderecoEntity;
import empresa.spring.jpa.entity.projetos.ProjetoEntity;
import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.CreationTimestamp;

import java.time.LocalDateTime;
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
    @CreationTimestamp
    public LocalDateTime dataCriacaoFuncionario = LocalDateTime.now();

    @Column(name = "Nome_Funcionario")
    public String nome;

    @Column(name = "Idade_Funcionario")
    public Long idade;

    @Column(name = "Email_Funcionario", unique = true)
    public String email;

    @Column(name = "Senha_Funcionario", length = 18, unique = true)
    public String senha;


    @OneToOne(cascade =  CascadeType.ALL, fetch = FetchType.LAZY)
    @JoinColumn(name = "endereco_id")
    public EnderecoEntity endereco;

    @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinColumn(name = "departamento_id")
    public DepartamentoEntity departamento;


    @ManyToMany(mappedBy = "funcionario",fetch = FetchType.LAZY)
    public Set<ProjetoEntity> projeto = new HashSet<>();

    public FuncionarioEntity(FuncionariosRequestDto dto) {
        this.nome = dto.nome;
        this.idade = dto.idade;
        this.email = dto.email;
        this.senha = dto.senha;
    }
}
