package com.industria.orcamento.controllers;

import com.industria.orcamento.dtos.AtualizarEmpresaDto;
import com.industria.orcamento.dtos.CadastroEmpresaDto;
import com.industria.orcamento.mappers.EmpresaMapper;
import com.industria.orcamento.models.enums.Estado;
import com.industria.orcamento.services.EmpresaService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/empresas")
public class EmpresaController {

    @Autowired
    EmpresaService service;

    @GetMapping
    public String listarEmpresas(Model model) {
        model.addAttribute("empresas", service.listarEmpresas());

        return "empresas/listarEmpresas";
    }

    @GetMapping("/cadastrar")
    public String criarEmpresaForm(Model model) {

        CadastroEmpresaDto empresa = new CadastroEmpresaDto();

        Estado[] estados = Estado.values();
        model.addAttribute("options", estados);
        model.addAttribute("empresa", empresa);
        return "empresas/cadastrarEmpresa";

    }

    @PostMapping()
    public String salvarEmpresa(@ModelAttribute("empresa") CadastroEmpresaDto empresaDto) {
        service.salvarEmpresa(empresaDto);
        return "redirect:/empresas";
    }

    @GetMapping("deletar/{id}")
	public String deletar(@PathVariable Long id) {
		service.deletarEmpresaPeloId(id);
		return "redirect:/empresas";
	}

    @GetMapping("/edit/{id}")
    public String atualizarEmpresa(@PathVariable Long id, Model model) {
        AtualizarEmpresaDto empresaDto=EmpresaMapper.toAttEmpresaDto(service.buscarEmpresaPeloId(id));
        Estado[] estados = Estado.values();
        model.addAttribute("options", estados);
        model.addAttribute("empresa", empresaDto);
        return "empresas/atualizarEmpresa";
    }

    @PostMapping("/{id}")
    public String atualizar(@PathVariable Long id,
            @ModelAttribute("empresa") AtualizarEmpresaDto empresaDto,
            Model model) {
                empresaDto.setId(id);
        service.atualizarEmpresa(empresaDto);
        return "redirect:/empresas";
    }

}
