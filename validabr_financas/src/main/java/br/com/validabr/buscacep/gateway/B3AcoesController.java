package br.com.validabr.buscacep.gateway;

import br.com.validabr.buscacep.gateway.dto.B3AcoesDTO;
import br.com.validabr.buscacep.service.B3AcoesService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@AllArgsConstructor
public class B3AcoesController {

    @Autowired
    B3AcoesService b3AcoesService;

    @GetMapping("/v1/consulta/{codNeg}/cod-neg")
    public List<B3AcoesDTO> consultaCodNeg(@PathVariable("codNeg") String codNeg){

        return b3AcoesService.buscaAcoesPeloCodNeg(codNeg);

    }



}
