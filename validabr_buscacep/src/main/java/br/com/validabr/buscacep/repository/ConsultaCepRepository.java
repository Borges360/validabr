package br.com.validabr.buscacep.repository;

import br.com.validabr.buscacep.gateway.entity.EnderecoEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public interface ConsultaCepRepository extends JpaRepository<EnderecoEntity, String> {

    EnderecoEntity findByCep(String cep);

    List<EnderecoEntity> findByLogradouroAndIdCidade(String logradouro, String idCidade);

}
