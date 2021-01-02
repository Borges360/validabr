package br.com.validabr.financas.gateway.entity;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.Date;

@NoArgsConstructor
@AllArgsConstructor
public class B3AcoesID implements Serializable {

    private Date dataAtual;
    private String codNeg;
    private int prazo;
    private String codIsin;
}
