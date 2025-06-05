package com.project.controle.service;

import com.project.controle.model.Gastos;
import com.project.controle.repository.GastosRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class GastosService {

    private final GastosRepository repository;

    public List<Gastos> listarGastos() {
        return repository.findAll();
    }

    public BigDecimal calcularGastos() {
        List<Gastos> gastos = listarGastos();
        return gastos.stream()
                .map(Gastos::getValorGasto)
                .reduce(BigDecimal.ZERO, BigDecimal::add);
    }

    public void salvar(Gastos gasto) {
        repository.save(gasto);
    }
}
