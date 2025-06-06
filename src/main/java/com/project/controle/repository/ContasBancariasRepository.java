package com.project.controle.repository;

import com.project.controle.model.ContasBancarias;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.UUID;

public interface ContasBancariasRepository extends JpaRepository<ContasBancarias, UUID> {
}
