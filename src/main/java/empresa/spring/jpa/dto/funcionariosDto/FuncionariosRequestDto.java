package empresa.spring.jpa.dto.funcionariosDto;

import empresa.spring.jpa.entity.departamento.DepartamentoEntity;
import empresa.spring.jpa.entity.projetos.ProjetoEntity;
import jakarta.persistence.Column;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.*;

import java.util.List;
import java.util.function.LongFunction;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Builder
public class FuncionariosRequestDto {


    @NotBlank(message = "Coloque seu nome completo")
    public String nome;

    @Email(message = "Email esta com o formato incorreto")
    @NotNull(message = "O email e um campo obrigatorio")
    public String email;

    @NotNull(message = "A idade e um campo obrigatorio para validar seu cadastro")
    @Min(value = 18, message = "A idade minima para cadastro e de 18 anos")
    public Long idade;

    @NotBlank(message = "senha e um campo obrigatorio")
    public String senha;

    @NotNull(message = "Escolha o departamento que voce fara parte!")
    public Long idDepartamento;




}
