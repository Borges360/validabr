package br.com.validabr.financas.gateway;

import br.com.validabr.financas.gateway.dto.B3AcoesDTO;
import br.com.validabr.financas.service.B3AcoesService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;
import java.util.List;

@RestController
@AllArgsConstructor
public class B3AcoesController {

    @Autowired
    B3AcoesService b3AcoesService;

    BaixaCotacaoB3 baixaCotacaoB3;

    @GetMapping("/v1/consulta/{codNeg}/cod-neg")
    public List<B3AcoesDTO> consultaCodNeg(@PathVariable("codNeg") String codNeg){

        return b3AcoesService.buscaAcoesPeloCodNeg(codNeg);

    }

    @GetMapping("/v1/download")
    public void downloadB3() throws IOException {

        baixaCotacaoB3.executaBaixaSerieHistoricaB3();

    }



}
