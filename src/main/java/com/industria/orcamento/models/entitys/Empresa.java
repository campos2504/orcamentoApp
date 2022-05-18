package com.industria.orcamento.models.entitys;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
public class Empresa {
    

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nome;

    private String atividade;

    private String cnpj;

    private String inscricaoEstadual;

    @Embedded
    private Endereco endereco;

    private String observacao;

    @OneToMany(cascade = CascadeType.ALL,mappedBy = "empresa",
     orphanRemoval=true, fetch = FetchType.LAZY)
    List<Contato> contatos;

    public void addContato(Contato contato) {

        contato.setEmpresa(this);
        this.contatos.add(contato);
        
    }

    public void removerContato(){
        
    }


}
