package Diana_Friptuleac.dao;

import Diana_Friptuleac.classi.PartitaCalcio;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;

public class PartitaCalcioDAO {
    private final EntityManager entityManager;

    public PartitaCalcioDAO(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    // Metodo salva
    public void save(PartitaCalcio partitaCalcio) {
        EntityTransaction transaction = entityManager.getTransaction();
        transaction.begin();
        entityManager.persist(partitaCalcio);
        transaction.commit();
        System.out.println("Partita salvata: " + partitaCalcio.getSquadraCasa() + " vs " + partitaCalcio.getSquadraOspite());
    }

    // Metodo trova per ID
    public PartitaCalcio findById(Long id) {
        return entityManager.find(PartitaCalcio.class, id);
    }

    // Metodo elimina
    public void delete(Long id) {
        PartitaCalcio partitaCalcio = findById(id);
        if (partitaCalcio != null) {
            EntityTransaction transaction = entityManager.getTransaction();
            transaction.begin();
            entityManager.remove(partitaCalcio);
            transaction.commit();
            System.out.println("Partita eliminata: " + partitaCalcio.getSquadraCasa() + " vs " + partitaCalcio.getSquadraOspite());
        }
    }
}
