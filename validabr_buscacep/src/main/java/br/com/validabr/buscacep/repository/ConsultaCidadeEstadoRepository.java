package br.com.validabr.buscacep.repository;

import br.com.validabr.buscacep.gateway.entity.BairroCidadeEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Collection;
import java.util.List;

@Repository
public interface ConsultaCidadeEstadoRepository extends JpaRepository<BairroCidadeEntity, Integer> {

    BairroCidadeEntity findByIdCidade(Integer idCidade);

    List<BairroCidadeEntity>  findByCidade(String cidade);

}
