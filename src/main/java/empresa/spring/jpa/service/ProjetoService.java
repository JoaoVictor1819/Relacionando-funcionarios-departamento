package empresa.spring.jpa.service;

import empresa.spring.jpa.dto.funcionariosDto.FuncionariosResponseDto;
import empresa.spring.jpa.dto.projetoDto.ProjetoRequesteDto;
import empresa.spring.jpa.dto.projetoDto.ProjetoResponseDto;
import empresa.spring.jpa.entity.funcionarios.FuncionarioEntity;
import empresa.spring.jpa.entity.projetos.ProjetoEntity;
import empresa.spring.jpa.exception.ResouceExceptionHandler;
import empresa.spring.jpa.repository.FuncionariosRepository;
import empresa.spring.jpa.repository.ProjetoRepository;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ProjetoService {

    private final ProjetoRepository projetoRepository;
    private final FuncionariosRepository funcionariosRepository;

    @Transactional
    public ProjetoEntity saveProjeto(ProjetoRequesteDto dto){

       var projetos = new ProjetoEntity();
       projetos.setNome(dto.nome);

       return projetoRepository.save(projetos);
    }

    public List<ProjetoResponseDto> getProjetoAll(){
        List<ProjetoEntity> projetos = projetoRepository.findAll();


        return projetos.stream()
                .map(this::toResponse)
                .toList();
    }

    private  ProjetoResponseDto toResponse(ProjetoEntity p){
//        List<FuncionariosResponseDto> funcionariosResponseDtos = p.getFuncionarios().stream()
//                .map(f -> new FuncionariosResponseDto(f.getId(),
//                        f.getDataCriacao(),
//                        f.getNome(),
//                        f.getEmail(),
//                        f.getDepartamento().getId(),
//                        f.getDepartamento().getNome(),
//                        f.getEndereco(),
//                        f.getProjetos()))
//                .toList();


        return new ProjetoResponseDto(p.getId(), p.getNome());
    }

    @Transactional
    public void deleteProjeto(Long id){
        ProjetoEntity projetoEntity = projetoRepository.findById(id)
                .orElseThrow(() -> new ResouceExceptionHandler("Este id nao existe entao nao foi possivel deletar o projeto"));

        if (projetoEntity.getFuncionarios() != null) {
            throw new ResouceExceptionHandler("Nao existe projeto com este id");
        }

        projetoRepository.delete(projetoEntity);
    }


}
