package Diana_Friptuleac.classi;

import jakarta.persistence.*;

@Entity
@Table(name = "partecipazioni")
public class Partecipazioni {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Enumerated(EnumType.STRING)
    @Column(name = "stato")
    private StatoPartecipazione stato;

    @ManyToOne
    @JoinColumn(name = "persona_id", nullable = false)
    private Persona persona;

    @ManyToOne
    @JoinColumn(name = "evento_id", nullable = false)
    private Evento evento;

    public Partecipazioni() {
    }

    public Partecipazioni(StatoPartecipazione stato, Persona partecipante, Evento evento) {
        this.stato = stato;
        this.persona = partecipante;
        this.evento = evento;

    }

    public Long getId() {
        return id;
    }

    public StatoPartecipazione getStato() {
        return stato;
    }

    public void setStato(StatoPartecipazione stato) {
        this.stato = stato;
    }

    public Persona getPartecipante() {
        return persona;
    }

    public void setPartecipante(Persona partecipante) {
        this.persona = partecipante;
    }

    public Evento getEvento() {
        return evento;
    }

    public void setEvento(Evento evento) {
        this.evento = evento;
    }

    @Override
    public String toString() {
        return "Partecipazioni{" +
                "id=" + id +
                ", stato=" + stato +
                ", partecipante=" + (persona != null ? persona.getId() : "null") +  // Stampo solo l'ID
                ", evento=" + (evento != null ? evento.getId() : "null") +  // Stampo solo l'ID
                '}';
    }
}
