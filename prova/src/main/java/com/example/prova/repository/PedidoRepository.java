package com.example.prova.repository;

import com.example.prova.model.PedidosModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PedidoRepository extends JpaRepository<PedidosModel, Integer> {
    List<PedidosModel> findByStatus(String status);
}
