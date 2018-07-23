package br.edu.infnet.av2.model;

import java.io.Serializable;
import javax.persistence.Entity;

@Entity
public class Gerente extends Funcionario implements Serializable {
    
    private static final long serialVersionUID = 1L;

    public Gerente() {
    }
    
    public Gerente(int registro, String login, String senha, String nome) {
        super(registro, login, senha, nome);
    }
}