package br.edu.infnet.av2.model;

import java.io.Serializable;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import org.hibernate.annotations.LazyCollection;
import org.hibernate.annotations.LazyCollectionOption;

@Entity
@Table(name = "cliente")
public class Cliente extends Pessoa implements Serializable {
    
    private static final long serialVersionUID = 1L;
    
    @OneToMany(mappedBy="cliente", cascade=CascadeType.ALL, orphanRemoval = true)
    @LazyCollection(LazyCollectionOption.FALSE)
    private List<Endereco> enderecos;
    
    @Column(name="telefone")
    private int telefone;

    public Cliente() {
    }

    public Cliente(List<Endereco> enderecos, int telefone) {
        this.enderecos = enderecos;
        this.telefone = telefone;
    }

    public List<Endereco> getEnderecos() {
        return enderecos;
    }

    public void setEnderecos(List<Endereco> enderecos) {
        this.enderecos = enderecos;
    }

    public int getTelefone() {
        return telefone;
    }

    public void setTelefone(int telefone) {
        this.telefone = telefone;
    }
}