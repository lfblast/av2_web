package br.edu.infnet.av2.controller;

import br.edu.infnet.av2.controller.util.ControllerUtil;
import static br.edu.infnet.av2.controller.util.ControllerUtil.recuperaParametro;
import br.edu.infnet.av2.model.Cliente;
import br.edu.infnet.av2.model.Endereco;
import br.edu.infnet.av2.service.ClienteService;
import br.edu.infnet.av2.service.EnderecoService;
import java.io.Serializable;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component
@Scope("session")
public class EnderecoBean implements Serializable {
    
    private static final long serialVersionUID = 1L;
    
    @Autowired
    private EnderecoService enderecoService;
    @Autowired
    private ClienteService clienteService;
    private List<Endereco> enderecos;
    private Endereco endereco = new Endereco();
    private Cliente cliente = new Cliente();
    
    public String cadastrar() {
        
        cliente = new Cliente();
        
        String id = recuperaParametro("idCli");
        cliente = clienteService.findById(new Long(id));
        
        endereco.setCliente(cliente);
        enderecoService.save(endereco);
        
        return "ConsultaClientes?faces-redirect=true";
    }
    
    public String remover() {
        
        cliente = new Cliente();
        
        String id = ControllerUtil.recuperaParametro("idEnd");
        Endereco end = enderecoService.findById(new Long(id));
        
        id = ControllerUtil.recuperaParametro("idCli");
        cliente = clienteService.findById(new Long(id));
        cliente.getEnderecos().remove(end);
        
        clienteService.save(cliente);
               
        return "ConsultaClientes?faces-redirect=true";
    }
    
    public String preparaCadastro() {
        
        endereco = new Endereco();
        
        String id = ControllerUtil.recuperaParametro("idCli");
        cliente = clienteService.findById(new Long(id));
        
        return "CadastroEndereco?faces-redirect=true";
    }

    public EnderecoService getEnderecoService() {
        return enderecoService;
    }

    public void setEnderecoService(EnderecoService enderecoService) {
        this.enderecoService = enderecoService;
    }

    public ClienteService getClienteService() {
        return clienteService;
    }

    public void setClienteService(ClienteService clienteService) {
        this.clienteService = clienteService;
    }
    
    public List<Endereco> getEnderecos() {
        return enderecos;
    }

    public void setEnderecos(List<Endereco> enderecos) {
        this.enderecos = enderecos;
    }

    public Endereco getEndereco() {
        return endereco;
    }

    public void setEndereco(Endereco endereco) {
        this.endereco = endereco;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }
}