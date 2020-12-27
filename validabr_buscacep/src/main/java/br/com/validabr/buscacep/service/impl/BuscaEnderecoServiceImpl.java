package br.com.validabr.buscacep.service.impl;

import br.com.validabr.buscacep.gateway.dto.CepDTO;
import br.com.validabr.buscacep.gateway.entity.BairroCidadeEntity;
import br.com.validabr.buscacep.gateway.entity.EnderecoEntity;
import br.com.validabr.buscacep.repository.ConsultaCepRepository;
import br.com.validabr.buscacep.repository.ConsultaCidadeEstadoRepository;
import br.com.validabr.buscacep.service.BuscaEnderecoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.persistence.NoResultException;
import javax.persistence.NonUniqueResultException;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

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
                listaCep.addAll(consultaCepRepository.findByLogradouroContainingAndIdCidade(logradouro, idCidade.getIdCidade()).stream().map(h ->
                        new CepDTO(h.getCep())).collect(Collectors.toList()));
            } catch (NonUniqueResultException e) {
                e.printStackTrace();
            } catch (NoResultException e) {
                e.printStackTrace();
            } catch (Exception e) {
                e.printStackTrace();
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
