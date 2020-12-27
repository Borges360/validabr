package br.com.validabr.buscacep.gateway;

import br.com.validabr.validabr_application.ValidabrApplication;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.http.MediaType;
import org.springframework.orm.hibernate5.LocalSessionFactoryBean;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.TestContext;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockHttpServletRequestBuilder;
import org.springframework.web.util.UriTemplate;

import java.net.URI;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class)
@WebMvcTest(controllers = BuscaCepController.class)
@ContextConfiguration(classes = {TestContext.class})
@WebAppConfiguration
public class AnswerControllerTests {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private BuscaCepController buscaCepControlle;

    @Test
    public void testController_HTTPStatus200_ConsultaCep() throws Exception {

        this.mockMvc.perform(get("/v1/consulta-cep/{cep}","04561914"))
                .andExpect(status().isOk());

    }

    @Test
    public void testController_HTTPStatus200_BuscaCepComEnderecoECidade() throws Exception {

        this.mockMvc.perform(get("/v1/consulta-endereco-cidade/{endereco}/{cidade}","Rua Guararapes 443", "São Paulo"))
                .andExpect(status().isOk());

    }


}
