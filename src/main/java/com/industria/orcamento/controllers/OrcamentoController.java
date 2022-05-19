package com.industria.orcamento.controllers;

import java.util.List;

import com.industria.orcamento.dtos.AtualizarOrcamentoDto;
import com.industria.orcamento.dtos.CriarOrcamentoDto;
import com.industria.orcamento.mappers.OrcamentoMapper;
import com.industria.orcamento.models.entitys.Contato;
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
import org.springframework.web.bind.annotation.ResponseBody;

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

        model.addAttribute("numero", "1234");
        model.addAttribute("orcamento", orcamentoDto);
        return "orcamentos/criarOrcamento";

    }

    @GetMapping("/empresas")
    @ResponseBody
    public List<Empresa> getEmpresas() {
        return eService.listarEmpresas();

    }
    @GetMapping("/contatos/{id}")
    @ResponseBody
    public List<Contato> getContatos(@PathVariable Long id) {
        return eService.buscarEmpresaPeloId(id).getContatos();

    }

    @GetMapping("deletar/{id}")
	public String deletar(@PathVariable Long id) {
		service.deletarOrcamentoPeloId(id);
		return "redirect:/orcamentos";
	}

    @PostMapping()
    public String salvarOrcamento(@ModelAttribute("orcamento") CriarOrcamentoDto orcamentoDto) {
        service.salvarOrcamento(orcamentoDto);
        return "redirect:/orcamentos";
    }

    

    @GetMapping("/edit/{id}")
    public String atualizar(@PathVariable Long id, Model model) {
        AtualizarOrcamentoDto orcamentoDto=OrcamentoMapper.toAttOrcamentoDto(service.buscarOrcamentoPeloId(id));
        model.addAttribute("orcamento", orcamentoDto);
        model.addAttribute("numero", orcamentoDto.getNumero());
        return "orcamentos/atualizarOrcamento";
    }

    @PostMapping("/{id}")
    public String atualizar(@PathVariable Long id,
            @ModelAttribute("orcamento") AtualizarOrcamentoDto orcamentoDto,
            Model model) {
                orcamentoDto.setId(id);
        service.atualizar(orcamentoDto);
        return "redirect:/orcamentos";
    }

}
