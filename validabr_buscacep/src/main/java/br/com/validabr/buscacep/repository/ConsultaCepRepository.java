package br.com.validabr.buscacep.repository;

import br.com.validabr.buscacep.gateway.dto.CepDTO;
import br.com.validabr.buscacep.gateway.entity.EnderecoEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.lang.Nullable;
import org.springframework.stereotype.Repository;


@Repository
public interface ConsultaCepRepository extends JpaRepository<EnderecoEntity, String> {

    EnderecoEntity findByCep(String cep);

    @Nullable
    EnderecoEntity findByLogradouroAndIdCidade(String logradouro, Integer idCidade);

}
