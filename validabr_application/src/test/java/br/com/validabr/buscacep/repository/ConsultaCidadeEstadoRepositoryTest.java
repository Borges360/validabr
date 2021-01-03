package br.com.validabr.buscacep.repository;

import br.com.validabr.buscacep.gateway.entity.BairroCidadeEntity;
import br.com.validabr.buscacep.repository.ConsultaCidadeEstadoRepository;
import br.com.validabr.validabr_application.ValidabrApplication;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.TestContext;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

@RunWith(SpringRunner.class)
@DataJpaTest
@AutoConfigureTestDatabase(replace= AutoConfigureTestDatabase.Replace.NONE)
@ContextConfiguration(classes = ValidabrApplication.class)
public class ConsultaCidadeEstadoRepositoryTest {

    @MockBean
    private ConsultaCidadeEstadoRepository consultaCidadeEstadoRepository;

    @Test
    public void testConsultaIdCidade(){

        BairroCidadeEntity bairroCidade = new BairroCidadeEntity();
        bairroCidade.setCidade("São Paulo");
        bairroCidade.setIdCidade(9668);
        bairroCidade.setUf("SP");

        BairroCidadeEntity consultaEndereco = consultaCidadeEstadoRepository.findByIdCidade(9668);
        assertThat(consultaEndereco).isEqualTo(bairroCidade);
    }

    @Test
    public void testConsultaCidade(){

        List<BairroCidadeEntity> consultaCidade = consultaCidadeEstadoRepository.findByCidade("São Paulo");
        assertThat(consultaCidade).isNotNull();

    }
}
