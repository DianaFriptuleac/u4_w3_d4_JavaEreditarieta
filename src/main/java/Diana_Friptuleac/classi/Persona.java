package Diana_Friptuleac.classi;

import jakarta.persistence.*;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "persona")
public class Persona {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "nome")
    private String name;
    @Column(name = "cognome")
    private String cognome;
    @Column(name = "email")
    private String email;
    @Column(name = "data_nascita")
    private LocalDate data_nascita;
    @Enumerated(EnumType.STRING)
    @Column(name = "sesso")
    private SessoPersona sesso_persona;

    @OneToMany(mappedBy = "persona")
    private List<Partecipazioni> partecipazionis = new ArrayList<>();

    public Persona() {
    }  //costruttore vuoto

    public Persona(String name, String cognome, String email, LocalDate data_nascita, SessoPersona sesso_persona) {
        this.name = name;
        this.cognome = cognome;
        this.email = email;
        this.data_nascita = data_nascita;
        this.sesso_persona = sesso_persona;
    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCognome() {
        return cognome;
    }

    public void setCognome(String cognome) {
        this.cognome = cognome;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public LocalDate getData_nascita() {
        return data_nascita;
    }

    public void setData_nascita(LocalDate data_nascita) {
        this.data_nascita = data_nascita;
    }

    public SessoPersona getSesso_persona() {
        return sesso_persona;
    }

    public void setSesso_persona(SessoPersona sesso_persona) {
        this.sesso_persona = sesso_persona;
    }

    public List<Partecipazioni> getPartecipazionis() {
        return partecipazionis;
    }


    @Override
    public String toString() {
        return "Persona{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", cognome='" + cognome + '\'' +
                ", email='" + email + '\'' +
                ", data_nascita=" + data_nascita +
                ", sesso_persona=" + sesso_persona +
                '}';
    }
}
