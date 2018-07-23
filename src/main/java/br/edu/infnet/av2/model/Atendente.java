package br.edu.infnet.av2.model;

import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "atendente")
public class Atendente extends Funcionario implements Serializable {
    
    private static final long serialVersionUID = 1L;
    
    private int ramal;

    public Atendente() {
    }

    public Atendente(int ramal) {
        this.ramal = ramal;
    }

    public Atendente(int ramal, int registro, String login, String senha, String nome) {
        super(registro, login, senha, nome);
        this.ramal = ramal;
    }

    public int getRamal() {
        return ramal;
    }

    public void setRamal(int ramal) {
        this.ramal = ramal;
    }
}