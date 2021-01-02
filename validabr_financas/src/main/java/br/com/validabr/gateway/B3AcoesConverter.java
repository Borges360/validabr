package br.com.validabr.gateway;

import br.com.validabr.gateway.dto.B3AcoesDTO;

import java.math.BigInteger;
import java.text.ParseException;
import java.text.SimpleDateFormat;



public class B3AcoesConverter {

    public B3AcoesDTO convert(String [] linhaCsv) throws ParseException {

        SimpleDateFormat formatador = new SimpleDateFormat("yyyyMMdd");

        B3AcoesDTO b3AcoesDTO = new B3AcoesDTO();

        b3AcoesDTO.setTipo_registro(linhaCsv[0]);
        b3AcoesDTO.setData_atual(formatador.parse(linhaCsv[1]));
        b3AcoesDTO.setCod_bdi(linhaCsv[2]);
        b3AcoesDTO.setCod_neg(linhaCsv[3]);
        b3AcoesDTO.setTipo_merc(linhaCsv[4]);
        b3AcoesDTO.setEspecif_papel(linhaCsv[5]);
        b3AcoesDTO.setPrazo(Integer.parseInt(linhaCsv[6]));
        b3AcoesDTO.setMoeda(linhaCsv[7]);
        b3AcoesDTO.setPreco_abertura(Double.parseDouble(linhaCsv[8]));
        b3AcoesDTO.setPreco_max(Double.parseDouble(linhaCsv[9]));
        b3AcoesDTO.setPrec_min(Double.parseDouble(linhaCsv[10]));
        b3AcoesDTO.setPreco_medio(Double.parseDouble(linhaCsv[11]));
        b3AcoesDTO.setPrec_ult(Double.parseDouble(linhaCsv[12]));
        b3AcoesDTO.setPrec_mel_oferta_comp(Double.parseDouble(linhaCsv[13]));
        b3AcoesDTO.setPrec_mel_oferta_venda(Double.parseDouble(linhaCsv[14]));
        b3AcoesDTO.setNum_neg(Integer.parseInt(linhaCsv[15]));
        b3AcoesDTO.setQuant_total_tit(new BigInteger(linhaCsv[16]));
        b3AcoesDTO.setVol_total(new BigInteger(linhaCsv[17]));
        b3AcoesDTO.setPrec_merc_opcoes(Double.parseDouble(linhaCsv[18]));
        b3AcoesDTO.setInd_prec_correcoes(linhaCsv[19]);
        b3AcoesDTO.setData_venci_termo(formatador.parse(linhaCsv[20]));
        b3AcoesDTO.setFat_cotacao(Integer.parseInt(linhaCsv[21]));
        b3AcoesDTO.setPto_exe(new BigInteger(linhaCsv[22]));
        b3AcoesDTO.setCod_isin(linhaCsv[23]);
        b3AcoesDTO.setNum_dis(Integer.parseInt(linhaCsv[24]));

        return b3AcoesDTO;
    }

}
