package com.engefoto.model;

import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Avaliador {

    @Id
    private String nome;

    @Column(nullable = false)
    private boolean isAdmin;

    @Column(nullable = true)
    private double producao;

    public Avaliador() {}


    public Avaliador(String nome, boolean isAdmin) {
        this.nome = nome;
        this.isAdmin = isAdmin;
    }


    public String getNome() {
        return nome;
    }


    public boolean isAdmin() {
        return isAdmin;
    }

    public double getProducao() {
        return producao;
    }


    @Override
    public int hashCode() {
        return Objects.hashCode(nome);
    }


    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null || (getClass() != obj.getClass()))
            return false;
        Avaliador other = (Avaliador) obj;
        return Objects.equals(nome, other.nome);
    }

}
