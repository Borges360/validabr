package br.com.validabr.financas.service;

import br.com.validabr.financas.gateway.dto.B3AcoesDTO;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface B3AcoesService {

    List<B3AcoesDTO> buscaAcoesPeloCodNeg(String codNeg);

}
