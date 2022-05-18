package com.industria.orcamento.models.entitys;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
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
public class Item {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String numero;

    private String nome;

    private String desenho;

    private Integer quantidade;

    private String observacao;

    @ManyToOne()
    @JoinColumn(name = "orcamento_id")
    private Orcamento orcamento;

    @ManyToOne()
    @JoinColumn(name = "parentitem_id")
    private Item parentItem;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "parentItem", 
    orphanRemoval = true, fetch = FetchType.LAZY)
    List<Item> subItens;


    @OneToMany(cascade = CascadeType.ALL, mappedBy = "item", 
    orphanRemoval = true, fetch = FetchType.LAZY)
    List<Recurso> recursos;

    

}
