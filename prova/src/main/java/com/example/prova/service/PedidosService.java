package com.example.prova.service;

import com.example.prova.model.PedidosModel;
import com.example.prova.repository.PedidoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PedidosService {
    @Autowired
    private PedidoRepository pedidoRepository;

    public PedidosModel save(PedidosModel pedido) {
        pedido.setStatus("Aberto");
        return pedidoRepository.save(pedido);
    }

    public List<PedidosModel> findByStatus(String status) {
        return pedidoRepository.findByStatus(status);
    }

    public PedidosModel emAberto(int id) {
        Optional<PedidosModel> tarefa = pedidoRepository.findById(id);
        tarefa.get().setStatus("Aberto");
        return pedidoRepository.save(tarefa.get());
    }

    public PedidosModel EmPreparação(int id) {
        Optional<PedidosModel> tarefa = pedidoRepository.findById(id);
        tarefa.get().setStatus("Em_Preparação");
        return pedidoRepository.save(tarefa.get());
    }

    public PedidosModel Finalizado(int id) {
        Optional<PedidosModel> tarefa = pedidoRepository.findById(id);
        tarefa.get().setStatus("Finalizado");
        return pedidoRepository.save(tarefa.get());
    }

    public PedidosModel deletarPedido(int id) {
        Optional<PedidosModel> pedido = pedidoRepository.findById(id);
        PedidosModel deletar = pedido.get();
        pedidoRepository.delete(deletar);
        System.out.println("Pedido excluido!");
        return deletar;
    }
}
