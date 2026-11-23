package empresa.spring.jpa.dto.funcionariosDto;

import jakarta.validation.constraints.*;
import lombok.*;
import org.springframework.beans.factory.annotation.Value;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Builder
public class FuncionariosRequestDto {


    @NotBlank(message = "Coloque seu nome completo")
    @Max(value = 30, message = "O nome nao pode ter mais de 30 caracteres")
    public String nome;

    @Email(message = "Email esta com o formato incorreto")
    @NotNull(message = "O email e um campo obrigatorio")
    public String email;

    @NotNull(message = "A idade e um campo obrigatorio para validar seu cadastro")
    @Min(value = 18, message = "A idade minima para cadastro e de 18 anos")
    public Long idade;

    @NotBlank(message = "senha e um campo obrigatorio")
    @Size(min = 4, max = 8, message = "A senha deve ter entre 4 e 8 caracteres")
    public String senha;

    @NotNull(message = "Escolha o departamento que voce fara parte!")
    public Long idDepartamento;




}
