package com.engefoto.model;

import java.io.Serializable;
import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Embeddable;

@Embeddable
public class TrechoProblemaID implements Serializable {

    @Column(name = "id_trecho")
    private int problemaid;

    @Column(name = "id_problema")
    private int trechoid;
    
    public TrechoProblemaID() {
    }

    public TrechoProblemaID(int trecho, int problema) {
        this.trechoid = trecho;
        this.problemaid = problema;
    }


    public int getProblema() {
        return this.problemaid;
    }

    public int getTrecho() {
        return this.trechoid;
    }

    @Override
    public int hashCode() {
        return Objects.hash(trechoid, problemaid);
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null || getClass() != obj.getClass())
            return false;
        TrechoProblemaID other = (TrechoProblemaID) obj;
        if (!(problemaid == other.problemaid))
            return false;
        if (!(trechoid == other.trechoid))
            return false;
        return true;
    }

    
}