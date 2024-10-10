package Diana_Friptuleac.classi;

import jakarta.persistence.*;

@Entity
@Table(name = "location")
public class Location {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "nome_location")
    private String nome_location;

    @Column(name = "citta")
    private String citta;

    public Location() {
    }

    public Location(String nome_location, String citta) {
        this.nome_location = nome_location;
        this.citta = citta;
    }

    public Long getId() {
        return id;
    }

    public String getNome_location() {
        return nome_location;
    }

    public void setNome_location(String nome_location) {
        this.nome_location = nome_location;
    }

    public String getCitta() {
        return citta;
    }

    public void setCitta(String citta) {
        this.citta = citta;
    }

    @Override
    public String toString() {
        return "Location{" +
                "id=" + id +
                ", nome_location='" + nome_location + '\'' +
                ", citta='" + citta + '\'' +
                '}';
    }
}

