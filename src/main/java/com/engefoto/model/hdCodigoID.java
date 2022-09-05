package com.engefoto.model;

import java.io.Serializable;
import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.persistence.FetchType;
import javax.persistence.ForeignKey;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Embeddable
public class hdCodigoID implements Serializable {

    @ManyToOne(fetch=FetchType.LAZY)
    @JoinColumn(name="hd", nullable = false, foreignKey = @ForeignKey(name="FK_ENTREGA_TRECHO"))
    private Entrega hd;

    @Column(name = "codigo_hd", nullable = false)
    private int codigo;

    public hdCodigoID() {
    }


    public hdCodigoID(Entrega hd, int codigo) {
        this.hd = hd;
        this.codigo = codigo;
    }

    public int getHD() {
        return hd.getHd();
    }

    public int getCodigo() {
        return codigo;
    }


    @Override
    public int hashCode() {
        return Objects.hash(hd, codigo);
    }


    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null || (getClass() != obj.getClass()))
            return false;
        hdCodigoID other = (hdCodigoID) obj;
        if (codigo != other.codigo)
            return false;
        if (!hd.equals(other.hd))
            return false;
        return true;
    }

    
    
}
