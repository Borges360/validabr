package br.com.validabr.buscacep.gateway.dto;

import br.com.validabr.buscacep.gateway.entity.EnderecoEntity;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class CepDTO {

    private String cep;

    private CepDTO(EnderecoEntity cep){
        this(cep.getCep());
    }

    private CepDTO(CepDTO c) {
        this.cep = cep;
    }

    public static CepDTO createCepDTO(EnderecoEntity cep) {
        return new CepDTO(cep);
    }
}
