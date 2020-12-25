package br.com.validabr.buscacep.repository;

import br.com.validabr.buscacep.gateway.entity.BairroCidadeEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ConsultaCidadeEstadoRepository extends JpaRepository<BairroCidadeEntity, Integer> {

    BairroCidadeEntity findByIdcidade(Integer id_cidade);

}
