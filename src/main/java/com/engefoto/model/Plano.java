package com.engefoto.model;

import java.time.LocalDate;
import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.ForeignKey;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.engefoto.model.validation.Data;
import com.engefoto.model.validation.SNV;
import com.engefoto.model.validation.UF;


@Entity
@Table(name = "plano_logistico")
public class Plano {

    @Id
    @Column(length = 10)
    private String snv;

    @ManyToOne(fetch=FetchType.LAZY)
    @JoinColumn(name="lote", nullable=false, foreignKey=@ForeignKey(name="FK_EMPRESA_PLANO"))
    private Empresa lote;

    @Column(nullable = false)
    private int br;

    @Column(length = 2, nullable = false)
    private String uf;

    @Column(name = "km_inicio", nullable = false)
    private Float kmInicio;
    
    @Column(name = "km_final", nullable = false)
    private Float kmFinal;
    
    @Column(name = "data_prevista", nullable = false)
    private LocalDate dataPrevista;
    
    @Column(name = "data_levantada", nullable = true)
    private LocalDate dataLevantada;

    @Column(name = "data_entrega", nullable = true)
    private LocalDate dataEntrega;

    public Plano() {}

    public Plano(Empresa lote, String snv, int br, String uf, Double kmInicio, Double kmFinal, 
            String dataPrevista, String dataLevantada, String dataEntrega) {
        this.lote = lote;
        this.snv = SNV.validate(snv);
        this.uf = UF.validate(uf);
        this.br = br;
        this.kmInicio = kmInicio.floatValue();
        this.kmFinal = kmFinal.floatValue();
        this.dataPrevista = Data.convertToDate(dataPrevista);
        this.dataLevantada = Data.convertToDate(dataLevantada);
        this.dataEntrega = Data.convertToDate(dataEntrega);
    }


    public Empresa getLote() {
        return lote;
    }

    public String getSnv() {
        return snv;
    }


    public int getBr() {
        return br;
    }


    public String getUf() {
        return uf;
    }

    public Float getKmInicio() {
        return kmInicio;
    }

    public Float getKmFinal() {
        return kmFinal;
    }


    public LocalDate getDataPrevista() {
        return dataPrevista;
    }


    public LocalDate getDataLevantada() {
        return dataLevantada;
    }

    public LocalDate getDataEntrega() {
        return dataEntrega;
    }

    @Override
    public int hashCode() {
        return Objects.hash(snv);
    }


    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null || getClass() != obj.getClass())
            return false;
        Plano other = (Plano) obj;
        if (!snv.equals(other.snv))
            return false;
        return true;
    }

    
}
