package empresa.spring.jpa.service;

import empresa.spring.jpa.dto.funcionariosDto.FuncionariosResponseDto;
import empresa.spring.jpa.dto.projetoDto.ProjetoRequesteDto;
import empresa.spring.jpa.dto.projetoDto.ProjetoResponseDto;
import empresa.spring.jpa.entity.ProjetosResumoProjection;
import empresa.spring.jpa.entity.funcionarios.FuncionarioEntity;
import empresa.spring.jpa.entity.projetos.ProjetoEntity;
import empresa.spring.jpa.exception.BadRequestExceptionHandler;
import empresa.spring.jpa.exception.ResouceExceptionHandler;
import empresa.spring.jpa.repository.FuncionariosRepository;
import empresa.spring.jpa.repository.ProjetoRepository;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
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


        List<FuncionarioEntity> funcionario = getFuncionarios(dto.getIdFuncionario());

        var projetos = new ProjetoEntity();
        projetos.setNome(dto.getNome());
        projetos.setDescricao(dto.getDescricao());
        projetos.getFuncionario().addAll(funcionario);

       return projetoRepository.save(projetos);
    }


    public List<FuncionarioEntity> getFuncionarios(List<Long> ids){
        List<FuncionarioEntity> funcionario = funcionariosRepository.findAllById(ids);
        if (funcionario.isEmpty()){
            throw new ResouceExceptionHandler("Nao existe nenhum funcionario com este id");
        }
        return funcionario;
    }

    public List<ProjetoResponseDto> getProjetoAll(){
        List<ProjetoEntity> projetos = projetoRepository.findAll();


        return projetos.stream()
                .map(this::toResponse)
                .toList();
    }

    private ProjetoResponseDto toResponse(ProjetoEntity p){
        List<FuncionariosResponseDto> funcionariosResponseDto = p.getFuncionario().stream()
                .map(f -> new FuncionariosResponseDto(f.getId(), f.getDataCriacao(), f.getNome(), f.getIdade(), f.getEmail(), f.getDepartamento().getId(), f.getDepartamento().getNome(), f.getEndereco()))
                .toList();

        return new ProjetoResponseDto(p.getId(), p.getData(), p.getNome(), p.getDescricao(), funcionariosResponseDto);
    }

    @Transactional
    public void deleteProjeto(Long id){
        ProjetoEntity projetoEntity = projetoRepository.findById(id)
                .orElseThrow(() -> new ResouceExceptionHandler("Este id nao existe entao nao foi possivel deletar o projeto"));

        if (projetoEntity.getFuncionario() != null) {
            throw new ResouceExceptionHandler("Nao existe projeto com este id");
        }

        projetoRepository.delete(projetoEntity);
    }

    public Page<ProjetosResumoProjection> getAllProjetoPage(Integer page, Integer size){
       return projetoRepository.getAllProjetePageable(PageRequest.of(page, size));
    }


    @Transactional
    public ProjetoResponseDto update(Long id, ProjetoRequesteDto dto){
        ProjetoEntity projetoEntity = projetoRepository.findById(id)
                .orElseThrow(() -> new ResouceExceptionHandler("Este id nao existe e nao poderar ser modificado!"));

        projetoEntity.setNome(dto.nome);
        projetoEntity.setDescricao(dto.descricao);


        ProjetoEntity projetoEntityUpdated = projetoRepository.save(projetoEntity);
        return toResponse(projetoEntityUpdated);
    }

}
