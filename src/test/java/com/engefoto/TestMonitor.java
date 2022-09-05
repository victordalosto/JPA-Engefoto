package com.engefoto;

import java.util.logging.Level;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import com.engefoto.model.Trecho;

public class TestMonitor {
    static {java.util.logging.Logger.getLogger("org.hibernate").setLevel(Level.SEVERE);} static EntityManagerFactory emf = Persistence.createEntityManagerFactory("Controle LVC"); static EntityManager em = emf.createEntityManager(); 
    public static void main(String[] args) throws InterruptedException {

        em.getTransaction().begin();
        
        System.out.println("\n\n Realizando busca:");
        Trecho trecho = em.merge(em.find(Trecho.class, 1));
        System.out.println("Valor do codigo sistlev: " + trecho.getCodigoSistlev());
        
        Thread.sleep(15000);
        // em.getTransaction().rollback();
        // em.getTransaction().begin();
        em.clear();
        trecho = em.merge(em.find(Trecho.class, 1));
        em.refresh(trecho);
        System.out.println("Valor do codigo sistlev: " + trecho.getCodigoSistlev());

        System.out.println("\nAlterando enderecoPasta");
        trecho.setEnderecoPasta("Voltando...");
        em.persist(trecho);

        System.out.println("Valor do codigo sistlev: " + trecho.getCodigoSistlev());
        em.getTransaction().commit();

    }
    
}
