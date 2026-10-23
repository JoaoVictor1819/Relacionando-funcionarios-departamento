package empresa.spring.jpa.controller;


import empresa.spring.jpa.dto.projetoDto.ProjetoRequesteDto;
import empresa.spring.jpa.dto.projetoDto.ProjetoResponseDto;
import empresa.spring.jpa.entity.ProjetosResumoProjection;
import empresa.spring.jpa.entity.projetos.ProjetoEntity;
import empresa.spring.jpa.service.ProjetoService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
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
        List<ProjetoResponseDto> projetos = projetoService.getProjetoAll();
        return ResponseEntity.status(HttpStatus.OK).body(projetos);
    }

    @GetMapping("/page/{page}/size/{size}")
    public ResponseEntity<Page<ProjetosResumoProjection>> findByPage(@PathVariable Integer page, @PathVariable Integer size){
        Page<ProjetosResumoProjection> projetoEntityPage = projetoService.getAllProjetoPage(page, size);
        return  ResponseEntity.status(HttpStatus.OK).body(projetoEntityPage);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity deleteProjet(@PathVariable Long id){
        projetoService.deleteProjeto(id);
        return  ResponseEntity.status(HttpStatus.NO_CONTENT).body("Projeto deletado com sucesso!");
    }

    @PutMapping("/{id}")
    public ResponseEntity<ProjetoResponseDto> updateProjeto(@Valid @RequestBody ProjetoRequesteDto dto, @PathVariable Long id){
        ProjetoResponseDto projetoResponseDto = projetoService.update(id, dto);
        return ResponseEntity.status(HttpStatus.OK).body(projetoResponseDto);
    }


}
