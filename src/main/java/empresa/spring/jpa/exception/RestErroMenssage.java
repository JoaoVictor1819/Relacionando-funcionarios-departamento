package empresa.spring.jpa.exception;


import lombok.*;
import org.springframework.http.HttpStatus;

import java.util.Date;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class RestErroMenssage {

    public String menssage;
    public HttpStatus status;
    public Date data = new Date();

}
