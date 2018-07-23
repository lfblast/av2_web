package br.edu.infnet.av2.model;

import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "motoboy")
public class Motoboy extends Funcionario implements Serializable {

    private static final long serialVersionUID = 1L;
    
    private String placaMoto;

    public Motoboy() {
    }
    
    public Motoboy(String placaMoto, int registro, String login, String senha, String nome) {
        super(registro, login, senha, nome);
        this.placaMoto = placaMoto;
    }

    public Motoboy(String placaMoto) {
        this.placaMoto = placaMoto;
    }

    public String getPlacaMoto() {
        return placaMoto;
    }

    public void setPlacaMoto(String placaMoto) {
        this.placaMoto = placaMoto;
    }
}