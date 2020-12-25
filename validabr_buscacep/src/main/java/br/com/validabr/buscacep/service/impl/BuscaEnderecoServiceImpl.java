package br.com.validabr.buscacep.service.impl;

import br.com.validabr.buscacep.gateway.dto.CepDTO;
import br.com.validabr.buscacep.gateway.entity.BairroCidadeEntity;
import br.com.validabr.buscacep.repository.ConsultaCepRepository;
import br.com.validabr.buscacep.repository.ConsultaCidadeEstadoRepository;
import br.com.validabr.buscacep.service.BuscaEnderecoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BuscaEnderecoServiceImpl implements BuscaEnderecoService {

    @Autowired
    private ConsultaCepRepository consultaCepRepository;

    @Autowired
    private ConsultaCidadeEstadoRepository consultaCidadeEstadoRepository;

    public CepDTO buscaEnderecoComCidade(String endereco, String cidade){

        //TODO: fazer métodos retornar cep passando endereco e cidade
        return null;

    }

    public CepDTO buscaEnderecoComEstado(String endereco, String estado){

        //TODO: fazer métodos retornar cep passando endereco e estado
        return null;
    }

    public CepDTO buscaEnderecoComEstadoECidade(String endereco, String cidade, String estado){

        //TODO: fazer métodos retornar cep passando endereco, cidade e estado
        return null;
    }

    private BairroCidadeEntity buscaIdCidade(String idCidade){

        //TODO: Retornar ID da Cidade
        return null;
    }

    private BairroCidadeEntity buscaIdEstado(String idCidade){

        //TODO: Retornar ID da Estado
        return null;
    }
}
