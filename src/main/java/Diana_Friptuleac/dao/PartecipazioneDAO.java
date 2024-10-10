package Diana_Friptuleac.dao;

import Diana_Friptuleac.classi.Partecipazioni;
import Diana_Friptuleac.exceptions.NotFoundException;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;

public class PartecipazioneDAO {
    private final EntityManager em;

    public PartecipazioneDAO(EntityManager em) {
        this.em = em;
    }

    public void save(Partecipazioni partecipazione) {
        EntityTransaction transaction = em.getTransaction();
        transaction.begin();
        em.persist(partecipazione);
        transaction.commit();
        System.out.println("La partecipazione " + partecipazione.getPartecipante() + " è stata salvata");
    }

    // Metodo per trovare una partecipazione per ID
    public Partecipazioni findById(Long partecipazioneId) {
        Partecipazioni found = em.find(Partecipazioni.class, partecipazioneId);
        if (found == null) {
            throw new NotFoundException("Partecipazione con ID " + partecipazioneId + " non trovata.");
        }
        return found;
    }
}
