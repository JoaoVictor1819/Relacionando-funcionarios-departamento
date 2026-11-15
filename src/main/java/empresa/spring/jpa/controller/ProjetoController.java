package empresa.spring.jpa.controller;


import empresa.spring.jpa.dto.projetoDto.ProjetoRequesteDto;
import empresa.spring.jpa.dto.projetoDto.ProjetoResponseDto;
import empresa.spring.jpa.entity.ProjetosResumoProjection;
import empresa.spring.jpa.service.ProjetoService;
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
@RequestMapping("/empresa/projetos")
@RequiredArgsConstructor
@Tag(name = "Gerenciador de Projetos")
public class ProjetoController {

    private final ProjetoService projetoService;


    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    @Operation(summary = "Criar Projeto", description = "Metodo responsavel pela criacao de projetos")
    public void saveProjeto(@Valid @RequestBody ProjetoRequesteDto dto){
        projetoService.saveProjeto(dto);
    }

    @GetMapping
    @Operation(summary = "Listar Projetos", description = "Metodo responsavel por listar todos os projetos")
    public ResponseEntity<List<ProjetoResponseDto>> findAll(){
        List<ProjetoResponseDto> projetos = projetoService.getProjetoAll();
        return ResponseEntity.status(HttpStatus.OK).body(projetos);
    }

    @GetMapping("/page/{page}/size/{size}")
    @Operation(summary = "Listar Projetos por pagina", description = "Metodo responsavel por listar todos os projetos por pagina")
    public ResponseEntity<Page<ProjetosResumoProjection>> findByPage(@PathVariable Integer page, @PathVariable Integer size){
        Page<ProjetosResumoProjection> projetoEntityPage = projetoService.getAllProjetoPage(page, size);
        return  ResponseEntity.status(HttpStatus.OK).body(projetoEntityPage);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    @Operation(summary = "Deletar Projeto", description = "Metodo responsavel por deletar projeto pelo id")
    public void deleteProjet(@PathVariable Long id){
        projetoService.deleteProjeto(id);
    }

    @PutMapping("/{id}")
    @Operation(summary = "Atualizar Projeto", description = "Metodo responsavel por atualizar projeto pelo id")
    public ResponseEntity<ProjetoResponseDto> updateProjeto(@Valid @RequestBody ProjetoRequesteDto dto, @PathVariable Long id){
        ProjetoResponseDto projetoResponseDto = projetoService.update(id, dto);
        return ResponseEntity.status(HttpStatus.OK).body(projetoResponseDto);
    }


}
