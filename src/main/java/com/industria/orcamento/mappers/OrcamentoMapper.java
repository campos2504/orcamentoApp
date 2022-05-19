package com.industria.orcamento.mappers;

import com.industria.orcamento.dtos.AtualizarOrcamentoDto;
import com.industria.orcamento.models.entitys.Orcamento;

public class OrcamentoMapper {

    public static AtualizarOrcamentoDto toAttOrcamentoDto(Orcamento orcamento) {
        return AtualizarOrcamentoDto.builder()
        .id(orcamento.getId())
        .numero(orcamento.getNumero())
        .contatoId(orcamento.getContato().getId())
        .empresaId(orcamento.getEmpresa().getId())
        .observacao(orcamento.getObservacao())
        .build();
    }

}
