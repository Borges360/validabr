package br.com.validabr.buscacep.repository;

import br.com.validabr.buscacep.gateway.entity.EnderecoEntity;
import org.junit.Test;
import org.junit.runner.RunWith;
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
@ContextConfiguration(classes = TestContext.class)
public class ConsultaCepRepositoryTest {

    @MockBean
    private ConsultaCepRepository consultaCepRepository;

    @Test
    public void testConsultaCep(){

        EnderecoEntity endereco = new EnderecoEntity();
        endereco.setCep("04561914");
        endereco.setLogradouro("Rua Guararapes 443");
        endereco.setIdCidade(9668);
        endereco.setComplemento(null);
        endereco.setIdBairro("25254");
        endereco.setTipoLogradouro(null);
        endereco.setLocal("Edifício e Condomínio Brooklin New Life");
        EnderecoEntity consultaEndereco = consultaCepRepository.findByCep("04561914");
        assertThat(consultaEndereco).isEqualTo(endereco);
    }

    @Test
    public void testConsultaLogradouroECidade(){

        List<EnderecoEntity> consultaEndereco = consultaCepRepository.findByLogradouroContainingAndIdCidade("Rua Guararapes 443", 9668);
        assertThat(consultaEndereco).isNotNull();

    }
}
