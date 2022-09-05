package com.engefoto.model;

import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Empresa {

    @Id
    @Column(columnDefinition = "TINYINT")
    private int lote;
    
    @Column(length = 150, unique = true, nullable = false)
    private String nome;

    @Column(length = 255, unique = true, nullable = false)
    private String email;

    @Column(length = 150, unique = true, nullable = false)
    private String responsavel;

    public Empresa() {}
    
    public Empresa(int lote, String nome, String email, String responsavel) {
        this.lote = lote;
        this.nome = nome;
        this.email = email;
        this.responsavel = responsavel;
    }

    public int getLote() {
        return lote;
    }

    public String getNome() {
        return nome;
    }

    public String getEmail() {
        return email;
    }

    public String getResponsavel() {
        return responsavel;
    }

    @Override
    public int hashCode() {
        return Objects.hash(lote);
    }


    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null || getClass() != obj.getClass())
            return false;
        Empresa other = (Empresa) obj;
        if (this.lote == other.lote)
            return true;
        if (this.nome.equalsIgnoreCase(other.nome))
            return true;
        return false;
    }

}
