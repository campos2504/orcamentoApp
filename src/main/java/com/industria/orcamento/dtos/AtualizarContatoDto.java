package com.industria.orcamento.dtos;

import lombok.Data;

@Data
public class AtualizarContatoDto {


    private Long id;

    private String nome;

    private String email;

    private String telefone;

    private String departamento;

    private String observacao;
    
    private Long empresaId;
}
