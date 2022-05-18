package com.industria.orcamento.models.entitys;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;

import com.industria.orcamento.models.enums.Estado;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Embeddable
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Endereco {
    
    @Column(name = "endereco_cep")
	private String cep;

    @Column(name = "endereco_cidade")
	private String cidade;
	@Enumerated(value = EnumType.STRING)
    @Column(name = "endereco_estado")
    private Estado estado;
	
	@Column(name = "endereco_logradouro")
	private String logradouro;
	
	@Column(name = "endereco_numero")
	private String numero;
	
	@Column(name = "endereco_complemento")
	private String complemento;
	
	@Column(name = "endereco_bairro")
	private String bairro;
	
	
}
