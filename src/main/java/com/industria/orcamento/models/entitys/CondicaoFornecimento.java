package com.industria.orcamento.models.entitys;

import javax.persistence.Embeddable;

import lombok.Data;

@Embeddable
@Data
public class CondicaoFornecimento {

    private String prazo;
    private String diasPagamento;
    private String impostos;
    private String validade;
    private String ciFiscal;

}
