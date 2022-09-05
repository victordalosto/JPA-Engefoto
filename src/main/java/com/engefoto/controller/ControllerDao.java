package com.engefoto.controller;

import java.util.logging.Level;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

import com.engefoto.model.Avaliador;
import com.engefoto.model.Empresa;
import com.engefoto.model.Entrega;
import com.engefoto.model.EntregaTrecho;
import com.engefoto.model.Plano;
import com.engefoto.model.Problema;
import com.engefoto.model.Trecho;


public class ControllerDao {

    private final EntityManagerFactory emf;
    private final EntityManager em;


    public ControllerDao() {
        java.util.logging.Logger.getLogger("org.hibernate").setLevel(Level.SEVERE);
        emf = Persistence.createEntityManagerFactory("Controle LVC");
		em = emf.createEntityManager();
    }

    public void begin() {
        em.getTransaction().begin();
    }

    public void commit() {
        em.getTransaction().commit();
    }
    public <T> void persist(T t) {
        em.persist(t);
    }

    public <T> void merge(T t) {
        em.merge(t);
    }

    public <T> void remove(T t) {
        t = em.merge(t);
        em.remove(t);
    }

    public void close() {
        em.getTransaction().rollback();
        em.close();
        emf.close();
    }


    public Empresa findEmpresa(int id) {
        Empresa e = em.find(Empresa.class, id);
        return e;
    }


    public Empresa findEmpresa(String nome) {
        String jpql = "SELECT e FROM Empresa e WHERE nome = :nomeEmpresa";
        Query q = em.createQuery(jpql);
        q.setParameter("nomeEmpresa", nome);
        Empresa e = (Empresa) q.getSingleResult();
        return e;
    }


    public Entrega findHD(int HD) {
        Entrega e = em.find(Entrega.class, HD);
        return e;
    }


    public Plano findSNV(String snv) {
        Plano p = em.find(Plano.class, snv);
        return p;
    }

    public EntregaTrecho findEntregaTrecho(int HD, int codigo_HD) {
        String jpql = "SELECT e FROM EntregaTrecho e WHERE codigo_hd = :num_trecho AND HD = :num_HD";
        Query q = em.createQuery(jpql);
        q.setParameter("num_trecho", codigo_HD);
        q.setParameter("num_HD", HD);
        EntregaTrecho e = (EntregaTrecho) q.getSingleResult();
        return e;
    }

    public Trecho findTrecho(int id) {
        Trecho t = em.find(Trecho.class, id);
        return t;
    }

    public Problema findProblema(int id) {
        Problema p = em.find(Problema.class, id);
        return p;
    }

    public Avaliador findAvaliador(String nome) {
        Avaliador a = em.find(Avaliador.class, nome);
        return a;
    }

}
