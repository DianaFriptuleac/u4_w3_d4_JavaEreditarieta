package Diana_Friptuleac.classi;

import jakarta.persistence.*;

import java.time.LocalDate;

@Entity
@Table(name = "concerti")
public class Concerto extends Evento {

    @Enumerated(EnumType.STRING)
    @Column(name = "genere")
    private GenereConcerto genere;

    @Column(name = "in_streaming")
    private boolean inStreaming;


    public Concerto() {
    }

    public Concerto(String titolo, LocalDate data, String descrizione,
                    EventoType tipo_evento, int max_nr_partecipanti,
                    Location location, GenereConcerto genere, boolean inStreaming) {
        super(titolo, data, descrizione, tipo_evento, max_nr_partecipanti, location);
        this.genere = genere;
        this.inStreaming = inStreaming;
    }


    public GenereConcerto getGenere() {
        return genere;
    }

    public void setGenere(GenereConcerto genere) {
        this.genere = genere;
    }

    public boolean isInStreaming() {
        return inStreaming;
    }

    public void setInStreaming(boolean inStreaming) {
        this.inStreaming = inStreaming;
    }

    @Override
    public String toString() {
        return "Concerto{" +
                "genere=" + genere +
                ", inStreaming=" + inStreaming +
                ", " + super.toString() +
                '}';
    }
}
