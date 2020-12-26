package br.com.validabr.buscacep.gateway.dto;

import br.com.validabr.buscacep.gateway.entity.BairroCidadeEntity;
import br.com.validabr.buscacep.gateway.entity.EnderecoEntity;
import lombok.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class EnderecoDTO {

    private String cep;
    private String logradouro;
    private String tipo_logradouro;
    private String complemento;
    private String local;
    private String cidade;
    private String estado;


    private EnderecoDTO(EnderecoEntity endereco, BairroCidadeEntity cidade) {
        this(
                endereco.getCep(),
                endereco.getLogradouro(),
                endereco.getTipoLogradouro(),
                endereco.getComplemento(),
                endereco.getLocal(),
                cidade.getCidade(),
                cidade.getUf()
        );
    }

    public static EnderecoDTO createEnderecoDTO(EnderecoEntity endereco, BairroCidadeEntity cidade) {
        return new EnderecoDTO(endereco, cidade);
    }
}
