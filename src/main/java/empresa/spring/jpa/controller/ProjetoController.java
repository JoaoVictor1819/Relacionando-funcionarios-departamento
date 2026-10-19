package empresa.spring.jpa.controller;


import empresa.spring.jpa.dto.projetoDto.ProjetoRequesteDto;
import empresa.spring.jpa.dto.projetoDto.ProjetoResponseDto;
import empresa.spring.jpa.entity.projetos.ProjetoEntity;
import empresa.spring.jpa.service.ProjetoService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/empresa/projetos")
@RequiredArgsConstructor
public class ProjetoController {

    private final ProjetoService projetoService;


    @PostMapping
    public ResponseEntity<ProjetoEntity> saveProjeto(@Valid @RequestBody ProjetoRequesteDto dto){
        ProjetoEntity projetoEntity = projetoService.saveProjeto(dto);
        return ResponseEntity.status(HttpStatus.CREATED).body(projetoEntity);
    }

    @GetMapping
    public ResponseEntity<List<ProjetoResponseDto>> findAll(){
        List<ProjetoResponseDto> projetos = projetoService.getProjeto();
        return ResponseEntity.status(HttpStatus.OK).body(projetos);
    }
}
