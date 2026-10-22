package empresa.spring.jpa.service;


import empresa.spring.jpa.dto.enderecoDto.EnderecoRequestDto;
import empresa.spring.jpa.dto.enderecoDto.EnderecoResponseDto;
import empresa.spring.jpa.entity.endereco.EnderecoEntity;
import empresa.spring.jpa.entity.funcionarios.FuncionarioEntity;
import empresa.spring.jpa.exception.BadRequestExceptionHandler;
import empresa.spring.jpa.exception.ResouceExceptionHandler;
import empresa.spring.jpa.repository.EnderecoRepository;
import empresa.spring.jpa.repository.FuncionariosRepository;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class EnderecoService {

    private final EnderecoRepository enderecoRepository;
    private final FuncionariosRepository funcionariosRepository;


    public void saveEndereco(EnderecoRequestDto dto){
        FuncionarioEntity funcionario = funcionariosRepository.findById(dto.getIdFuncionario())
                .orElseThrow(() -> new BadRequestExceptionHandler("Este id nao existe pode receber este endereco"));


       EnderecoEntity enderecoEntity = funcionario.getEndereco();
       if (enderecoEntity != null){
           throw new BadRequestExceptionHandler("Este enderco ja faz parte de um usuario cadastrado");
       }

       enderecoEntity = EnderecoEntity.builder()
               .cidade(dto.getCidade())
               .build();

       funcionario.setEndereco(enderecoEntity);
       funcionariosRepository.save(funcionario);

    }

    public List<EnderecoResponseDto> findAllEndereco(){
       List<EnderecoEntity> endereco = enderecoRepository.findAll();

       return endereco.stream()
               .map(this::toResponse)
               .toList();
    }

    private EnderecoResponseDto toResponse(EnderecoEntity e){
        return new EnderecoResponseDto(e.getId(),e.getCep(),e.getEstado() ,e.getCidade(), e.getRua(), e.getNumeroCasa());
    }

    public List<EnderecoResponseDto> findByEstado(String estado){
        List<EnderecoEntity> endereco = enderecoRepository.findByEstadoContainingIgnoreCase(estado);

        if (endereco.isEmpty()){
            throw new ResouceExceptionHandler("Nao existe nenhum endereco cadastro nesse estado");
        }

        return endereco.stream()
                .map(this::toResponse)
                .toList();
    }

    @Transactional
    public void deleteEndereco(Long id){
        EnderecoEntity endereco = enderecoRepository.findById(id)
                .orElseThrow(() -> new ResouceExceptionHandler("Este endereco ano existe"));

        enderecoRepository.delete(endereco);
    }


}
