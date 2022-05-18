package com.industria.orcamento.services;

import java.util.List;

import com.industria.orcamento.dtos.AtualizarEmpresaDto;
import com.industria.orcamento.dtos.CadastroEmpresaDto;
import com.industria.orcamento.models.entitys.Empresa;

public interface EmpresaService {

    List<Empresa> listarEmpresas();

    Empresa salvarEmpresa(CadastroEmpresaDto empresaDto);

    void deletarEmpresaPeloId(Long id);

    Empresa buscarEmpresaPeloId(Long id);

    Empresa atualizarEmpresa(AtualizarEmpresaDto empresaDto);
    
}
