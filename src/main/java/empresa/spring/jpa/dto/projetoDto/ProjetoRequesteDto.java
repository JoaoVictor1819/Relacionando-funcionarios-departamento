package empresa.spring.jpa.dto.projetoDto;


import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.*;

import java.util.Date;
import java.util.List;
import java.time.LocalDate;

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

    public List<Long> idFuncionario;

    @NotNull(message = "O prazo final do projeto e obrigatorio")
    public LocalDate prazoFinal;


}
