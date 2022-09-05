package com.engefoto.model;

import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Problema {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_problema")
    private int id;

    @Column(length = 1000, unique = true, nullable = false)
    private String problema;

    public Problema() {}

    public Problema (String problema) {
        this.problema = problema;
    }

    public int getId() {
        return id;
    }

    public String getProblema() {
        return problema;
    }

    @Override
    public int hashCode() {
        return Objects.hash(problema.toLowerCase());
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null || getClass() != obj.getClass())
            return false;
        Problema other = (Problema) obj;
        if (!problema.equalsIgnoreCase(other.problema))
            return false;
        return true;
    }
}
