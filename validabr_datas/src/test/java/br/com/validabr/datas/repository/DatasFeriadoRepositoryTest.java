package br.com.validabr.datas.repository;

import br.com.validabr.datas.gateway.entity.DatasFeriadosEntity;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.Date;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class DatasFeriadoRepositoryTest {

    @Autowired
    DatasRepository datasRepository;

    @Test
    public void testConsultaLogradouroECidade(){


        LocalDate dataAtual = LocalDate.now();
        DateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");




    }
}
