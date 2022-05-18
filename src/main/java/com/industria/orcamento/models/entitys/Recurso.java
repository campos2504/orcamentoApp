package com.industria.orcamento.models.entitys;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import com.industria.orcamento.models.enums.RecursoTipo;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
public class Recurso {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;


    private String nome;

    private Double peso;

    private Double quantidade;

    private Double valor;

    private String observacao;

    @Enumerated(value = EnumType.STRING)
    private RecursoTipo recursoTipo;

    @ManyToOne()
    @JoinColumn(name = "item_id")
    private Item item;
    

}
