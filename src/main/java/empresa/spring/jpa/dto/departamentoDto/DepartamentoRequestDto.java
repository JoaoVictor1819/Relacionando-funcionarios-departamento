package empresa.spring.jpa.dto.departamentoDto;


import jakarta.persistence.Column;
import jakarta.validation.constraints.*;
import lombok.*;

import java.math.BigDecimal;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Builder
public class DepartamentoRequestDto {

    @NotBlank(message = "O nome e obrigario")
    public String nome;

    @NotNull(message = "Salario tem que ter um valor obrigatorio inserido")
    @DecimalMin(value = "1620", inclusive = false, message = "O salario nao poder ser menor doque o valor minimo")
    @DecimalMax(value = "20000", message = "O valor nao pode ultrapassar do teto salariao maximo")
    public BigDecimal salarioFixo;

    @NotBlank(message = "O campo de descricao e obrigatorio")
    public String descricao;
}
