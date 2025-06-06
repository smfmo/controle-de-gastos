package com.project.controle.service;

import com.project.controle.model.ContasBancarias;
import com.project.controle.repository.ContasBancariasRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class ContasBancariasService {

    private final ContasBancariasRepository repository;

    public List<ContasBancarias> listarContasBancarias() {
        return repository.findAll();
    }

    public void cadastrarConta(ContasBancarias conta) {
        repository.save(conta);
    }

    public void excluirConta(UUID id) {
        repository.deleteById(id);
    }
}
