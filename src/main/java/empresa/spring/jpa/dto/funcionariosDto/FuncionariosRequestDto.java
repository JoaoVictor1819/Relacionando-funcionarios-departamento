package empresa.spring.jpa.dto.funcionariosDto;

import jakarta.persistence.Column;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.*;

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

    @NotBlank(message = "senha e um campo obrigatorio")
    public String senha;

    @NotNull(message = "Escolha o departamento que voce fara parte!")
    public Long idDepartamento;


}
