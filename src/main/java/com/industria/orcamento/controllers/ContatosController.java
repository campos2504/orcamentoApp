package com.industria.orcamento.controllers;

import com.industria.orcamento.dtos.AtualizarContatoDto;
import com.industria.orcamento.dtos.CadastroContatoDto;
import com.industria.orcamento.models.entitys.Contato;
import com.industria.orcamento.services.ContatoService;
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
@RequestMapping("/empresas/{idEmpresa}/contatos")
public class ContatosController {
    
    
    @Autowired
    ContatoService service;
    @Autowired
    EmpresaService eService;

    @GetMapping
    public String listarContatos(@PathVariable Long idEmpresa,Model model) {
        model.addAttribute("empresa", eService.buscarEmpresaPeloId(idEmpresa));
        model.addAttribute("contatos", service.listarContatos(idEmpresa));

        return "contatos/listarContatos";
    }

    @GetMapping("/cadastrar")
    public String criarContatoForm(@PathVariable Long idEmpresa,Model model) {
        model.addAttribute("empresa", eService.buscarEmpresaPeloId(idEmpresa));
        CadastroContatoDto contato = new CadastroContatoDto();
        model.addAttribute("contato", contato);
        return "contatos/cadastrarContato";

    }

    @PostMapping()
    public String salvarContato(@PathVariable Long idEmpresa, @ModelAttribute("contato") CadastroContatoDto contatoDto) {
        contatoDto.setEmpresaId(idEmpresa);
        service.salvarContato(contatoDto);
        return "redirect:/empresas/"+idEmpresa+"/contatos";
    }

    @GetMapping("deletar/{id}")
	public String deletar(@PathVariable Long id) {
		service.deletarContatoPeloId(id);
		return "redirect:/empresas";
	}

    @GetMapping("/edit/{id}")
    public String atualizarCliente(@PathVariable Long idEmpresa,@PathVariable Long id, Model model) {
       Contato contato=service.buscarContatoPeloId(id);
        model.addAttribute("contato", contato);
        return "contatos/atualizarContato";
    }

    @PostMapping("/{id}")
    public String atualizar(@PathVariable Long idEmpresa, @PathVariable Long id,
            @ModelAttribute("empresa") AtualizarContatoDto contatoDto,
            Model model) {
                contatoDto.setId(id);
        service.atualizarContato(contatoDto);
        return "redirect:/empresas/"+idEmpresa+"/contatos";
    }


    


    
    
}
