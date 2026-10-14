package empresa.spring.jpa.dto.departamentoDto;


import jakarta.validation.constraints.NotBlank;
import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Builder
public class DepartamentoRequestDto {

    @NotBlank(message = "O nome e obrigario")
    public String nome;
}
