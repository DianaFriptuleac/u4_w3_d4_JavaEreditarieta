package Diana_Friptuleac.dao;

import Diana_Friptuleac.classi.Concerto;
import Diana_Friptuleac.classi.Evento;
import Diana_Friptuleac.classi.GenereConcerto;
import Diana_Friptuleac.classi.PartitaCalcio;
import Diana_Friptuleac.exceptions.NotFoundException;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.Query;

import java.util.List;

public class EventoDAO {
    private final EntityManager entityManager;

    //l'oggetto
    public EventoDAO(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    //Metodo save
    public void save(Evento newEvento) {
        EntityTransaction transaction = entityManager.getTransaction();  //nuova transizione
        transaction.begin();  //faccio partire la transition
        entityManager.persist(newEvento);  //agg. nuovo evento ma non e ancora nel DB.
        transaction.commit();  //chiudo transizione e mando l'elevto al DB
        System.out.println("L'evento " + newEvento.getTitolo() + " è stato aggiunto con successo!");

    }


    // Metodo per trovare un evento per ID
    public Evento findById(Long id) {
        Evento found = entityManager.find(Evento.class, id);
        if (found == null) {
            throw new NotFoundException("Evento con ID " + id + " non trovata.");
        }
        return found;
    }

    //Metodo delete
    public void delete(long eventoId) {
        Evento foundEvent = this.findById(eventoId);
        EntityTransaction transaction = entityManager.getTransaction();  //nuova transazione creata da Entity Manager
        transaction.begin();
        entityManager.remove(foundEvent);
        transaction.commit();
        System.out.println("L'evento " + foundEvent.getTitolo() + " è stato rimosso con successo!");
    }

    //Metodo getConcertiInStreaming
    public List<Concerto> getConcertiInStreaming(boolean inStreaming) {
        Query query = entityManager.createQuery("SELECT c FROM Concerto c WHERE c.inStreaming = :inStreaming");
        query.setParameter("inStreaming", inStreaming);
        return query.getResultList();
    }

    //Metodo getConcertiPerGenere
    public List<Concerto> getConcertiPerGenere(GenereConcerto genere) {
        Query query = entityManager.createQuery("SELECT c FROM Concerto c WHERE c.genere = :genere");
        query.setParameter("genere", genere);
        return query.getResultList();
    }

    // Metodo getPartiteVintelnCasa
    public List<PartitaCalcio> getPartiteVintelnCasa() {
        Query query = entityManager.createNamedQuery("PartitaCalcio.getPartiteVintelnCasa");
        return query.getResultList();
    }

    // Metodo getPartiteVintelnTrasferta
    public List<PartitaCalcio> getPartiteVintelnTrasferta() {
        Query query = entityManager.createNamedQuery("PartitaCalcio.getPartiteVintelnTrasferta");
        return query.getResultList();
    }

}
