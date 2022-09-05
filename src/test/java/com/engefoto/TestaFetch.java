package com.engefoto;

import java.util.logging.Level;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class TestaFetch {
    static {java.util.logging.Logger.getLogger("org.hibernate").setLevel(Level.SEVERE);} static EntityManagerFactory emf = Persistence.createEntityManagerFactory("Controle LVC"); static EntityManager em = emf.createEntityManager(); 

    public static void main(String[] args) {

        // em.getTransaction().begin();
        // em.find(entityClass, primaryKey)
        


        
    }
    
}
