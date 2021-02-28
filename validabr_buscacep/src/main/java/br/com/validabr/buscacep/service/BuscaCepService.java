package br.com.validabr.buscacep.service;

import br.com.validabr.buscacep.gateway.dto.EnderecoDTO;
import org.springframework.stereotype.Service;


public interface BuscaCepService {

    EnderecoDTO buscaCep(String cep);

}
