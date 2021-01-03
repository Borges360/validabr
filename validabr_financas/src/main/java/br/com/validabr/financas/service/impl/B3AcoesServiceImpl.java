package br.com.validabr.financas.service.impl;


import br.com.validabr.financas.gateway.dto.B3AcoesDTO;

import br.com.validabr.financas.repository.B3AcoesRepository;
import br.com.validabr.financas.service.B3AcoesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class B3AcoesServiceImpl implements B3AcoesService {

    @Autowired
    B3AcoesRepository b3AcoesRepository;

    public List<B3AcoesDTO> buscaAcoesPeloCodNeg(String codNeg){

        //List<B3AcoesDTO> listaAcoesB3 = (b3AcoesRepository.findByCodNegContains(codNeg));

        return null;

    }



}
