package br.com.validabr.buscacep.gateway;

import br.com.validabr.buscacep.gateway.dto.CepDTO;
import br.com.validabr.buscacep.gateway.dto.EnderecoDTO;

import br.com.validabr.buscacep.service.BuscaCepService;
import br.com.validabr.buscacep.service.BuscaEnderecoService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;


@RestController
@AllArgsConstructor
public class BuscaCepController {

    private BuscaCepService buscaCepService;

    private BuscaEnderecoService buscaEnderecoService;

    @GetMapping("/v1/consulta-cep/{cep}")
    public EnderecoDTO buscaCep(@PathVariable("cep") String cep) {

        return buscaCepService.buscaCep(cep);

    }

    @GetMapping("/v1/consulta-endereco-cidade/{endereco}/{cidade}")
    public List<CepDTO> buscaCepComEnderecoECidade(@PathVariable("endereco") String endereco,
                                                   @PathVariable("cidade") String cidade){

        return buscaEnderecoService.buscaEnderecoComCidade(endereco, cidade);


    }

    @GetMapping("/v1/consulta-endereco-estado/{endereco}/{estado}")
    public CepDTO buscaCepComEnderecoEEstado(@PathVariable("endereco") String endereco,
                                             @PathVariable("estado") String estado){

        return buscaEnderecoService.buscaEnderecoComEstado(endereco, estado);

    }

    @GetMapping("/v1/consulta-endereco-cidade-estado/{endereco}/{cidade}/{estado}")
    public CepDTO buscaCepComEnderecoEEstado(@PathVariable("endereco") String endereco,
                                             @PathVariable("cidade") String cidade,
                                             @PathVariable("estado") String estado){

        return buscaEnderecoService.buscaEnderecoComEstadoECidade(endereco, cidade, estado);

    }
}
