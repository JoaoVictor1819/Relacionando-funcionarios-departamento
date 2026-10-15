package empresa.spring.jpa.controller;

import empresa.spring.jpa.dto.funcionariosDto.FuncionariosRequestDto;
import empresa.spring.jpa.dto.funcionariosDto.FuncionariosResponseDto;
import empresa.spring.jpa.entity.funcionarios.FuncionarioEntity;
import empresa.spring.jpa.service.FuncionariosService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/empresa/funcionarios")
@RequiredArgsConstructor
public class FuncionarioController {

    private final FuncionariosService funcionariosService;


    @PostMapping
    public ResponseEntity saveFuncionario(@Valid @RequestBody FuncionariosRequestDto funcionario){
        funcionariosService.saveFuncionario(funcionario);
        return ResponseEntity.status(HttpStatus.OK).body("Funcionario criado com sucesso");
    }


    @GetMapping
    public ResponseEntity<List<FuncionariosResponseDto>> findAllFuncionarios() {
        var funcionarios = funcionariosService.findAll();
        return  ResponseEntity.status(HttpStatus.OK).body(funcionarios);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity deleteFuncionario(@PathVariable Long id){
        funcionariosService.delete(id);
        return ResponseEntity.status(HttpStatus.OK).body("Funcionario deletado com sucesso");
    }
}
