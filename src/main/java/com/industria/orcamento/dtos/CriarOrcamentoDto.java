package com.industria.orcamento.dtos;

import lombok.Data;

@Data
public class CriarOrcamentoDto {

    private String numero;
    private String observacao;
    private Long empresaId;
    private Long contatoId;

}
