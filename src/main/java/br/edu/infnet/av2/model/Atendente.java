package br.edu.infnet.av2.model;

import javax.persistence.Entity;

@Entity
public class Atendente extends Funcionario implements Autenticavel {
    
    private int remal;

    public int getRemal() {
        return remal;
    }

    public void setRemal(int remal) {
        this.remal = remal;
    }
}