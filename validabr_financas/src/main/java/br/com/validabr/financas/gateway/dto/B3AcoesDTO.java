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

    private String tipoRegistro;
    private Date dataAtual;
    private String codBdi;
    private String codNeg;
    private String tipoMerc;
    private String especifPapel;
    private int prazo;
    private String moeda;
    private Double precoAbertura;
    private Double precoMax;
    private Double precoMin;
    private Double precoMedio;
    private Double precoUlt;
    private Double precoMelOfertaComp;
    private Double precoMelOfertaVenda;
    private int numNeg;
    private BigInteger quantTotalTit;
    private BigInteger volTotal;
    private Double precoMercOpcoes;
    private String indPrecCorrecoes;
    private Date dataVenciTermo;
    private int fatCotacao;
    private BigInteger ptoExe;
    private String codIsin;
    private Integer numDis;

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


}
