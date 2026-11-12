package empresa.spring.jpa.controller;

import empresa.spring.jpa.dto.funcionariosDto.FuncionariosRequestDto;
import empresa.spring.jpa.dto.funcionariosDto.FuncionariosResponseDto;
import empresa.spring.jpa.entity.projection.FuncionarioResumoProjection;
import empresa.spring.jpa.service.FuncionariosService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/empresa/funcionarios")
@RequiredArgsConstructor
@Tag(name = "Gerenciador de funcionarios")
public class FuncionarioController {

    private final FuncionariosService funcionariosService;


    @PostMapping
    @Operation(summary = "Criar Funcionario", description = "Metodo responsavel pela criacao de funcionarios")
    public ResponseEntity saveFuncionario(@Valid @RequestBody FuncionariosRequestDto funcionario){
        funcionariosService.saveFuncionario(funcionario);
        return ResponseEntity.status(HttpStatus.CREATED).body("Funcionario criado com sucesso");
    }


    @GetMapping
    @Operation(summary = "Listar Funcionarios", description = "Metodo responsavel por listar todos os funcionarios")
    public ResponseEntity<List<FuncionariosResponseDto>> findAllFuncionarios() {
        var funcionarios = funcionariosService.findAllFuncionarios();
        return  ResponseEntity.status(HttpStatus.OK).body(funcionarios);
    }

    @GetMapping("/funcionarioList/{name}")
    @Operation(summary = "Buscar Funcionario por nome", description = "Metodo responsavel por buscar funcionario pelo nome")
    public ResponseEntity<List<FuncionariosResponseDto>> findByNameList(@PathVariable String name){
        List<FuncionariosResponseDto> funcionariosResponseDtos = funcionariosService.listFuncionariosName(name);
        return ResponseEntity.status(HttpStatus.OK).body(funcionariosResponseDtos);
    }

    @GetMapping("/page/{page}/size/{size}")
    @Operation(summary = "Listar Funcionarios por pagina", description = "Metodo responsavel por listar todos os funcionarios por pagina")
    public ResponseEntity<Page<FuncionarioResumoProjection>> pageableFuncionarioAll(@PathVariable Integer page, @PathVariable Integer size) {
        Page<FuncionarioResumoProjection> funcionarioResumoProjections = funcionariosService.findAllFuncionariosPage(page, size);
        return ResponseEntity.status(HttpStatus.OK).body(funcionarioResumoProjections);
    }

    @PutMapping("/{id}")
    @Operation(summary = "Atualizar Funcionario", description = "Metodo responsavel por atualizar funcionario pelo id")
    public ResponseEntity<FuncionariosResponseDto> updateFuncionario(@PathVariable Long id, @Valid @RequestBody FuncionariosRequestDto dto){
        FuncionariosResponseDto funcionario = funcionariosService.update(id, dto);
        return ResponseEntity.status(HttpStatus.OK).body(funcionario);
    }

    @DeleteMapping("/{id}")
    @Operation(summary = "Deletar Funcionario", description = "Metodo responsavel por deletar funcionario pelo id")
    public ResponseEntity deleteFuncionario(@PathVariable Long id){
        funcionariosService.delete(id);
        return ResponseEntity.status(HttpStatus.OK).body("Funcionario deletado com sucesso");
    }
}
