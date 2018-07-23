package br.edu.infnet.av2.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import org.hibernate.annotations.LazyCollection;
import org.hibernate.annotations.LazyCollectionOption;
import org.hibernate.validator.constraints.NotEmpty;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

@Entity
public class Funcionario extends Pessoa implements UserDetails, Serializable {
    
    private static final long serialVersionUID = 1L;
    
    private int registro;
    @Column(unique = true)
    private String login;
    @NotEmpty
    private String senha;
    
    @ManyToMany(cascade = {CascadeType.PERSIST})
    @LazyCollection(LazyCollectionOption.FALSE)
    @JoinTable(
            name = "funcionarios_papeis",
            joinColumns = {
                @JoinColumn(name = "funcionario_id")},
            inverseJoinColumns = {
                @JoinColumn(name = "papel_id")}
    )
    private List<Papel> papeis = new ArrayList<>();

    public Funcionario() {
    }

    public Funcionario(int registro, String login, String senha, String nome) {
        super(nome);
        this.registro = registro;
        this.login = login;
        this.senha = senha;
    }
    
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

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public List<Papel> getPapeis() {
        return papeis;
    }

    public void setPapeis(List<Papel> papeis) {
        this.papeis = papeis;
    }
    
    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        // TODO Auto-generated method stub
        return this.papeis;
    }
    
    @Override
    public String getPassword() {
        return this.senha;
    }

    @Override
    public String getUsername() {
        return this.login;
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }
}