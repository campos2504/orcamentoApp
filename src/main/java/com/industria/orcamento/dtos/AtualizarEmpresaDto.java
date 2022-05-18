package com.industria.orcamento.dtos;

import com.industria.orcamento.models.enums.Estado;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class AtualizarEmpresaDto {

    private Long id;
    
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
