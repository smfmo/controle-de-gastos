package com.project.controle.controller;

import com.project.controle.model.ContasBancarias;
import com.project.controle.service.ContasBancariasService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@Controller
@RequestMapping("/contas")
@RequiredArgsConstructor
public class ContasBancariasController {

    private final ContasBancariasService service;

    @GetMapping
    public String listarContas(Model model) {
        model.addAttribute("contas", service.listarContasBancarias());
        return "contas-bancarias";
    }

    @PostMapping
    public String cadastrarConta(@ModelAttribute ContasBancarias contas) {
        service.cadastrarConta(contas);
        return "redirect:/contas";
    }

    @PostMapping("/excluir")
    public String excluirConta(@RequestParam("id") UUID id){
        service.excluirConta(id);
        return "redirect:/contas";
    }

}
