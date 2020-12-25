package br.com.validabr.buscacep.repository;

import br.com.validabr.buscacep.gateway.entity.BairroCidadeEntity;
import br.com.validabr.buscacep.gateway.entity.CodigoTelefoneEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ConsultaCodigoTelefoneRepository extends JpaRepository<CodigoTelefoneEntity, String> {

    List<CodigoTelefoneEntity> findByEstado(String estado);

}
