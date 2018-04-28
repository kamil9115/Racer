package pl.edu.wat.wcy.tim.racer.domain;

import pl.edu.wat.wcy.tim.racer.domain.idClass.CzasNaTrasieId;

import javax.persistence.*;
import java.sql.Time;

@Entity
@IdClass(CzasNaTrasieId.class)
@Table(name="Czas_na_trasie",catalog="Racer",schema="dbo")
public class CzasNaTrasie {
    @Id
    @ManyToOne
    @JoinColumns({
            @JoinColumn(name="nr_punktu",referencedColumnName = "nr"),
            @JoinColumn(name="id_trasy",referencedColumnName = "id_trasy")
    })
    private PunktyTrasy punktyTrasyId;
    @Id
    @ManyToOne
    @JoinColumns({
            @JoinColumn(name="nr_pojazdu",referencedColumnName = "nr"),
            @JoinColumn(name="id_uzytkownika",referencedColumnName = "id_uzytkownika")
    })
    private PojazdyUzytkownika pojazdyUzytkownikaId;
    @Column(nullable=false)
    private Time czas;

    public CzasNaTrasie() {}

    public CzasNaTrasie(PunktyTrasy punktyTrasyId, PojazdyUzytkownika pojazdyUzytkownikaId, Time czas) {
        this.punktyTrasyId = punktyTrasyId;
        this.pojazdyUzytkownikaId = pojazdyUzytkownikaId;
        this.czas = czas;
    }

    public PunktyTrasy getPunktyTrasyId() {
        return punktyTrasyId;
    }

    public void setPunktyTrasyId(PunktyTrasy punktyTrasyId) {
        this.punktyTrasyId = punktyTrasyId;
    }

    public PojazdyUzytkownika getPojazdyUzytkownikaId() {
        return pojazdyUzytkownikaId;
    }

    public void setPojazdyUzytkownikaId(PojazdyUzytkownika pojazdyUzytkownikaId) {
        this.pojazdyUzytkownikaId = pojazdyUzytkownikaId;
    }

    public Time getCzas() {
        return czas;
    }

    public void setCzas(Time czas) {
        this.czas = czas;
    }
}
