package com.project.controle.repository;

import com.project.controle.model.Gastos;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.UUID;

public interface GastosRepository extends JpaRepository<Gastos, UUID> {}
