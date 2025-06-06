package com.project.controle.controller;

import com.project.controle.model.ContasBancarias;
import com.project.controle.model.Gastos;
import com.project.controle.service.ContasBancariasService;
import com.project.controle.service.GastosService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@Controller
@RequestMapping("/controle")
@RequiredArgsConstructor
public class GastosController {

    private final GastosService gastosService;
    private final ContasBancariasService contasBancariasService;

    @GetMapping
    public String listarGastos(Model model){
        model.addAttribute("gastos", gastosService.listarGastos());
        model.addAttribute("total", gastosService.calcularGastos());
        model.addAttribute("contas", contasBancariasService.listarContasBancarias());
        return "gastos";
    }

    @PostMapping
    public String salvar(@ModelAttribute Gastos gastos,
                         @RequestParam UUID contaId) {
        gastosService.salvar(gastos, contaId);
        return "redirect:/controle";
    }

    @PostMapping("/excluir")
    public String excluir(@RequestParam("id") UUID id){
        gastosService.excluirGastos(id);
        return "redirect:/controle";
    }
}
