package br.edu.infnet.av2.model;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="categoria")
public class Categoria implements Serializable {

    private static final long serialVersionUID = 1L;
    
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    @Column(name="categoria_id", nullable=false, unique=true, length=11)
    private long id;
    
    @Column(name="nome", nullable=false)
    private String nome;

    public Categoria() {
    }

    public Categoria(String nome) {
        this.nome = nome;
    }

    public static long getSerialVersionUID() {
        return serialVersionUID;
    }
    
    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }
    
    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }
}