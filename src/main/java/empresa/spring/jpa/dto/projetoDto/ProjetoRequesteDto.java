package empresa.spring.jpa.dto.projetoDto;


import jakarta.validation.constraints.NotBlank;
import lombok.*;

import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Builder
public class ProjetoRequesteDto {

    @NotBlank(message = "Este campo de nome e obrigatorio")
    public String nome;

    @NotBlank(message = "Descreva como funciona o projeto criado")
    public String descricao;


}
