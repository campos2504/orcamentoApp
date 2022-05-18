package com.industria.orcamento.controllers;

import java.util.List;


import com.industria.orcamento.dtos.CriarOrcamentoDto;

import com.industria.orcamento.models.entitys.Empresa;
import com.industria.orcamento.models.entitys.Orcamento;
import com.industria.orcamento.services.ContatoService;
import com.industria.orcamento.services.EmpresaService;
import com.industria.orcamento.services.OrcamentoService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/orcamentos")
public class OrcamentoController {

    @Autowired
    OrcamentoService service;

    @Autowired
    EmpresaService eService;

    @Autowired
    ContatoService cService; 

    @GetMapping
    public String getAll(Model model) {

        List<Orcamento> orcamentos = service.listarOrcamento();

        model.addAttribute("orcamentos", orcamentos);

        return "orcamentos/listarOrcamentos";
    }

    @GetMapping("/criar")
    public String create(Model model) {

        CriarOrcamentoDto orcamentoDto = new CriarOrcamentoDto();
        List<Empresa> empresas = eService.listarEmpresas();

        model.addAttribute("numero", "1234");
        model.addAttribute("empresas", empresas);
        model.addAttribute("orcamento", orcamentoDto);
        return "orcamentos/criarOrcamento";

    }

    @GetMapping("deletar/{id}")
	public String deletar(@PathVariable Long id) {
		service.deletarOrcamentoPeloId(id);
		return "redirect:/orcamentos";
	}

    @PostMapping()
    public String salvarEmpresa(@ModelAttribute("empresa") CriarOrcamentoDto orcamentoDto) {
        service.salvarOrcamento(orcamentoDto);
        return "redirect:/orcamentos";
    }

    

    // @GetMapping("/edit/{id}")
    // public String atualizarEmpresa(@PathVariable Long id, Model model) {
    //     AtualizarEmpresaDto empresaDto=EmpresaMapper.toAttEmpresaDto(service.buscarEmpresaPeloId(id));
    //     Estado[] estados = Estado.values();
    //     model.addAttribute("options", estados);
    //     model.addAttribute("empresa", empresaDto);
    //     return "empresas/atualizarEmpresa";
    // }

    // @PostMapping("/{id}")
    // public String atualizar(@PathVariable Long id,
    //         @ModelAttribute("empresa") AtualizarEmpresaDto empresaDto,
    //         Model model) {
    //             empresaDto.setId(id);
    //     service.atualizarEmpresa(empresaDto);
    //     return "redirect:/empresas";
    // }

}
