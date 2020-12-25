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
@Table(name="codigo_telefone")
public class CodigoTelefoneEntity {

    @Id
    @Column(name = "estado")
    private String estado;

    @Id
    @Column(name = "cod_telefone")
    private Integer codTelfone;


}
