package com.engefoto.model;

import java.time.LocalDate;
import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.ForeignKey;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.MapsId;
import javax.persistence.Table;

import com.engefoto.model.validation.Data;

@Entity
@Table(name = "trecho_problema")
public class TrechoProblema {

    @EmbeddedId
    private TrechoProblemaID id;

    @ManyToOne(fetch = FetchType.LAZY)
    @MapsId("problemaid")
    @JoinColumn(name = "id_problema", nullable = false, foreignKey = @ForeignKey(name = "FK_ID_PROBLEMA"))
    private Problema problema;

    @ManyToOne(fetch = FetchType.LAZY)
    @MapsId("trechoid")
    @JoinColumn(name = "id_trecho", nullable = false, foreignKey = @ForeignKey(name = "FK_ID_TRECHO"))
    private Trecho trecho;


    @Column(nullable = false)
    private LocalDate data;

    public TrechoProblema() {}

    public TrechoProblema(Trecho trecho, Problema problema, String data) {
        this.trecho = trecho;
        this.problema = problema;
        this.data = Data.convertToDate(data);
        this.id = new TrechoProblemaID(trecho.getId(), problema.getId());
    }

    public Problema getProblema() {
        return problema;
    }

    public Trecho getTrecho() {
        return trecho;
    }

    
    public TrechoProblemaID getId() {
        return id;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

    
    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null || getClass() != obj.getClass())
            return false;
        TrechoProblema other = (TrechoProblema) obj;
        if (!id.equals(other.id))
            return false;
        return true;
    }

    public void setData(LocalDate data) {
        this.data = data;
    }

    
    
}
