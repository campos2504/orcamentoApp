package com.industria.orcamento.configuratios;

import com.industria.orcamento.models.entitys.Contato;
import com.industria.orcamento.models.entitys.Empresa;
import com.industria.orcamento.models.entitys.Endereco;
import com.industria.orcamento.models.entitys.Orcamento;
import com.industria.orcamento.models.enums.Estado;
import com.industria.orcamento.repositorys.ContatoRepository;
import com.industria.orcamento.repositorys.EmpresaRepository;
import com.industria.orcamento.repositorys.OrcamentoRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class testsEmpresas {
    @Autowired
    EmpresaRepository repository;

    @Autowired
    ContatoRepository cRepository;

    @Autowired
    OrcamentoRepository oRepository;

    @Bean
    public void addEmpresas() {

        var e=Empresa.builder()
        .nome("CSN")
        .atividade("Mineracao")
        .cnpj("123")
        .inscricaoEstadual("123")
        .endereco(Endereco.builder()
        .cep("1123456")
        .estado(Estado.RJ)
        .cidade("volta redonda")
        .logradouro("rua 1")
        .numero("123")
        .build())
        .observacao("PageMaker including versions of Lorem Ipsum.")
        .build();
        e=repository.save(e);
        System.out.println("AAAAAAAAAAAAAAAAAA" + e.getId());

        Contato contato = Contato.builder()
        .nome("Jaoa")
        .email("joao@gmail.com")
        .telefone("31-33334444")
        .departamento("Compras")
        .empresa(e)
        .observacao("Gente Boa")
        .build();

        contato = cRepository.save(contato);
        System.out.println("AAAAAAAAAAAAAAAAAA" + contato.getId());

        Orcamento orcamento = Orcamento.builder()
        .numero("123")
        .observacao("sem item")
        .empresa(e)
        .contato(contato)
        .build();
        
        oRepository.save(orcamento);
    }
}
