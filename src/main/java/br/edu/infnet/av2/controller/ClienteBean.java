package br.edu.infnet.av2.controller;

import br.edu.infnet.av2.model.Cliente;
import java.io.Serializable;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;
import br.edu.infnet.av2.repository.ClienteRepo;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import javax.faces.context.FacesContext;
import org.springframework.beans.factory.annotation.Autowired;

@Component
@Scope("session")
public class ClienteBean implements Serializable {
    
    private static final long serialVersionUID = 1L;
    
    @Autowired
    private ClienteRepo clienteRepo;
    private List<Cliente> clientes;
    private Cliente cliente = new Cliente();

    public String listar() {
        
        cliente = new Cliente();
        clientes = clienteRepo.findAll();        
        
        return "/cliente/ConsultaClientes?faces-redirect=true";
    }
    
    public String detalhar() {
        
        String id = recuperaParametro("idCli");
        
        Optional<Cliente> clienteOpt = clienteRepo.findById(new Long(id));
        cliente = clienteOpt.get();        
                
        return "/cliente/DetalhesCliente?faces-redirect=true";
    }
    
    public String cadastrar() {
        
        clienteRepo.save(cliente);
        
        return listar();
    }
    
    public String alterar() {
        
        String id = recuperaParametro("idCli");
        
        Optional<Cliente> clienteOpt = clienteRepo.findById(new Long(id));
        Cliente clienteCadastrado = clienteOpt.get();
        
        clienteCadastrado.setNome(cliente.getNome());
        clienteRepo.save(clienteCadastrado);
        
        return listar();
    }
    
    public String remover() {
        
        String id = recuperaParametro("idCli");
        
        Optional<Cliente> clienteOpt = clienteRepo.findById(new Long(id));
        Cliente ingr = clienteOpt.get();
        
        clienteRepo.delete(ingr);
        
        return listar();
    }
    
    private String recuperaParametro(String param) {
        
        FacesContext context = FacesContext.getCurrentInstance();
        Map requestMap = context.getExternalContext().getRequestParameterMap();
        String parametro = (String)requestMap.get(param);
        
        return parametro;
    }
    
    public ClienteRepo getClienteRepo() {
        return clienteRepo;
    }

    public void setClienteRepo(ClienteRepo clienteRepo) {
        this.clienteRepo = clienteRepo;
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