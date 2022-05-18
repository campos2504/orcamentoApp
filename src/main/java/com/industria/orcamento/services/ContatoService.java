package com.industria.orcamento.services;

import java.util.List;

import com.industria.orcamento.dtos.AtualizarContatoDto;
import com.industria.orcamento.dtos.CadastroContatoDto;
import com.industria.orcamento.models.entitys.Contato;

public interface ContatoService {

    List<Contato> listarContatos(Long idEmpresa);

    Contato salvarContato(CadastroContatoDto contatoDto);

    void deletarContatoPeloId(Long id);

    Contato buscarContatoPeloId(Long id);

    void atualizarContato(AtualizarContatoDto contatoDto);

}
