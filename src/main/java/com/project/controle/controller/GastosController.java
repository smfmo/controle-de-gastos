package com.project.controle.controller;

import com.project.controle.model.Gastos;
import com.project.controle.service.GastosService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.math.BigDecimal;
import java.util.List;

@Controller
@RequestMapping("/controle")
@RequiredArgsConstructor
public class GastosController {

    private final GastosService service;

    @GetMapping
    public String listarGastos(Model model){
        model.addAttribute("gastos", service.listarGastos());
        model.addAttribute("total", service.calcularGastos());
        return "gastos";
    }

    @PostMapping
    public String salvar(@ModelAttribute Gastos gastos) {
        service.salvar(gastos);
        return "redirect:/controle";
    }
}
