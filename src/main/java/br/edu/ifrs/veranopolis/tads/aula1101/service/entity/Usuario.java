package br.edu.ifrs.veranopolis.tads.aula1101.service.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

import java.util.Objects;
@Entity
public class Usuario {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String usuario;
    private String senha;
    private String[] papeis = {"ADMIN", "USUARIO"};

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public String[] getPapeis() {
        return papeis;
    }

    public void setPapeis(String[] papeis) {
        this.papeis = papeis;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Usuario usuario)) return false;
        return id == usuario.id;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}
