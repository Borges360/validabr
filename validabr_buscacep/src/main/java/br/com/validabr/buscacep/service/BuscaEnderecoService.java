package br.com.validabr.buscacep.service;

import br.com.validabr.buscacep.gateway.dto.CepDTO;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface BuscaEnderecoService {

    List<CepDTO> buscaEnderecoComCidade(String endereco, String estado);

    CepDTO buscaEnderecoComEstado(String endereco, String estado);

    CepDTO buscaEnderecoComEstadoECidade(String endereco, String cidade, String estado);

}
