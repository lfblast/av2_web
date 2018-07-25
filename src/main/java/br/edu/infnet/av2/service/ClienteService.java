package br.edu.infnet.av2.service;

import br.edu.infnet.av2.model.Cliente;
import br.edu.infnet.av2.repository.ClienteRepo;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ClienteService {

    @Autowired
    private ClienteRepo clienteRepo;

    public Cliente findById(Long id) {
        Optional<Cliente> clienteOpt = clienteRepo.findById(id);
        return clienteOpt.get();
    }

    public List<Cliente> findAll() {
        return clienteRepo.findAll();
    }

    public void save(Cliente cliente) {
        clienteRepo.save(cliente);
    }

    public void delete(Cliente cliente) {
        clienteRepo.delete(cliente);
    }

    public ClienteRepo getClienteRepo() {
        return clienteRepo;
    }

    public void setClienteRepo(ClienteRepo clienteRepo) {
        this.clienteRepo = clienteRepo;
    }
}