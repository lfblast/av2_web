package br.edu.infnet.av2.model;

import javax.persistence.Entity;

@Entity
public class Motoboy extends Funcionario {

    private String placaMoto;

    public String getPlacaMoto() {
        return placaMoto;
    }

    public void setPlacaMoto(String placaMoto) {
        this.placaMoto = placaMoto;
    }
}