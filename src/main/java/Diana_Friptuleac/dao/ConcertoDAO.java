package Diana_Friptuleac.dao;

import Diana_Friptuleac.classi.Concerto;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;

public class ConcertoDAO {
    private final EntityManager entityManager;

    public ConcertoDAO(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    // Metodo per salvare
    public void save(Concerto concerto) {
        EntityTransaction transaction = entityManager.getTransaction();
        transaction.begin();
        ;
        entityManager.persist(concerto);
        transaction.commit();
        System.out.println("Il concerto " + concerto.getTitolo() + " è stata salvata con successo!");
    }
}