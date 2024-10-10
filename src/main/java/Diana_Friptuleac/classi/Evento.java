package Diana_Friptuleac.classi;

import jakarta.persistence.*;

import java.time.LocalDate;

@Entity  //la classe dovra essere mappata ad una tabella. Hibernate- crea la tabella
@Table(name = "all_events")
public class Evento {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(name = "titolo_evento", nullable = false)
    private String titolo;

    @Column(name = "data_evento")
    private LocalDate data;

    @Column(name = "descrizione")
    private String descrizione;

    @Enumerated(EnumType.STRING)
    @Column(name = "tipo_evento")
    private EventoType tipo_evento;

    @Column(name = "max_nr_partecipanti")
    private int max_nr_partecipanti;

    @ManyToOne
    @JoinColumn(name = "location_id", nullable = false)
    private Location location;


    public Evento() {
        //il costruttore vuoto per JPA
    }


    public Evento(String titolo, LocalDate data, String descrizione, EventoType tipo_evento, int max_nr_partecipanti, Location location) {
        this.titolo = titolo;
        this.data = data;
        this.descrizione = descrizione;
        this.tipo_evento = tipo_evento;
        this.max_nr_partecipanti = max_nr_partecipanti;
        this.location = location;
    }

    public long getId() {
        return id;
    }

    public int getMax_nr_partecipanti() {
        return max_nr_partecipanti;
    }

    public void setMax_nr_partecipanti(int max_nr_partecipanti) {
        this.max_nr_partecipanti = max_nr_partecipanti;
    }

    public String getDescrizione() {
        return descrizione;
    }

    public void setDescrizione(String descrizione) {
        this.descrizione = descrizione;
    }

    public LocalDate getData() {
        return data;
    }

    public void setData(LocalDate data) {
        this.data = data;
    }

    public String getTitolo() {
        return titolo;
    }

    public void setTitolo(String titolo) {
        this.titolo = titolo;
    }

    public EventoType getTipo_evento() {
        return tipo_evento;
    }

    public void setTipo_evento(EventoType tipo_evento) {
        this.tipo_evento = tipo_evento;
    }

    public Location getLocation() {
        return location;
    }

    public void setLocation(Location location) {
        this.location = location;
    }


    @Override
    public String toString() {
        return "Evento{" +
                "id=" + id +
                ", titolo='" + titolo + '\'' +
                ", data=" + data +
                ", descrizione='" + descrizione + '\'' +
                ", tipo_evento=" + tipo_evento +
                ", max_nr_partecipanti=" + max_nr_partecipanti +
                '}';
    }
}
