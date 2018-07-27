package br.edu.infnet.av2.service;

import br.edu.infnet.av2.model.Pedido;
import br.edu.infnet.av2.repository.PedidoRepo;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PedidoService {

    @Autowired
    private PedidoRepo pedidoRepo;

    public Pedido findById(Long id) {
        Optional<Pedido> pedidoOpt = pedidoRepo.findById(id);
        return pedidoOpt.get();
    }

    public List<Pedido> findAll() {
        return pedidoRepo.findAll();
    }

    public void save(Pedido pedido) {
        pedidoRepo.save(pedido);
    }

    public void delete(Pedido pedido) {
        pedidoRepo.delete(pedido);
    }

    public PedidoRepo getPedidoRepo() {
        return pedidoRepo;
    }

    public void setPedidoRepo(PedidoRepo pedidoRepo) {
        this.pedidoRepo = pedidoRepo;
    }
}