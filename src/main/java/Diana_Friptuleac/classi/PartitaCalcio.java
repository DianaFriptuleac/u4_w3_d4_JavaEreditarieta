package Diana_Friptuleac.classi;

import jakarta.persistence.*;

import java.time.LocalDate;

@Entity
@DiscriminatorValue("Partite a Calcio")
@NamedQueries({
        @NamedQuery(name = "PartitaCalcio.getPartiteVintelnCasa", query = "SELECT p FROM PartitaCalcio p WHERE p.squadraVincente = p.squadraCasa"),
        @NamedQuery(name = "PartitaCalcio.getPartiteVintelnTrasferta", query = "SELECT p FROM PartitaCalcio p WHERE p.squadraVincente = p.squadraOspite")})
@Table(name = "partite")
public class PartitaCalcio extends Evento {

    @Column(name = "squadra_di_casa")
    private String squadraCasa;

    @Column(name = "squadra_ospite")
    private String squadraOspite;

    @Column(name = "squadra_vincente")
    private String squadraVincente;

    @Column(name = "gol_squadra_di_casa")
    private int golSquadraCasa;

    @Column(name = "gol_squadra_ospite")
    private int golSquadraOspite;


    public PartitaCalcio() {
    }

    public PartitaCalcio(String titolo, LocalDate data, String descrizione, EventoType tipo_evento,
                         int max_nr_partecipanti, Location location, String squadraCasa, String squadraOspite,
                         String squadraVincente, int golSquadraCasa, int golSquadraOspite) {
        super(titolo, data, descrizione, tipo_evento, max_nr_partecipanti, location);
        this.squadraCasa = squadraCasa;
        this.squadraOspite = squadraOspite;
        this.squadraVincente = squadraVincente;
        this.golSquadraCasa = golSquadraCasa;
        this.golSquadraOspite = golSquadraOspite;
    }

    public String getSquadraCasa() {
        return squadraCasa;
    }

    public void setSquadraCasa(String squadraCasa) {
        this.squadraCasa = squadraCasa;
    }

    public String getSquadraOspite() {
        return squadraOspite;
    }

    public void setSquadraOspite(String squadraOspite) {
        this.squadraOspite = squadraOspite;
    }

    public String getSquadraVincente() {
        return squadraVincente;
    }

    public void setSquadraVincente(String squadraVincente) {
        this.squadraVincente = squadraVincente;
    }

    public int getGolSquadraCasa() {
        return golSquadraCasa;
    }

    public void setGolSquadraCasa(int golSquadraCasa) {
        this.golSquadraCasa = golSquadraCasa;
    }

    public int getGolSquadraOspite() {
        return golSquadraOspite;
    }

    public void setGolSquadraOspite(int golSquadraOspite) {
        this.golSquadraOspite = golSquadraOspite;
    }

    @Override
    public String toString() {
        return "PartitaCalcio{" +
                "squadraCasa='" + squadraCasa + '\'' +
                ", squadraOspite='" + squadraOspite + '\'' +
                ", squadraVincente='" + squadraVincente + '\'' +
                ", golSquadraCasa=" + golSquadraCasa +
                ", golSquadraOspite=" + golSquadraOspite +
                ", " + super.toString() +  //evento
                '}';
    }
}
