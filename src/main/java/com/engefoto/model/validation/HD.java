
package com.engefoto.model.validation;

public class HD {

    private int hd;
    private int ciclo;
    private int lote;
    private int numEntrega;

    public HD(int hd) {
        validate(hd);
        this.hd = hd;
        this.ciclo = hd/1000;
        this.lote = (hd%1000)/100;
        this.numEntrega = hd%100;
    }

    public int getHd() {
        return hd;
    }

    public int getCiclo() {
        return ciclo;
    }

    public int getLote() {
        return lote;
    }

    public int getNumEntrega() {
        return numEntrega;
    }

    public static int validate(int hd) {
        if (hd < 1000 || hd > 4999)
            throw new RuntimeException("Numero errado para o hd " + hd);
        return hd;
    }
}
