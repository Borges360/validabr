package br.com.validabr.datas.gateway.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Date;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name="valida_datas")
public class DatasFeriadosEntity {

    @Id
    @Column(name = "data_feriado")
    @JsonFormat(pattern="yyyy-MM-dd")
    private Date dataFeriado;

    @Column(name = "feriado")
    private String feriado;

}
