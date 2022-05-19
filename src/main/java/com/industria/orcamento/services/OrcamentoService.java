package com.industria.orcamento.services;

import java.util.List;

import com.industria.orcamento.dtos.AtualizarOrcamentoDto;
import com.industria.orcamento.dtos.CriarOrcamentoDto;
import com.industria.orcamento.models.entitys.Orcamento;

public interface OrcamentoService {

    List<Orcamento> listarOrcamento();

    void deletarOrcamentoPeloId(Long id);

    Orcamento salvarOrcamento(CriarOrcamentoDto orcamentoDto);

    Orcamento buscarOrcamentoPeloId(Long id);

    void atualizar(AtualizarOrcamentoDto orcamentoDto);

}
