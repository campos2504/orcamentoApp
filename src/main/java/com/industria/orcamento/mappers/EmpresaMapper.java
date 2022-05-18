package com.industria.orcamento.mappers;

import com.industria.orcamento.dtos.AtualizarEmpresaDto;
import com.industria.orcamento.dtos.CadastroEmpresaDto;
import com.industria.orcamento.models.entitys.Empresa;
import com.industria.orcamento.models.entitys.Endereco;




public class EmpresaMapper {

    public static AtualizarEmpresaDto toAttEmpresaDto(Empresa empresa){

        return AtualizarEmpresaDto.builder()
        .id(empresa.getId())
        .nome(empresa.getNome())
        .atividade(empresa.getAtividade())
        .cnpj(empresa.getCnpj())
        .inscricaoEstadual(empresa.getInscricaoEstadual())
        .cep(empresa.getEndereco().getCep())
        .estado(empresa.getEndereco().getEstado())
        .cidade(empresa.getEndereco().getCidade())
        .logradouro(empresa.getEndereco().getLogradouro())
        .numero(empresa.getEndereco().getNumero())
        .complemento(empresa.getEndereco().getComplemento())
        .observacao(empresa.getObservacao())
        .build();

    } 
    public static Empresa toEmpresa(CadastroEmpresaDto empresaDto){

        return Empresa.builder()
        .nome(empresaDto.getNome())
        .atividade(empresaDto.getAtividade())
        .cnpj(empresaDto.getCnpj())
        .inscricaoEstadual(empresaDto.getInscricaoEstadual())
        .endereco(Endereco.builder()
        .cep(empresaDto.getCep())
        .estado(empresaDto.getEstado())
        .cidade(empresaDto.getCidade())
        .logradouro(empresaDto.getLogradouro())
        .numero(empresaDto.getNumero())
        .complemento(empresaDto.getComplemento())
        .build())
        .observacao(empresaDto.getObservacao())
        .build();

    } 
    public static Empresa toEmpresa(AtualizarEmpresaDto empresaDto){

        return Empresa.builder()
        .id(empresaDto.getId())
        .nome(empresaDto.getNome())
        .atividade(empresaDto.getAtividade())
        .cnpj(empresaDto.getCnpj())
        .inscricaoEstadual(empresaDto.getInscricaoEstadual())
        .endereco(Endereco.builder()
        .cep(empresaDto.getCep())
        .estado(empresaDto.getEstado())
        .cidade(empresaDto.getCidade())
        .logradouro(empresaDto.getLogradouro())
        .numero(empresaDto.getNumero())
        .complemento(empresaDto.getComplemento())
        .build())
        .observacao(empresaDto.getObservacao())
        .build();
    }

    public static void setEmpresa(Empresa empresa, AtualizarEmpresaDto empresaDto){
        empresa.setNome(empresaDto.getNome());
        empresa.setAtividade(empresaDto.getAtividade());
        empresa.setCnpj(empresaDto.getCnpj());
        empresa.setInscricaoEstadual(empresaDto.getInscricaoEstadual());
        empresa.getEndereco().setCep(empresaDto.getCep());
        empresa.getEndereco().setEstado(empresaDto.getEstado());
        empresa.getEndereco().setCidade(empresaDto.getCidade());
        empresa.getEndereco().setBairro(empresaDto.getBairro());
        empresa.getEndereco().setLogradouro(empresaDto.getLogradouro());
        empresa.getEndereco().setNumero(empresaDto.getNumero());
        empresa.getEndereco().setComplemento(empresaDto.getComplemento());
        empresa.setObservacao(empresaDto.getObservacao());
    }
    
}
