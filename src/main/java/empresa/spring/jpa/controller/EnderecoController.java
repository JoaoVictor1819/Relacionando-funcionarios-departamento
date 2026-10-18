package empresa.spring.jpa.controller;


import empresa.spring.jpa.dto.enderecoDto.EnderecoRequestDto;
import empresa.spring.jpa.dto.enderecoDto.EnderecoResponseDto;
import empresa.spring.jpa.service.EnderecoService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/empresa/funcionario/endereco")
@RequiredArgsConstructor
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
}
