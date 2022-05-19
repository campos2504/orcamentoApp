package com.industria.orcamento.dtos;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class AtualizarOrcamentoDto {
    private Long id;
    private String numero;
    private String observacao;
    private Long empresaId;
    private Long contatoId;

}
