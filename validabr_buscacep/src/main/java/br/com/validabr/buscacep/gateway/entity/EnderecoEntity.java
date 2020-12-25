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
@Table(name="cepbr_endereco")
public class EnderecoEntity {

    @Id
    @Column(name = "cep")
    private String cep;

    @Column(name = "logradouro")
    private String logradouro;

    @Column(name = "tipo_logradouro")
    private String tipoLogradouro;

    @Column(name = "complemento")
    private String complemento;

    @Column(name = "local")
    private String local;

    @Column(name = "id_cidade")
    private int idCidade;

    @Column(name = "id_bairro")
    private String idBairro;

}
