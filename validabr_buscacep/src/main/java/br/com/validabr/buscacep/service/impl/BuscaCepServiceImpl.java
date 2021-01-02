package br.com.validabr.buscacep.service.impl;

import br.com.validabr.buscacep.gateway.entity.BairroCidadeEntity;
import br.com.validabr.buscacep.gateway.entity.EnderecoEntity;
import br.com.validabr.buscacep.gateway.dto.EnderecoDTO;
import br.com.validabr.buscacep.repository.ConsultaCepRepository;
import br.com.validabr.buscacep.repository.ConsultaCidadeEstadoRepository;
import br.com.validabr.buscacep.service.BuscaCepService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.persistence.NoResultException;
import javax.persistence.NonUniqueResultException;

@Service
public class BuscaCepServiceImpl implements BuscaCepService {

    @Autowired
    ConsultaCepRepository consultaCepRepository;

    @Autowired
    ConsultaCidadeEstadoRepository consultaCidadeEstadoRepository;

    public EnderecoDTO buscaCep(String cep){

        EnderecoEntity endereco = new EnderecoEntity();
        endereco.setCep(cep);
        try {
            endereco = consultaCepRepository.findByCep(endereco.getCep());
            BairroCidadeEntity cidade = buscaCidade(endereco);
            return EnderecoDTO.createEnderecoDTO(endereco, cidade);
        } catch (NonUniqueResultException e) {
            e.printStackTrace();
        }

        return null;
    }

    public BairroCidadeEntity buscaCidade(EnderecoEntity endereco) {
        try {
            return consultaCidadeEstadoRepository.findByIdCidade(endereco.getIdCidade());
        } catch (NonUniqueResultException e) {
            e.printStackTrace();
        }

        return null;
    }


}
