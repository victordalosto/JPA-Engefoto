package com.engefoto;

import java.util.logging.Level;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import com.engefoto.model.Trecho;

public class TestaOutroContexto {
    static {java.util.logging.Logger.getLogger("org.hibernate").setLevel(Level.SEVERE);} static EntityManagerFactory emf = Persistence.createEntityManagerFactory("Controle LVC"); static EntityManager em = emf.createEntityManager(); 

    public static void main(String[] args) throws InterruptedException {
        em.getTransaction().begin();
        
        Trecho t = em.find(Trecho.class, 1);

        System.out.println("Codigo antes da Thread: " + t.getEnderecoPasta());
        Thread.sleep(10000);
        
        em.refresh(t);
        System.out.println("Codigo depois da Thread: " + t.getEnderecoPasta());

    }
    
}
