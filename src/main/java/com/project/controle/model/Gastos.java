package com.project.controle.model;

import com.project.controle.model.Enum.CategoriaGasto;
import jakarta.persistence.*;
import lombok.Data;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.UUID;

@Entity
@Data
@Table(name = "gastos",
        schema = "public")
public class Gastos {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    @Column(name = "titulo")
    private String titulo;

    @Column(name = "data")
    private LocalDateTime data;

    @Column(name = "descricao")
    private String descricao;

    @Enumerated(EnumType.STRING)
    @Column(name = "categoria")
    private CategoriaGasto categoria;

    @Column(name = "valor_gasto")
    private BigDecimal valorGasto;

    @ManyToOne
    @JoinColumn(name = "conta_id")
    private ContasBancarias contasBancarias;
}
