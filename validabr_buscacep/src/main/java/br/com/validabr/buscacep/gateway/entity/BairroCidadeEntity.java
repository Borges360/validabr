package br.com.validabr.buscacep.gateway.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name="cepbr_cidade")
public class BairroCidadeEntity {

    @Id
    @Column(name = "id_cidade")
    private Integer idCidade;

    @Column(name = "uf")
    private String uf;

    @Column(name = "cidade")
    private String cidade;

}
