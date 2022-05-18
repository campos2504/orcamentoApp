package com.industria.orcamento.services.implemantations;

import java.util.List;

import com.industria.orcamento.dtos.CriarOrcamentoDto;
import com.industria.orcamento.models.entitys.Orcamento;
import com.industria.orcamento.repositorys.OrcamentoRepository;
import com.industria.orcamento.services.OrcamentoService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class OrcamentoServiceImpl implements OrcamentoService {

    @Autowired
    OrcamentoRepository service;

    @Override
    public List<Orcamento> listarOrcamento() {
        return service.findAll();
    }

    @Override
    public void deletarOrcamentoPeloId(Long id) {
        service.deleteById(id);
        
    }

    @Override
    public void salvarOrcamento(CriarOrcamentoDto orcamentoDto) {
        // TODO Auto-generated method stub
        
    }

    

}
