package com.engefoto.model;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;

@Entity
public class Producao implements Serializable {


    @Id
    @OneToOne
    @JoinColumn(name = "id_trecho")
    private Trecho trecho;

    private boolean aptidao = false;

    @ManyToOne(fetch=FetchType.LAZY)
    @JoinColumn(name = "avaliador_pavimento", nullable = true)
    private Avaliador avaliadorPavimento;

    @ManyToOne(fetch=FetchType.LAZY)
    @JoinColumn(name = "avaliador_sinalizacao", nullable = true)
    private Avaliador avaliadorSinalizacao;
    
    @ManyToOne(fetch=FetchType.LAZY)
    @JoinColumn(name = "avaliador_acostamento", nullable = true)
    private Avaliador avaliadorAcostamento;

    @Column(name = "data_pavimento")
    private LocalDate dataPavimento;

    @Column(name = "data_sinalizacao")
    private LocalDate dataSinalizacao;

    @Column(name = "data_acostamento")
    private LocalDate dataAcostamento;

    public Producao() {}

    public Producao(Trecho trecho) {
        this.trecho = trecho;
    }
    public boolean isAptidao() {
        return aptidao;
    }
    public void setAptidao(boolean aptidao) {
        this.aptidao = aptidao;
    }
    public Avaliador getAvaliadorPavimento() {
        return avaliadorPavimento;
    }
    public void setAvaliadorPavimento(Avaliador avaliadorPavimento) {
        this.avaliadorPavimento = avaliadorPavimento;
    }
    public Avaliador getAvaliadorSinalizacao() {
        return avaliadorSinalizacao;
    }
    public void setAvaliadorSinalizacao(Avaliador avaliadorSinalizacao) {
        this.avaliadorSinalizacao = avaliadorSinalizacao;
    }
    public Avaliador getAvaliadorAcostamento() {
        return avaliadorAcostamento;
    }
    public void setAvaliadorAcostamento(Avaliador avaliadorAcostamento) {
        this.avaliadorAcostamento = avaliadorAcostamento;
    }
    public LocalDate getDataPavimento() {
        return dataPavimento;
    }
    public void setDataPavimento(LocalDate dataPavimento) {
        this.dataPavimento = dataPavimento;
    }
    public LocalDate getDataSinalizacao() {
        return dataSinalizacao;
    }
    public void setDataSinalizacao(LocalDate dataSinalizacao) {
        this.dataSinalizacao = dataSinalizacao;
    }
    public LocalDate getDataAcostamento() {
        return dataAcostamento;
    }
    public void setDataAcostamento(LocalDate dataAcostamento) {
        this.dataAcostamento = dataAcostamento;
    }

    @Override
    public int hashCode() {
        return Objects.hash(trecho);
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null || getClass() != obj.getClass())
            return false;
        Producao other = (Producao) obj;
        if (!trecho.equals(other.trecho))
            return false;
        return true;
    }

}
