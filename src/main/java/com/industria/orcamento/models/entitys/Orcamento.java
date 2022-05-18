package com.industria.orcamento.models.entitys;


import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
public class Orcamento {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String numero;

    @Embedded
    private CondicaoFornecimento condicoes;

    private String observacao;

    @CreationTimestamp
    @Column(nullable = false)
    private Date dataCadastro;

    @UpdateTimestamp
    @Column(nullable = false)
    private Date dataAtualizacao;

    @ManyToOne()
    @JoinColumn(name = "empresa_id")
    private Empresa empresa;

    @ManyToOne()
    @JoinColumn(name = "contato_id")
    private Contato contato;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "orcamento",
     orphanRemoval = true, fetch = FetchType.EAGER)
    List<Item> itens;

}
