package Diana_Friptuleac.dao;

import Diana_Friptuleac.classi.GaraDiAtletica;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;

public class GaraDiAtleticaDAO {
    private final EntityManager entityManager;

    public GaraDiAtleticaDAO(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    // Metodo per salvare
    public void save(GaraDiAtletica garaAtletica) {
        EntityTransaction transaction = entityManager.getTransaction();
        transaction.begin();
        entityManager.persist(garaAtletica);
        transaction.commit();
        System.out.println("La gara di attletica " + garaAtletica.getTitolo() + " è stata salvata con successo!");
    }
}
