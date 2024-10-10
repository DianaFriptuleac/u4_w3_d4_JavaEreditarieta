package Diana_Friptuleac.dao;

import Diana_Friptuleac.classi.Location;
import Diana_Friptuleac.exceptions.NotFoundException;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;

public class LocationDAO {
    private final EntityManager em;


    public LocationDAO(EntityManager em) {
        this.em = em;
    }

    public void save(Location location) {
        EntityTransaction transaction = em.getTransaction();
        transaction.begin();
        em.persist(location);
        transaction.commit();
        System.out.println("La location " + location.getNome_location() + " è statta salvata con successo!");
    }

    // Metodo per trovare una location per ID
    public Location findById(Long id) {
        Location found = em.find(Location.class, id);
        if (found == null) {
            throw new NotFoundException("Location con ID " + id + " non trovata.");
        }
        return found;
    }

}
