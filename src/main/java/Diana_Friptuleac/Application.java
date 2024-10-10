package Diana_Friptuleac;

import Diana_Friptuleac.classi.*;
import Diana_Friptuleac.dao.EventoDAO;
import Diana_Friptuleac.dao.LocationDAO;
import Diana_Friptuleac.dao.PartecipazioneDAO;
import Diana_Friptuleac.dao.PersonaDAO;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

import java.time.LocalDate;

public class Application {
    private static final EntityManagerFactory emf = Persistence.createEntityManagerFactory("u4w3d4");

    public static void main(String[] args) {

        EntityManager em = emf.createEntityManager();
        // Creazione dei DAO
        EventoDAO eventDB = new EventoDAO(em);
        LocationDAO locationDAO = new LocationDAO(em);
        PersonaDAO personaDB = new PersonaDAO(em);
        PartecipazioneDAO partecipazioneDAO = new PartecipazioneDAO(em);

        // Salvo le location
        Location l1 = new Location("Parco Nazionale", "Roma");
        Location l2 = new Location("Parco del fiume", "Roma");
        Location l3 = new Location("Alpi Struttura", "Torino");

      /*  locationDAO.save(l1);
        locationDAO.save(l2);
        locationDAO.save(l3);

     */
        // Recupera la location salvata
        Location loc1 = locationDAO.findById(1L);  // L sta per long.
        Location loc2 = locationDAO.findById(2L);
        Location loc3 = locationDAO.findById(3L);

        // Salvo gli eventi
        Evento evento1 = new Evento("Panda", LocalDate.of(2024, 12, 10), "Salviamo i Panda!", EventoType.PUBBLICO, 200, loc1);
        Evento evento2 = new Evento("Foreste", LocalDate.of(2024, 11, 15), "Proteggiamo le foreste", EventoType.PUBBLICO, 300, loc2);
        Evento evento3 = new Evento("Mare", LocalDate.of(2025, 1, 20), "Ripuliamo il mare", EventoType.PRIVATO, 150, loc3);

      /*  eventDB.save(evento1);
        eventDB.save(evento2);
        eventDB.save(evento3);*/

        // Salvo le persone
        Persona pers1 = new Persona("Mario", "Rossi", "mario.rossi@gmail.com", LocalDate.of(1990, 5, 10), SessoPersona.M);
        Persona pers2 = new Persona("Anna", "Verdi", "anna.verdi@gmail.com", LocalDate.of(1985, 7, 23), SessoPersona.F);
        Persona pers3 = new Persona("Luca", "Bianchi", "luca.bianchi@gmail.com", LocalDate.of(1995, 12, 5), SessoPersona.M);

      /*  personaDB.save(pers1);
        personaDB.save(pers2);
        personaDB.save(pers3);*/


        // Recupero persone e eventi dal database
        Persona savedP1 = personaDB.findById(1L);
        Persona savedP2 = personaDB.findById(2L);
        Persona savedP3 = personaDB.findById(3L);

        Evento savedE1 = eventDB.findById(1L);
        Evento savedE2 = eventDB.findById(2L);
        Evento savedE3 = eventDB.findById(3L);

        // Salvo le partecipazioni
        Partecipazioni p1 = new Partecipazioni(StatoPartecipazione.CONFERMATA, savedP1, savedE1);
        Partecipazioni p2 = new Partecipazioni(StatoPartecipazione.DA_CONFERMARE, savedP2, savedE2);
        Partecipazioni p3 = new Partecipazioni(StatoPartecipazione.CONFERMATA, savedP3, savedE3);

      /*  partecipazioneDAO.save(p1);
        partecipazioneDAO.save(p2);
        partecipazioneDAO.save(p3);
*/
        em.close();
        emf.close();


    }
}
