package com.engefoto.model;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.ForeignKey;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OrderBy;
import javax.persistence.Table;


@Entity
@Table(name = "trecho")
public class Trecho {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_trecho")
    private int id;

    @ManyToOne(fetch=FetchType.LAZY)
    @JoinColumn(name="id_entrega", nullable = false, foreignKey = @ForeignKey(name="FK_ID_ENTREGA_TRECHO"))
    private EntregaTrecho entregaTrecho;

    @ManyToOne(fetch=FetchType.LAZY)
    @JoinColumn(name="snv", nullable = false, foreignKey = @ForeignKey(name="FK_SNV_PLANO"))
    private Plano snvPlano;

    @Column(name="codigo_sistlev", nullable = false)
    private int codigoSistlev;

    @Column(name="km_inicio_campo", nullable = false)
    private double kmInicio;

    @Column(name="km_final_campo", nullable = false)
    private double kmFinal;

    @Column(name="endereco_pasta", nullable = true, length = 500)
    private String enderecoPasta;
 
    @OneToMany(mappedBy = "trecho", cascade = CascadeType.ALL, orphanRemoval = true)
    @OrderBy("id")
    private Set<TrechoProblema> listTrechoProblema = new HashSet<>();

    public Trecho() {}

    public Trecho(EntregaTrecho id_entrega, Plano snv, int codigoSistlev, double kmInicio, double kmFinal) {
        this.entregaTrecho = id_entrega;
        this.snvPlano = snv;
        this.codigoSistlev = codigoSistlev;
        this.kmInicio = kmInicio;
        this.kmFinal = kmFinal;
    }

    public int getId() {
        return id;
    }

    public EntregaTrecho getEntregaTrecho() {
        return entregaTrecho;
    }

    public Plano getSnvPlano() {
        return snvPlano;
    }


    public void setEnderecoPasta(String t) {
        this.enderecoPasta = t;
    }

    public int getCodigoSistlev() {
        return codigoSistlev;
    }

    public double getKmInicio() {
        return kmInicio;
    }

    public double getKmFinal() {
        return kmFinal;
    }

    public String getEnderecoPasta() {
        return enderecoPasta;
    }

    public Set<TrechoProblema> getTrechosProblemas() {
        return listTrechoProblema;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + codigoSistlev;
        result = prime * result + ((enderecoPasta == null) ? 0 : enderecoPasta.hashCode());
        result = prime * result + id;
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        Trecho other = (Trecho) obj;
        if (codigoSistlev != other.codigoSistlev)
            return false;
        if (enderecoPasta == null) {
            if (other.enderecoPasta != null)
                return false;
        } else if (!enderecoPasta.equals(other.enderecoPasta))
            return false;
        if (id != other.id)
            return false;
        return true;
    }

    // @Override
    // public int hashCode() {
    //     return Objects.hash(id, codigoSistlev, enderecoPasta);
    // }

    
}
