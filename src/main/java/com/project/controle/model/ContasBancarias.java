package com.project.controle.model;

import com.project.controle.model.Enum.TiposContas;
import jakarta.persistence.*;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Entity
@Data
@Table(name = "contas_bancarias",
        schema = "public")
public class ContasBancarias {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    @Column(name = "nome")
    private String nome;

    @Column(name = "tipo")
    private TiposContas tipo;

    @Column(name = "instituicao")
    private String instituicao;

    @OneToMany
    private List<Gastos> gastos = new ArrayList<>();

}
