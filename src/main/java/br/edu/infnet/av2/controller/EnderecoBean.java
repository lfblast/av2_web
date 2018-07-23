package br.edu.infnet.av2.controller;

import br.edu.infnet.av2.model.Cliente;
import br.edu.infnet.av2.model.Endereco;
import br.edu.infnet.av2.repository.ClienteRepo;
import br.edu.infnet.av2.repository.EnderecoRepo;
import java.io.Serializable;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import javax.faces.context.FacesContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component
@Scope("session")
public class EnderecoBean implements Serializable {
    
    private static final long serialVersionUID = 1L;
    
    @Autowired
    private EnderecoRepo enderecoRepo;
    @Autowired
    private ClienteRepo clienteRepo;
    private List<Endereco> enderecos;
    private Endereco endereco = new Endereco();
    private Cliente cliente = new Cliente();
    
    public String cadastrar() {
        
        cliente = new Cliente();
        
        String id = recuperaParametro("idCli");
        
        Optional<Cliente> clienteOpt = clienteRepo.findById(new Long(id));
        cliente = clienteOpt.get();
        
        endereco.setCliente(cliente);
        enderecoRepo.save(endereco);
        
        return "ConsultaClientes?faces-redirect=true";
    }
    
    public String remover() {
        
        cliente = new Cliente();
        
        String id = recuperaParametro("idEnd");
        
        Optional<Endereco> enderecoOpt = enderecoRepo.findById(new Long(id));
        Endereco end = enderecoOpt.get();
        
        id = recuperaParametro("idCli");
        
        Optional<Cliente> clienteOpt = clienteRepo.findById(new Long(id));
        cliente = clienteOpt.get();
        cliente.getEnderecos().remove(end);
        
        clienteRepo.save(cliente);
               
        return "ConsultaClientes?faces-redirect=true";
    }
    
    public String preparaCadastro() {
        
        endereco = new Endereco();
        
        String id = recuperaParametro("idCli");
        
        Optional<Cliente> clienteOpt = clienteRepo.findById(new Long(id));
        cliente = clienteOpt.get();
        
        return "CadastroEndereco?faces-redirect=true";
    }
    
    private String recuperaParametro(String param) {
        
        FacesContext context = FacesContext.getCurrentInstance();
        Map requestMap = context.getExternalContext().getRequestParameterMap();
        String parametro = (String)requestMap.get(param);
        
        return parametro;
    }

    public EnderecoRepo getEnderecoRepo() {
        return enderecoRepo;
    }

    public void setEnderecoRepo(EnderecoRepo enderecoRepo) {
        this.enderecoRepo = enderecoRepo;
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