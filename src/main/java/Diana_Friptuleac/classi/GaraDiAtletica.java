package Diana_Friptuleac.classi;

import jakarta.persistence.*;

import java.time.LocalDate;
import java.util.Set;

@Entity
@Table(name = "gare_atletica")
public class GaraDiAtletica extends Evento {

    @ManyToMany
    @JoinTable(
            name = "atleti_gara",
            joinColumns = @JoinColumn(name = "gara_id"),
            inverseJoinColumns = @JoinColumn(name = "atleta_id")
    )
    private Set<Persona> atleti;

    @ManyToOne
    @JoinColumn(name = "vincitore_id")
    private Persona vincitore;


    public GaraDiAtletica() {
    }

    public GaraDiAtletica(String titolo, LocalDate data, String descrizione, EventoType tipo_evento, int max_nr_partecipanti,
                          Location location, Set<Persona> atleti, Persona vincitore) {
        super(titolo, data, descrizione, tipo_evento, max_nr_partecipanti, location);
        this.atleti = atleti;
        this.vincitore = vincitore;
    }


    public Set<Persona> getAtleti() {
        return atleti;
    }

    public void setAtleti(Set<Persona> atleti) {
        this.atleti = atleti;
    }

    public Persona getVincitore() {
        return vincitore;
    }

    public void setVincitore(Persona vincitore) {
        this.vincitore = vincitore;
    }

    @Override
    public String toString() {
        return "GaraDiAtletica{" +
                "atleti=" + atleti +
                ", vincitore=" + vincitore +
                ", " + super.toString() +
                '}';
    }
}
