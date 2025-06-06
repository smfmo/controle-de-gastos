package com.project.controle.service;

import com.project.controle.model.ContasBancarias;
import com.project.controle.model.Gastos;
import com.project.controle.repository.ContasBancariasRepository;
import com.project.controle.repository.GastosRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class GastosService {

    private final GastosRepository repository;
    private final ContasBancariasRepository contasBancariasRepository;

    public List<Gastos> listarGastos() {
        return repository.findAll();
    }

    public void salvar(Gastos gasto, UUID contaId) {
        ContasBancarias contas = contasBancariasRepository
                .findById(contaId)
                .orElseThrow(() -> new RuntimeException("Conta não encontrada"));

        gasto.setContasBancarias(contas);
        repository.save(gasto);
    }

    public BigDecimal calcularGastos() {
        List<Gastos> gastos = listarGastos();
        return gastos.stream()
                .map(Gastos::getValorGasto)
                .reduce(BigDecimal.ZERO, BigDecimal::add);
    }
}
