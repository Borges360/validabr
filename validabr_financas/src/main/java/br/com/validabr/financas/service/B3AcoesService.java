package br.com.validabr.financas.service;

import br.com.validabr.financas.gateway.dto.B3AcoesDTO;

import java.util.List;

public interface B3AcoesService {

    List<B3AcoesDTO> buscaAcoesPeloCodNeg(String codNeg);

}
