package br.com.validabr.buscacep.service;

import br.com.validabr.buscacep.gateway.dto.CepDTO;

public interface BuscaEnderecoService {

    CepDTO buscaEnderecoComCidade(String endereco, String estado);

    CepDTO buscaEnderecoComEstado(String endereco, String estado);

    CepDTO buscaEnderecoComEstadoECidade(String endereco, String cidade, String estado);

}
