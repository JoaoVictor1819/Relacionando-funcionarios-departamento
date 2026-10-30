package empresa.spring.jpa.repository;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.data.jpa.test.autoconfigure.DataJpaTest;
import org.springframework.test.context.ActiveProfiles;

import static org.junit.jupiter.api.Assertions.*;

@DataJpaTest
@ActiveProfiles("testdb")
class DepartamentoRepositoryTest {

    @Autowired
    private DepartamentoRepository repository;

    @Test
    void findByNome() {
    }
}