package br.com.validabr.financas.data.repository;

import br.com.validabr.financas.gateway.entity.B3AcoesEntity;
import br.com.validabr.financas.gateway.entity.B3AcoesID;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface B3AcoesRepository extends JpaRepository<B3AcoesEntity, B3AcoesID> {

    List<B3AcoesEntity> findByCodNegContains(String cod_neg);

}
