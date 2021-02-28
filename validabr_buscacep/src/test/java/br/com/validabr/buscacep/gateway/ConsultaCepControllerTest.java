package br.com.validabr.buscacep.gateway;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.TestContext;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class)
@WebMvcTest(value = BuscaCepController.class)
@ContextConfiguration(classes = {TestContext.class})
@WebAppConfiguration
public class ConsultaCepControllerTest {

    @Autowired
    private MockMvc mockMvc;

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
