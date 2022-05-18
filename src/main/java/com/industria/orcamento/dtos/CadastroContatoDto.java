package com.industria.orcamento.dtos;

import lombok.Data;

@Data
public class CadastroContatoDto {

    private String nome;

    private String email;

    private String telefone;

    private String departamento;

    private String observacao;

    private Long empresaId;

}
