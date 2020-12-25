package br.com.validabr.buscacep.service;

import br.com.validabr.buscacep.gateway.dto.EnderecoDTO;


public interface BuscaCepService {

    EnderecoDTO buscaCep(String cep);

}
