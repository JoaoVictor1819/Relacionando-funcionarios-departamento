package empresa.spring.jpa.controller;


import empresa.spring.jpa.dto.enderecoDto.EnderecoRequestDto;
import empresa.spring.jpa.dto.enderecoDto.EnderecoResponseDto;
import empresa.spring.jpa.service.EnderecoService;
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
    public ResponseEntity saveEndereco(@Valid @RequestBody EnderecoRequestDto dto){
        enderecoService.saveEndereco(dto);
        return ResponseEntity.status(HttpStatus.CREATED).body("Endereco Criado para usuario");
    }


    @GetMapping
    public ResponseEntity<List<EnderecoResponseDto>> findAllEndereco(){
        List<EnderecoResponseDto> enderecoResponseDto = enderecoService.findAllEndereco();
        return ResponseEntity.status(HttpStatus.OK).body(enderecoResponseDto);
    }

    @GetMapping("/search/estado")
    public ResponseEntity<List<EnderecoResponseDto>> findByEstado(@RequestParam String estado){
        List<EnderecoResponseDto> enderecoResponseDto = enderecoService.findByEstado(estado);
        return ResponseEntity.status(HttpStatus.OK).body(enderecoResponseDto);
    }


    @DeleteMapping("/{id}")
    public ResponseEntity deleteEndereco(@PathVariable Long id){
        enderecoService.deleteEndereco(id);
        return ResponseEntity.status(HttpStatus.OK).body("Endereco Deletado para usuario");
    }

    @PutMapping("/{id}")
    public ResponseEntity updateEndereco(@PathVariable Long id, @Valid @RequestBody EnderecoRequestDto dto){
        enderecoService.UpdateEndereco(id, dto);
        return ResponseEntity.status(HttpStatus.OK).body("Endereco Atualizado para usuario");
    }
}
