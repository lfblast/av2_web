package br.edu.infnet.av2.model;

import javax.persistence.Entity;

@Entity
public class Funcionario extends Pessoa {
    
    private int registro;
    private String login;
    private char[] senha;

    public int getRegistro() {
        return registro;
    }

    public void setRegistro(int registro) {
        this.registro = registro;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public char[] getSenha() {
        return senha;
    }

    public void setSenha(char[] senha) {
        this.senha = senha;
    }
}