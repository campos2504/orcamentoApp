package com.industria.orcamento.services.implemantations;

import java.util.List;

import javax.persistence.EntityNotFoundException;

import com.industria.orcamento.dtos.AtualizarContatoDto;
import com.industria.orcamento.dtos.CadastroContatoDto;
import com.industria.orcamento.models.entitys.Contato;
import com.industria.orcamento.models.entitys.Empresa;
import com.industria.orcamento.repositorys.ContatoRepository;
import com.industria.orcamento.repositorys.EmpresaRepository;
import com.industria.orcamento.services.ContatoService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ContatoServiceImpl implements ContatoService {

    @Autowired
    ContatoRepository repository;

    @Autowired
    EmpresaRepository eRepository;

    @Override
    public List<Contato> listarContatos(Long idEmpresa) {
        return eRepository.findById(idEmpresa)
                .orElseThrow(EntityNotFoundException::new).getContatos();
    }

    @Override
    public Contato salvarContato(CadastroContatoDto contatoDto) {
        Empresa empresa = eRepository.findById(contatoDto.getEmpresaId())
        .orElseThrow(EntityNotFoundException::new);

        Contato contato = Contato.builder()
        .nome(contatoDto.getNome())
        .email(contatoDto.getEmail())
        .telefone(contatoDto.getTelefone())
        .departamento(contatoDto.getDepartamento())
        .empresa(empresa)
        .observacao(contatoDto.getObservacao())
        .build();

        return repository.save(contato);
    }

    @Override
    public void deletarContatoPeloId(Long id) {
        repository.deleteById(id);
    }

    @Override
    public Contato buscarContatoPeloId(Long id) {
        
        return repository.findById(id).orElseThrow(EntityNotFoundException::new);
    }

    @Override
    public void atualizarContato(AtualizarContatoDto contatoDto) {

        Contato contato= repository.findById(contatoDto.getId())
        .orElseThrow(EntityNotFoundException::new);

        contato.setNome(contatoDto.getNome());
        contato.setEmail(contatoDto.getEmail());
        contato.setDepartamento(contatoDto.getDepartamento());
        contato.setTelefone(contatoDto.getTelefone());
        contato.setObservacao(contatoDto.getObservacao());

        repository.save(contato);

    }

}
