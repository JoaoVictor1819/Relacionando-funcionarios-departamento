package empresa.spring.jpa.service;

import empresa.spring.jpa.dto.departamentoDto.DepartamentoRequestDto;
import empresa.spring.jpa.dto.departamentoDto.DepartamentoResponseDto;
import empresa.spring.jpa.entity.departamento.DepartamentoEntity;
import empresa.spring.jpa.repository.DepartamentoRepository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import java.math.BigDecimal;
import java.util.Collections;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.Mockito.lenient;

@ExtendWith(MockitoExtension.class)
class DepartamentoSeviceTest {


    @InjectMocks
    private DepartamentoSevice departamentoSevice;

    @Mock
    private DepartamentoRepository departamentoRepository;


    @BeforeEach
    public void setUp() {
        DepartamentoEntity departamentoEntity = new DepartamentoEntity(
                DepartamentoRequestDto.builder()
                        .nome("Departamento Teste1")
                        .descricao("Descricao")
                        .salarioFixo(new BigDecimal(3432))
                        .build());

        lenient().when(departamentoRepository.findAll()).thenReturn(Collections.singletonList(departamentoEntity));
        lenient().when(departamentoRepository.findById(1L)).thenReturn(Optional.of(departamentoEntity));
    }

    @Test
    @DisplayName("Deve retornar uma lista de departamento")
    public void deveRetornarUmaListaDeDepartamento(){
        List<DepartamentoResponseDto> departamento = departamentoSevice.findAllDepartamento();

        Assertions.assertEquals(1, departamento.size());

        Mockito.verify(departamentoRepository).findAll();
        Mockito.verifyNoMoreInteractions(departamentoRepository);

    }

    @Test
    @DisplayName("Deve lançar exceção ao tentar salvar departamento existente")
    public void deveLancarExcecaoAoTentarSalvarDepartamentoExistente(){
        DepartamentoRequestDto departamentoRequest = DepartamentoRequestDto.builder()
                .nome("Departamento Teste1")
                .descricao("Descricao")
                .salarioFixo(new BigDecimal(3432))
                .build();

        DepartamentoEntity departamentoEntity = new DepartamentoEntity(departamentoRequest);

        Mockito.when(departamentoRepository.findByNome(departamentoRequest.getNome()))
                .thenReturn(java.util.Optional.of(departamentoEntity));

        Assertions.assertThrows(RuntimeException.class, () -> {departamentoSevice.saveDepartamento(departamentoRequest);});
    }


    @Test
    @DisplayName("Deve buscar departamento por id")
    public void buscarPorId(){
        DepartamentoResponseDto departamentoResponseDto = departamentoSevice.findByIdDepartamento(1L);
        assertNotNull(departamentoResponseDto);
    }



}