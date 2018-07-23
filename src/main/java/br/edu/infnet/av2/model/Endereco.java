package br.edu.infnet.av2.model;

import java.io.Serializable;
import javax.persistence.Cacheable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="endereco")
@Cacheable(false)
public class Endereco implements Serializable {
    
    private static final long serialVersionUID = 1L;
    
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    @Column(name="endereco_id", nullable=false, unique=true, length=11)
    private long id;
    
    @Column(name="rua", nullable=false)
    private String rua;
    
    @Column(name="numero", nullable=false)
    private int numero;
    
    @Column(name="referencia")
    private String referencia;
    
    @ManyToOne
    @JoinColumn(name="cliente_id", nullable=false)
    private Cliente cliente;

    public Endereco() {
    }

    public Endereco(String rua, int numero, String referencia, Cliente cliente) {
        this.rua = rua;
        this.numero = numero;
        this.referencia = referencia;
        this.cliente = cliente;
    }
    
    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getRua() {
        return rua;
    }

    public void setRua(String rua) {
        this.rua = rua;
    }

    public int getNumero() {
        return numero;
    }

    public void setNumero(int numero) {
        this.numero = numero;
    }

    public String getReferencia() {
        return referencia;
    }

    public void setReferencia(String referencia) {
        this.referencia = referencia;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }
}