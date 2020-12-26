package br.com.validabr.buscacep.service.impl;

import br.com.validabr.buscacep.gateway.dto.CepDTO;
import br.com.validabr.buscacep.gateway.entity.BairroCidadeEntity;
import br.com.validabr.buscacep.gateway.entity.EnderecoEntity;
import br.com.validabr.buscacep.repository.ConsultaCepRepository;
import br.com.validabr.buscacep.repository.ConsultaCidadeEstadoRepository;
import br.com.validabr.buscacep.service.BuscaEnderecoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

@Service
public class BuscaEnderecoServiceImpl implements BuscaEnderecoService {

    @Autowired
    private ConsultaCepRepository consultaCepRepository;

    @Autowired
    private ConsultaCidadeEstadoRepository consultaCidadeEstadoRepository;

    public List<CepDTO> buscaEnderecoComCidade(String logradouro, String cidade){ //TODO: fazer busca inteligente

        List<BairroCidadeEntity> idCidadeLista = consultaCidadeEstadoRepository.findByCidade(cidade);
        List<CepDTO> listaCep = new ArrayList<>();

        for (BairroCidadeEntity idCidade : idCidadeLista) {

            try {
                listaCep.add(new CepDTO(consultaCepRepository.findByLogradouroAndIdCidade(logradouro, idCidade.getIdCidade()).getCep()));
            } catch (Exception e) {
                e.getMessage();
            }
        }

        return listaCep;

    }

    public CepDTO buscaEnderecoComEstado(String endereco, String estado){

        //TODO: fazer métodos retornar cep passando endereco e estado
        return null;
    }

    public CepDTO buscaEnderecoComEstadoECidade(String endereco, String cidade, String estado){

        //TODO: fazer métodos retornar cep passando endereco, cidade e estado
        return null;
    }

    private BairroCidadeEntity buscaIdCidade(EnderecoEntity endereco){

        return consultaCidadeEstadoRepository.findByIdCidade(endereco.getIdCidade());
    }

    private BairroCidadeEntity buscaIdEstado(String idCidade){

        //TODO: Retornar ID da Estado
        return null;
    }
}
