package br.com.validabr.datas.adapters;

import br.com.validabr.datas.gateway.entity.DatasFeriadosEntity;
import br.com.validabr.datas.repository.DatasRepository;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

@RestController
@AllArgsConstructor
public class DatasController {

    DatasRepository datasRepository;

    @GetMapping("/v1/datas_feriados/{ano}")
    public List<DatasFeriadosEntity> buscaFeriado(@PathVariable("ano") String ano) throws ParseException {

        String dataInicial = ano + "-01-01";
        String dataFinal = ano + "-12-31";

        Date date1=new SimpleDateFormat("yyyy-MM-dd").parse(dataInicial);
        Date date2=new SimpleDateFormat("yyyy-MM-dd").parse(dataFinal);

        return datasRepository.findAllByDataFeriadoBetween(date1, date2);

    }




}
