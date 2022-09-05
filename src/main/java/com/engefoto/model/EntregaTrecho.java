package com.engefoto.model;

import java.time.LocalDate;
import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Index;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

import com.engefoto.model.validation.Data;

@Entity
@Table(name = "entrega_trecho", 
       indexes = {@Index(name="index_codigo_hd", columnList = "codigo_hd")},
       uniqueConstraints = {@UniqueConstraint(columnNames = {"codigo_hd", "hd"})})
public class EntregaTrecho {

    @Embedded
    private hdCodigoID hdCodigoID;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id_entrega", nullable = false)
    private int id;

    @Column(name = "id_trecho_apto", nullable = true)
    private int idTrechoApto;

    @Column(name = "numero_revisoes", nullable = false)
    private int numeroRevisoes;

    @Column(name = "data_correcao", nullable = true)
    private LocalDate dataCorrecao;

    public EntregaTrecho() {}

    public EntregaTrecho(Entrega hd, int codigo) {
        this(hd, codigo, 0, 0, null);
    }

    public EntregaTrecho(Entrega HD, int codigo, int idTrechoApto, int numeroRevisoes, String dataCorrecao) {
        this.hdCodigoID = new hdCodigoID(HD, codigo);
        this.idTrechoApto = idTrechoApto;
        this.numeroRevisoes = numeroRevisoes;
        this.dataCorrecao = Data.convertToDate(dataCorrecao);
    }

    public int getId() {
        return id;
    }

    public int getHD() {
        return hdCodigoID.getHD();
    }

    public int getCodigo() {
        return hdCodigoID.getCodigo();
    }

    public int getIdTrechoApto() {
        return idTrechoApto;
    }

    public int getNumeroRevisoes() {
        return numeroRevisoes;
    }

    public LocalDate getDataCorrecao() {
        return dataCorrecao;
    }

    @Override
    public int hashCode() {
        return Objects.hash(hdCodigoID, id);
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null ||getClass() != obj.getClass())
            return false;
        EntregaTrecho other = (EntregaTrecho) obj;
        if (!hdCodigoID.equals(other.hdCodigoID))
            return false;
        if (id != other.id)
            return false;
        return true;
    }

    

    


}
