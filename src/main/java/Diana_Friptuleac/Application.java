package Diana_Friptuleac;

import Diana_Friptuleac.classi.*;
import Diana_Friptuleac.dao.EventoDAO;
import Diana_Friptuleac.dao.LocationDAO;
import Diana_Friptuleac.dao.PartitaCalcioDAO;
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
        PartitaCalcioDAO partitaCalcioDAO = new PartitaCalcioDAO(em);
        PersonaDAO personaDB = new PersonaDAO(em);


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

      /*  // Salvo gli eventi
        Evento evento1 = new Evento("Panda", LocalDate.of(2024, 12, 10), "Salviamo i Panda!", EventoType.PUBBLICO, 200, loc1);
        Evento evento2 = new Evento("Foreste", LocalDate.of(2024, 11, 15), "Proteggiamo le foreste", EventoType.PUBBLICO, 300, loc2);
        Evento evento3 = new Evento("Mare", LocalDate.of(2025, 1, 20), "Ripuliamo il mare", EventoType.PRIVATO, 150, loc3);

      /*  eventDB.save(evento1);
        eventDB.save(evento2);
        eventDB.save(evento3);*/

        //Salvo le partite
        PartitaCalcio pCalcio1 = new PartitaCalcio("Roma vs Juventus", LocalDate.of(2024, 9, 15),
                "Serie A", EventoType.PUBBLICO, 50000, loc1, "Roma", "Juventus", "Roma", 1, 0);

        PartitaCalcio pCalcio2 = new PartitaCalcio("Inter vs Milan", LocalDate.of(2024, 8, 10),
                "Derby di Milano", EventoType.PUBBLICO, 80000, loc2, "Inter", "Milan", "Inter", 1, 2);

        PartitaCalcio pCalcio3 = new PartitaCalcio("Torino vs Napoli", LocalDate.of(2024, 9, 10),
                "Serie A", EventoType.PUBBLICO, 40000, loc3, "Torino", "Napoli", null, 0, 0);


       /* partitaCalcioDAO.save(pCalcio1);
        partitaCalcioDAO.save(pCalcio2);
        partitaCalcioDAO.save(pCalcio3);
*/
        Persona pers1 = new Persona("Mario", "Rossi", "mario.rossi@gmail.com", LocalDate.of(1990, 5, 10), SessoPersona.M);
        Persona pers2 = new Persona("Anna", "Verdi", "anna.verdi@gmail.com", LocalDate.of(1985, 7, 23), SessoPersona.F);
        Persona pers3 = new Persona("Luca", "Bianchi", "luca.bianchi@gmail.com", LocalDate.of(1995, 12, 5), SessoPersona.M);

       /* personaDB.save(pers1);
        personaDB.save(pers2);
        personaDB.save(pers3);*/


        em.close();
        emf.close();


    }
}
