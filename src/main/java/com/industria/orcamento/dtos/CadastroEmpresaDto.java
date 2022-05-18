package com.industria.orcamento.dtos;

import com.industria.orcamento.models.enums.Estado;

import lombok.Data;

@Data
public class CadastroEmpresaDto {
    private String nome;

    private String atividade;

    private String cnpj;

    private String inscricaoEstadual;

	private String cep;
    
	private String cidade;
	
    private Estado estado;

	private String bairro;

	private String logradouro;
	
	private String numero;
	
	private String complemento;

    private String observacao;
}
