package br.edu.infnet.av2.controller;

import br.edu.infnet.av2.controller.util.ControllerUtil;
import br.edu.infnet.av2.model.Cliente;
import java.io.Serializable;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;
import br.edu.infnet.av2.service.ClienteService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;

@Component
@Scope("session")
public class ClienteBean implements Serializable {
    
    private static final long serialVersionUID = 1L;
    
    @Autowired
    private ClienteService clienteService;
    private List<Cliente> clientes;
    private Cliente cliente = new Cliente();

    public String listar() {
        
        cliente = new Cliente();
        clientes = clienteService.findAll();        
        
        return "/cliente/ConsultaClientes?faces-redirect=true";
    }
    
    public String detalhar() {
        
        String id = ControllerUtil.recuperaParametro("idCli");
        cliente = clienteService.findById(new Long(id));       
                
        return "/cliente/DetalhesCliente?faces-redirect=true";
    }
    
    public String cadastrar() {
        
        clienteService.save(cliente);
        
        return listar();
    }
    
    public String alterar() {
        
        String id = ControllerUtil.recuperaParametro("idCli");
        
        Cliente clienteCadastrado = clienteService.findById(new Long(id));
        
        clienteCadastrado.setNome(cliente.getNome());
        clienteService.save(clienteCadastrado);
        
        return listar();
    }
    
    public String remover() {
        
        String id = ControllerUtil.recuperaParametro("idCli");
        
        Cliente cli = clienteService.findById(new Long(id));
        clienteService.delete(cli);
        
        return listar();
    }
    
    public ClienteService getClienteService() {
        return clienteService;
    }

    public void setClienteService(ClienteService clienteService) {
        this.clienteService = clienteService;
    }

    public List<Cliente> getClientes() {
        return clientes;
    }

    public void setClientes(List<Cliente> clientes) {
        this.clientes = clientes;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }
}