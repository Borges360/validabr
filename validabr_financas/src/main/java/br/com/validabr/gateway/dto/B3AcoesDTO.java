package br.com.validabr.gateway.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigInteger;
import java.util.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class B3AcoesDTO {

    private String tipo_registro;
    private Date data_atual;
    private String cod_bdi;
    private String cod_neg;
    private String tipo_merc;
    private String especif_papel;
    private int prazo;
    private String moeda;
    private Double preco_abertura;
    private Double preco_max;
    private Double prec_min;
    private Double preco_medio;
    private Double prec_ult;
    private Double prec_mel_oferta_comp;
    private Double prec_mel_oferta_venda;
    private int num_neg;
    private BigInteger quant_total_tit;
    private BigInteger vol_total;
    private Double prec_merc_opcoes;
    private String ind_prec_correcoes;
    private Date data_venci_termo;
    private int fat_cotacao;
    private BigInteger pto_exe;
    private String cod_isin;
    private int num_dis;


}
