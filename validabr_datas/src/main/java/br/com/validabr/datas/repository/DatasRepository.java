package br.com.validabr.datas.repository;

import br.com.validabr.datas.gateway.entity.DatasFeriadosEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.time.OffsetDateTime;
import java.util.Date;
import java.util.List;

@Repository
public interface DatasRepository extends JpaRepository<DatasFeriadosEntity, Date> {

    //List<DatasFeriadosEntity> findAllById(Date dates);

    List<DatasFeriadosEntity> findAllByDataFeriadoBetween
            (Date  startDate, Date endDate);

}
