package com.example.prova.controller;

import com.example.prova.model.PedidosModel;
import com.example.prova.service.PedidosService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/pedidos")
public class PedidoController {

    @Autowired
    private PedidosService pedidosService;

    @PostMapping
    public PedidosModel save(@RequestBody PedidosModel pedido) {
        return pedidosService.save(pedido);
    }

    @GetMapping("/{status}")
    public List<PedidosModel> findByStatus(@PathVariable String status){
        return pedidosService.findByStatus(status);
    }

    @PutMapping("/mover_Aberto/{id}")
    public PedidosModel emAberto(@PathVariable int id){
        return pedidosService.emAberto(id);
    }

    @PutMapping("/mover_Em_Preparação/{id}")
    public PedidosModel EmPreparação(@PathVariable int id){
        return pedidosService.EmPreparação(id);
    }

    @PutMapping("/Finalizado/{id}")
    public PedidosModel Finalizado(@PathVariable int id){
        return pedidosService.Finalizado(id);
    }

    @DeleteMapping("/{id}/deletar")
    public PedidosModel deletarPedido(@PathVariable int id){
        return pedidosService.deletarPedido(id);
    }
}
