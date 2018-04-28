package pl.edu.wat.wcy.tim.racer.domain;

import pl.edu.wat.wcy.tim.racer.domain.idClass.PojazdyUzytkownikaId;

import javax.persistence.*;

@Entity
@IdClass(PojazdyUzytkownikaId.class)
@Table(name="Pojazdy_uzytkownika",catalog="Racer",schema="dbo")
public class PojazdyUzytkownika {
    @Id
    private int nr;
    @Id
    @ManyToOne
    @JoinColumn(name = "id_uzytkownika")
    private Uzytkownik uzytkownikId;
    @ManyToOne
    @JoinColumn(name = "id_pojazdu")
    private Pojazd pojazdId;
    @Column(length = 100)
    private String nazwa;
    @Column(length = 256)
    private String opis;

    public PojazdyUzytkownika() {}

    public PojazdyUzytkownika(int nr, Uzytkownik uzytkownikId, Pojazd pojazdId, String nazwa, String opis) {
        this.nr = nr;
        this.uzytkownikId = uzytkownikId;
        this.pojazdId = pojazdId;
        this.nazwa = nazwa;
        this.opis = opis;
    }

    public int getNr() {
        return nr;
    }

    public void setNr(int nr) {
        this.nr = nr;
    }

    public Uzytkownik getUzytkownikId() {
        return uzytkownikId;
    }

    public void setUzytkownikId(Uzytkownik uzytkownikId) {
        this.uzytkownikId = uzytkownikId;
    }

    public Pojazd getPojazdId() {
        return pojazdId;
    }

    public void setPojazdId(Pojazd pojazdId) {
        this.pojazdId = pojazdId;
    }

    public String getNazwa() {
        return nazwa;
    }

    public void setNazwa(String nazwa) {
        this.nazwa = nazwa;
    }

    public String getOpis() {
        return opis;
    }

    public void setOpis(String opis) {
        this.opis = opis;
    }
}
