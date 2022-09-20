package com.engefoto;

import java.util.logging.Level;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import com.engefoto.model.Trecho;

public class TestaUpdateOutraThread {
    static {java.util.logging.Logger.getLogger("org.hibernate").setLevel(Level.SEVERE);} static EntityManagerFactory emf = Persistence.createEntityManagerFactory("Controle LVC"); static EntityManager em = emf.createEntityManager(); 

    public static void main(String[] args) throws InterruptedException {

        Trecho t = em.find(Trecho.class, 1);
        em.getTransaction().begin();
        t.setEnderecoPasta("!!");
        em.getTransaction().commit();
        System.out.println("Codigo antes da Thread: " + t.getEnderecoPasta());
        
        Thread thread = new Thread(() -> {
            try {Thread.sleep(1000);} catch (InterruptedException e) {}
            System.out.println("Inicializando nova thread");
            EntityManager entityManager = emf.createEntityManager();
            Trecho trecho = entityManager.find(Trecho.class, 1);
            entityManager.getTransaction().begin();
            trecho.setEnderecoPasta("Texto alterado pela Thread");
            entityManager.getTransaction().commit();
            System.out.println("Texto alterado pela Thread");
        });
        thread.start();
        thread.join();

        em.refresh(t);
        System.out.println("Codigo depois da Thread: " + t.getEnderecoPasta());

    }
    
}
