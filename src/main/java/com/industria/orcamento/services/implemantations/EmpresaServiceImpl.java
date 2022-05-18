package com.industria.orcamento.services.implemantations;

import java.util.List;

import javax.persistence.EntityNotFoundException;

import com.industria.orcamento.dtos.AtualizarEmpresaDto;
import com.industria.orcamento.dtos.CadastroEmpresaDto;
import com.industria.orcamento.mappers.EmpresaMapper;
import com.industria.orcamento.models.entitys.Empresa;
import com.industria.orcamento.repositorys.EmpresaRepository;
import com.industria.orcamento.services.EmpresaService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class EmpresaServiceImpl implements EmpresaService {

    @Autowired
    EmpresaRepository empresaRepository;

    @Override
    public List<Empresa> listarEmpresas() {
        return empresaRepository.findAll();
    }

    @Override
    public Empresa salvarEmpresa(CadastroEmpresaDto empresaDto) {
        
        return empresaRepository.save(EmpresaMapper.toEmpresa(empresaDto));
        
    }

    @Override
    public void deletarEmpresaPeloId(Long id) {
        empresaRepository.deleteById(id);
        
    }

    @Override
    public Empresa buscarEmpresaPeloId(Long id) {
        
        return empresaRepository.findById(id).get();
    }

    @Override
    public Empresa atualizarEmpresa(AtualizarEmpresaDto empresaDto) {
        
        Empresa empresa = empresaRepository.findById(empresaDto.getId()).orElseThrow(EntityNotFoundException::new);
        EmpresaMapper.setEmpresa(empresa, empresaDto);
        return empresaRepository.save(empresa);
        
        
    }

    
}
