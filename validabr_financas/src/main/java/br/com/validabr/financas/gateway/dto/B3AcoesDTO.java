package br.com.validabr.financas.gateway.dto;

import br.com.validabr.financas.gateway.entity.B3AcoesEntity;
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
    private Integer num_dis;

    public B3AcoesDTO(B3AcoesEntity b3Acoes){
        this(
                b3Acoes.getTipoRegistro(),
                b3Acoes.getDataAtual(),
                b3Acoes.getCodBdi(),
                b3Acoes.getCodNeg(),
                b3Acoes.getTipoMerc(),
                b3Acoes.getEspecifPapel(),
                b3Acoes.getPrazo(),
                b3Acoes.getMoeda(),
                b3Acoes.getPrecoAbertura(),
                b3Acoes.getPrecoMax(),
                b3Acoes.getPrecoMin(),
                b3Acoes.getPrecoMedio(),
                b3Acoes.getPrecoUlt(),
                b3Acoes.getPrecoMelOfertaComp(),
                b3Acoes.getPrecoMelOfertaVenda(),
                b3Acoes.getNumNeg(),
                b3Acoes.getQuantTotalTit(),
                b3Acoes.getVolTotal(),
                b3Acoes.getPrecoMercOpcoes(),
                b3Acoes.getIndPrecCorrecoes(),
                b3Acoes.getDataVenciTermo(),
                b3Acoes.getFatCotacao(),
                b3Acoes.getPtoExe(),
                b3Acoes.getCodIsin(),
                b3Acoes.getNumDis()
        );
    }

    public B3AcoesDTO(String tipo_registro, Date data_atual, String cod_bdi, String cod_neg, String tipo_merc, String especif_papel, int prazo, String moeda, Double preco_abertura, Double preco_max, Double prec_min, Double preco_medio, Double prec_ult) {
    }
}
