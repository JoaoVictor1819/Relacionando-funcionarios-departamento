package empresa.spring.jpa.controller;


import empresa.spring.jpa.dto.enderecoDto.EnderecoRequestDto;
import empresa.spring.jpa.dto.enderecoDto.EnderecoResponseDto;
import empresa.spring.jpa.service.EnderecoService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/empresa/funcionario/endereco")
@RequiredArgsConstructor
@Tag(name = "Gerengiador de Endereco de funcionarios")
public class EnderecoController {

    private final EnderecoService enderecoService;


    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    @Operation(summary = "Criar Endereco", description = "Metodo responsavel pela criacao de enderecos para funcionarios")
    public void saveEndereco(@Valid @RequestBody EnderecoRequestDto dto){
        enderecoService.saveEndereco(dto);
    }


    @GetMapping
    @Operation(summary = "Listar Enderecos", description = "Metodo responsavel por listar todos os enderecos")
    public ResponseEntity<List<EnderecoResponseDto>> findAllEndereco(){
        List<EnderecoResponseDto> enderecoResponseDto = enderecoService.findAllEndereco();
        return ResponseEntity.status(HttpStatus.OK).body(enderecoResponseDto);
    }

    @GetMapping("/search/estado")
    @Operation(summary = "Buscar Endereco por estado", description = "Metodo responsavel por buscar endereco pelo estado")
    public ResponseEntity<List<EnderecoResponseDto>> findByEstado(@RequestParam String estado){
        List<EnderecoResponseDto> enderecoResponseDto = enderecoService.findByEstado(estado);
        return ResponseEntity.status(HttpStatus.OK).body(enderecoResponseDto);
    }


    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    @Operation(summary = "Deletar Endereco", description = "Metodo responsavel por deletar endereco pelo id")
    public void deleteEndereco(@PathVariable Long id){
        enderecoService.deleteEndereco(id);
    }

    @PutMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    @Operation(summary = "Atualizar Endereco", description = "Metodo responsavel por atualizar endereco pelo id")
    public void updateEndereco(@PathVariable Long id, @Valid @RequestBody EnderecoRequestDto dto){
        enderecoService.UpdateEndereco(id, dto);
    }
}
