package com.industria.orcamento.services.implemantations;

import java.util.List;

import javax.persistence.EntityNotFoundException;

import com.industria.orcamento.dtos.AtualizarOrcamentoDto;
import com.industria.orcamento.dtos.CriarOrcamentoDto;
import com.industria.orcamento.models.entitys.Contato;
import com.industria.orcamento.models.entitys.Empresa;
import com.industria.orcamento.models.entitys.Orcamento;
import com.industria.orcamento.repositorys.ContatoRepository;
import com.industria.orcamento.repositorys.EmpresaRepository;
import com.industria.orcamento.repositorys.OrcamentoRepository;
import com.industria.orcamento.services.OrcamentoService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class OrcamentoServiceImpl implements OrcamentoService {

    @Autowired
    OrcamentoRepository service;
    @Autowired
    EmpresaRepository eRepository;
    @Autowired
    ContatoRepository cRepository;


    @Override
    public List<Orcamento> listarOrcamento() {
        return service.findAll();
    }

    @Override
    public void deletarOrcamentoPeloId(Long id) {
        service.deleteById(id);
        
    }

    @Override
    public Orcamento salvarOrcamento(CriarOrcamentoDto orcamentoDto) {

        Empresa empresa=eRepository.findById(orcamentoDto.getEmpresaId())
        .orElseThrow(EntityNotFoundException::new);

        Contato contato = cRepository.findById(orcamentoDto.getContatoId())
        .orElseThrow(EntityNotFoundException::new);
        Orcamento orcamento = Orcamento.builder()
        .numero(orcamentoDto.getNumero())
        .contato(contato)
        .empresa(empresa)
        .observacao(orcamentoDto.getObservacao())
        .build();
        return service.save(orcamento);
        
        
    }

    @Override
    public Orcamento buscarOrcamentoPeloId(Long id) {
        
        return service.findById(id).orElseThrow(EntityNotFoundException::new);
    }

    @Override
    public void atualizar(AtualizarOrcamentoDto orcamentoDto) {
        Orcamento orcamento = service.findById(orcamentoDto.getId())
        .orElseThrow(EntityNotFoundException::new);
        Empresa empresa=eRepository.findById(orcamentoDto.getEmpresaId())
        .orElseThrow(EntityNotFoundException::new);
        Contato contato = cRepository.findById(orcamentoDto.getContatoId())
        .orElseThrow(EntityNotFoundException::new);
        orcamento.setEmpresa(empresa);
        orcamento.setContato(contato);
        orcamento.setObservacao(orcamentoDto.getObservacao());
        service.save(orcamento);
        
    }

    

}
