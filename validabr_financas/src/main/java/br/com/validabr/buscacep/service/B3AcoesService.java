package br.com.validabr.buscacep.service;

import br.com.validabr.buscacep.gateway.dto.B3AcoesDTO;

import java.util.List;

public interface B3AcoesService {

    public List<B3AcoesDTO> buscaAcoesPeloCodNeg(String codNeg);

}
