package empresa.spring.jpa.dto.enderecoDto;

import jakarta.persistence.Column;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Builder
public class EnderecoRequestDto {

    @NotBlank(message = "O cep e um campo obrigatorio!")
    public String cep;

    @NotBlank(message = "O estado e um campo obrigatorio!")
    public String estado;

    @NotBlank(message = "A cidade e um campo obrigatorio!")
    public String cidade;

    @NotBlank(message = "A Rua e um campo obrigatorio!")
    public String rua;

    @NotBlank(message = "O numero da residencia e um campo obrigatorio!")
    public Integer numeroCasa;

    @NotNull(message = "O id do funcionario e obrigatorio para cadastrar o endereco!")
    public Long idFuncionario;

}
