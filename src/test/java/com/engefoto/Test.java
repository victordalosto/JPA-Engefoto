package com.engefoto;

import java.util.Set;
import java.util.logging.Level;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import com.engefoto.model.Trecho;
import com.engefoto.model.TrechoProblema;

public class Test {
    static {java.util.logging.Logger.getLogger("org.hibernate").setLevel(Level.SEVERE);} static EntityManagerFactory emf = Persistence.createEntityManagerFactory("Controle LVC"); static EntityManager em = emf.createEntityManager(); 

    public static void main(String[] args) {

        System.out.println("\n\n Indo procurar trecho");
        // Trecho trecho = controller.findTrecho(1);
        Trecho trecho = em.createQuery("SELECT t FROM Trecho t JOIN FETCH t.listTrechoProblema tp " +
                                       "JOIN FETCH tp.problema WHERE t.id = :numID", Trecho.class)
                          .setParameter("numID", 1).getSingleResult();
        
        System.out.println("Encontrei trecho");
        System.out.println("Código Sistlev: " + trecho.getCodigoSistlev());
        Set<TrechoProblema> lista = trecho.getTrechosProblemas();
        System.out.println("Pegando lista dos trechos");
        lista.forEach(tp -> {
            System.out.println(tp.getTrecho().getCodigoSistlev() + " - " + tp.getProblema().getProblema());
        });




    }

}
