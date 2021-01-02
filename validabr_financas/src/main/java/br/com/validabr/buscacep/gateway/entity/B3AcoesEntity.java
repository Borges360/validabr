package br.com.validabr.buscacep.gateway.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;
import java.math.BigInteger;
import java.util.Date;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@IdClass(B3AcoesID.class)
@Table(name="b3_precos")
public class B3AcoesEntity implements Serializable {

      @Column(name = "tipo_registro")
      private String tipoRegistro;

      @Id
      @Column(name = "data_atual")
      private Date dataAtual;

      @Column(name = "cod_bdi")
      private String codBdi;

      @Id
      @Column(name = "cod_neg")
      private String codNeg;

      @Column(name = "tipo_merc")
      private String tipoMerc;

      @Column(name = "especific_papel")
      private String especifPapel;

      @Id
      @Column(name = "prazo")
      private int prazo;

      @Column(name = "moeda")
      private String moeda;

      @Column(name = "preco_abertura")
      private Double precoAbertura;

      @Column(name = "preco_max")
      private Double precoMax;

      @Column(name = "prec_min")
      private Double precoMin;

      @Column(name = "preco_medio")
      private Double precoMedio;

      @Column(name = "prec_ult")
      private Double precoUlt;

      @Column(name = "prec_mel_oferta_comp")
      private Double precoMelOfertaComp;

      @Column(name = "prec_mel_oferta_venda")
      private Double precoMelOfertaVenda;

      @Column(name = "num_neg")
      private int numNeg;

      @Column(name = "quant_total_tit")
      private BigInteger quantTotalTit;

      @Column(name = "vol_total")
      private BigInteger volTotal;

      @Column(name = "preco_merc_opcoes")
      private Double precoMercOpcoes;

      @Column(name = "ind_preco_correcoes")
      private String indPrecCorrecoes;

      @Column(name = "data_venci_termo")
      private Date dataVenciTermo;

      @Column(name = "fat_cotacao")
      private int fatCotacao;

      @Column(name = "pto_exe")
      private BigInteger ptoExe;

      @Id
      @Column(name = "cod_isin")
      private String codIsin;

      @Column(name = "num_dis")
      private Integer numDis;






}
