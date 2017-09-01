package pl.edu.wat.wcy.tim.racer.domain;

import pl.edu.wat.wcy.tim.racer.domain.idClass.StatystykiTrasyId;

import javax.persistence.*;
import java.sql.Time;

@Entity
@IdClass(StatystykiTrasyId.class)
@Table(name="Statystyki_trasy",catalog="Racer",schema="dbo")
public class StatystykiTrasy {
    @Id
    @ManyToOne
    @JoinColumn(name = "id_trasy")
    private Trasa trasaId;
    @Id
    @ManyToOne
    @JoinColumns({
            @JoinColumn(name = "nr_pojazdu",referencedColumnName = "nr"),
            @JoinColumn(name = "id_uzytkownika",referencedColumnName = "id_uzytkownika")
    })
    private PojazdyUzytkownika pojazdyUzytkownikaId;
    private Time czas;
    @Column(name = "[v-max]")
    private int vMax;
    @Column(name = "[v-avg]")
    private int vAvg;
    private Time czas_0_100;
    private Time czas_0_vmax;
    private int ocena;

    public StatystykiTrasy() {}

    public StatystykiTrasy(Trasa trasaId, PojazdyUzytkownika pojazdyUzytkownikaId, Time czas, int vMax, int vAvg, Time czas_0_100, Time czas_0_vmax, int ocena) {
        this.trasaId = trasaId;
        this.pojazdyUzytkownikaId = pojazdyUzytkownikaId;
        this.czas = czas;
        this.vMax = vMax;
        this.vAvg = vAvg;
        this.czas_0_100 = czas_0_100;
        this.czas_0_vmax = czas_0_vmax;
        this.ocena = ocena;
    }

    public Trasa getTrasaId() {
        return trasaId;
    }

    public void setTrasaId(Trasa trasaId) {
        this.trasaId = trasaId;
    }

    public PojazdyUzytkownika getPojazdyUzytkownikaId() {
        return pojazdyUzytkownikaId;
    }

    public void setPojazdyUzytkownika(PojazdyUzytkownika pojazdyUzytkownikaId) {
        this.pojazdyUzytkownikaId = pojazdyUzytkownikaId;
    }

    public Time getCzas() {
        return czas;
    }

    public void setCzas(Time czas) {
        this.czas = czas;
    }

    public int getvMax() {
        return vMax;
    }

    public void setvMax(int vMax) {
        this.vMax = vMax;
    }

    public int getvAvg() {
        return vAvg;
    }

    public void setvAvg(int vAvg) {
        this.vAvg = vAvg;
    }

    public Time getCzas_0_100() {
        return czas_0_100;
    }

    public void setCzas_0_100(Time czas_0_100) {
        this.czas_0_100 = czas_0_100;
    }

    public Time getCzas_0_vmax() {
        return czas_0_vmax;
    }

    public void setCzas_0_vmax(Time czas_0_vmax) {
        this.czas_0_vmax = czas_0_vmax;
    }

    public int getOcena() {
        return ocena;
    }

    public void setOcena(int ocena) {
        this.ocena = ocena;
    }
}
