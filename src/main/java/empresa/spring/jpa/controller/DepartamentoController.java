package empresa.spring.jpa.controller;

import empresa.spring.jpa.dto.departamentoDto.DepartamentoRequestDto;
import empresa.spring.jpa.dto.departamentoDto.DepartamentoResponseDto;
import empresa.spring.jpa.service.DepartamentoSevice;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/empresa/departamentos")
@RequiredArgsConstructor
public class DepartamentoController {

    private final DepartamentoSevice departamentoSevice;


    @PostMapping
    public ResponseEntity saveDepartamento(@RequestBody DepartamentoRequestDto dto){
        departamentoSevice.save(dto);
        return ResponseEntity.status(HttpStatus.CREATED).body("Departamento criado com sucesso");
    }

    @GetMapping
    public ResponseEntity<List<DepartamentoResponseDto>> findAllDepartamentos(){
        var departamento = departamentoSevice.findAll();
        return ResponseEntity.status(HttpStatus.OK).body(departamento);
    }

    @GetMapping("/search/name")
    public ResponseEntity<List<DepartamentoResponseDto>> findByName(@RequestParam (required = false) String name){
        List<DepartamentoResponseDto> departamento = departamentoSevice.findByName(name);
        return ResponseEntity.status(HttpStatus.OK).body(departamento);
    }

    @GetMapping("/search/id")
    public ResponseEntity<DepartamentoResponseDto> findById(@PathVariable Long id){
        DepartamentoResponseDto departamento = departamentoSevice.findById(id);
        return ResponseEntity.status(HttpStatus.OK).body(departamento);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity deleteDepartamento(@PathVariable Long id){
        departamentoSevice.delete(id);
        return ResponseEntity.status(HttpStatus.OK).body("Departamento deletado com sucesso");
    }
}
