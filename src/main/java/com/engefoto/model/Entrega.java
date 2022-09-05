package com.engefoto.model;

import java.time.LocalDate;
import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.ForeignKey;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import com.engefoto.model.validation.Data;
import com.engefoto.model.validation.HD;
import com.engefoto.model.validation.StatusEntrega;

@Entity
public class Entrega {

    @Id
    private int hd;

    @ManyToOne(fetch=FetchType.LAZY)
    @JoinColumn(name="lote", nullable=false, foreignKey=@ForeignKey(name="FK_EMPRESA_ENTREGA"))
    private Empresa lote;

    @Column(name="data_recebimento", nullable=false)
    private LocalDate dataRecebimento;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private StatusEntrega status;

    public Entrega() {}

    public Entrega(Empresa empresa, int hd, String data, StatusEntrega status) {
        this.hd = HD.validate(hd);
        this.dataRecebimento = Data.convertToDate(data);
        this.lote = empresa;
        this.status = status;
    }

    public int getHd() {
        return hd;
    }

    public Empresa getLote() {
        return lote;
    }

    public LocalDate getDataRecebimento() {
        return dataRecebimento;
    }

    public StatusEntrega getStatus() {
        return status;
    }

    @Override
    public int hashCode() {
        return Objects.hash(hd);
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null || getClass() != obj.getClass())
            return false;
        Entrega other = (Entrega) obj;
        return Objects.equals(hd, other.hd);
    }

    
}
