package br.edu.infnet.av2.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import org.springframework.security.core.GrantedAuthority;

@Entity
public class Papel implements GrantedAuthority {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nomePapel;

    public Papel(){
        
    }

    public Papel(String nomePapel) {
        this.nomePapel = nomePapel;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNomePapel() {
        return nomePapel;
    }

    public void setNomePapel(String nomePapel) {
        this.nomePapel = nomePapel;
    }

    @Override
    public String getAuthority() {
        
        return this.nomePapel;
    }
}