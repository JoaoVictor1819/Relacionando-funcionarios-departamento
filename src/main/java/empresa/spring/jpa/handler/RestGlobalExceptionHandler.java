package empresa.spring.jpa.handler;


import empresa.spring.jpa.exception.BadRequestExceptionHandler;
import empresa.spring.jpa.exception.ResouceExceptionHandler;
import empresa.spring.jpa.exception.RestErroMenssage;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

@RestControllerAdvice
public class RestGlobalExceptionHandler{

    @ExceptionHandler(ResouceExceptionHandler.class)
    public ResponseEntity<RestErroMenssage> resouceExceptionHandler(ResouceExceptionHandler ex){
        RestErroMenssage restErro = RestErroMenssage.builder()
                .menssage(ex.getMessage())
                .status(HttpStatus.NOT_FOUND)
                .data(new Date())
                .build();
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(restErro);
    }

    @ExceptionHandler(BadRequestExceptionHandler.class)
    public ResponseEntity<RestErroMenssage> badRequestExceptionHandler(BadRequestExceptionHandler ex){
        RestErroMenssage erroMenssage = RestErroMenssage.builder()
                .menssage(ex.getMessage())
                .status(HttpStatus.BAD_REQUEST)
                .data(new Date())
                .build();
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(erroMenssage);
    }

    @ExceptionHandler(RuntimeException.class)
    public ResponseEntity<RestErroMenssage> runtimeExceptionHandler(RuntimeException ex){
        RestErroMenssage erroMenssage = RestErroMenssage.builder()
                .menssage(ex.getMessage())
                .status(HttpStatus.NO_CONTENT)
                .data(new Date())
                .build();
        return ResponseEntity.status(HttpStatus.NO_CONTENT).body(erroMenssage);
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<Map<String, String>> methodArgumentNotValid(MethodArgumentNotValidException ex){
        Map<String, String> errors = new HashMap<>();
        ex.getBindingResult().getFieldErrors().forEach(error ->
            errors.put(error.getField(), error.getDefaultMessage())
        );
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(errors);
    }

}
