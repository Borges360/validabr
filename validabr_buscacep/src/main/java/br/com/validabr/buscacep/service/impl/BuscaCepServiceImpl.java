package br.com.validabr.buscacep.service.impl;

import br.com.validabr.buscacep.gateway.entity.BairroCidadeEntity;
import br.com.validabr.buscacep.gateway.entity.EnderecoEntity;
import br.com.validabr.buscacep.gateway.dto.EnderecoDTO;
import br.com.validabr.buscacep.repository.ConsultaCepRepository;
import br.com.validabr.buscacep.repository.ConsultaCidadeEstadoRepository;
import br.com.validabr.buscacep.repository.ConsultaCodigoTelefoneRepository;
import br.com.validabr.buscacep.service.BuscaCepService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BuscaCepServiceImpl implements BuscaCepService {

    @Autowired
    ConsultaCepRepository consultaCepRepository;

    @Autowired
    ConsultaCidadeEstadoRepository consultaCidadeEstadoRepository;

    @Autowired
    ConsultaCodigoTelefoneRepository consultaCodigoTelefoneRepository;

    public EnderecoDTO buscaCep(String cep){

        EnderecoEntity endereco = new EnderecoEntity();
        endereco.setCep(cep);
        endereco = consultaCepRepository.findByCep(endereco.getCep());
        BairroCidadeEntity cidade = buscaCidade(endereco);

        return EnderecoDTO.createEnderecoDTO(endereco, cidade);
    }

    public BairroCidadeEntity buscaCidade(EnderecoEntity endereco){

        return consultaCidadeEstadoRepository.findByIdcidade(endereco.getIdCidade());

    }


}
