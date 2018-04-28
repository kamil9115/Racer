package pl.edu.wat.wcy.tim.racer.domain;

import pl.edu.wat.wcy.tim.racer.domain.idClass.UczestnicyWysciguId;

import javax.persistence.*;
import java.sql.Time;

@Entity
@IdClass(UczestnicyWysciguId.class)
@Table(name="Uczestnicy_wyscigu",catalog="Racer",schema="dbo")
public class UczestnicyWyscigu {
    @Id
    private int nr;
    @Id
    @ManyToOne
    @JoinColumn(name = "id_wyscigu")
    private Wyscig wyscigId;
    @ManyToOne
    @JoinColumn(name = "id_uzytkownika")
    private Uzytkownik uzytkownikId;
    private boolean potwierdzenie;
    private int miejsce;
    private Time czas;
    @Column(name = "[v-max]")
    private int vMax;
    @Column(name = "[v-avg]")
    private int vAvg;
    private Time czas_0_100;
    private Time czas_0_vmax;
    @Column(name="szerokosc_geo")
    private double szerokoscGeo;
    @Column(name="dlugosc_geo")
    private double dlugoscGeo;

    public UczestnicyWyscigu() {}

    public UczestnicyWyscigu(int nr, Wyscig wyscigId, Uzytkownik uzytkownikId, boolean potwierdzenie, int miejsce) {
        this.nr = nr;
        this.wyscigId = wyscigId;
        this.uzytkownikId = uzytkownikId;
        this.potwierdzenie = potwierdzenie;
        this.miejsce = miejsce;
    }

    public UczestnicyWyscigu(int nr, Wyscig wyscigId, Uzytkownik uzytkownikId, boolean potwierdzenie, int miejsce, Time czas, int vMax, int vAvg, Time czas_0_100, Time czas_0_vmax, double szerokoscGeo, double dlugoscGeo) {
        this.nr = nr;
        this.wyscigId = wyscigId;
        this.uzytkownikId = uzytkownikId;
        this.potwierdzenie = potwierdzenie;
        this.miejsce = miejsce;
        this.czas = czas;
        this.vMax = vMax;
        this.vAvg = vAvg;
        this.czas_0_100 = czas_0_100;
        this.czas_0_vmax = czas_0_vmax;
        this.szerokoscGeo = szerokoscGeo;
        this.dlugoscGeo = dlugoscGeo;
    }

    public int getNr() {
        return nr;
    }

    public void setNr(int nr) {
        this.nr = nr;
    }

    public Wyscig getWyscigId() {
        return wyscigId;
    }

    public void setWyscigId(Wyscig wyscigId) {
        this.wyscigId = wyscigId;
    }

    public Uzytkownik getUzytkownikId() {
        return uzytkownikId;
    }

    public void setUzytkownikId(Uzytkownik uzytkownikId) {
        this.uzytkownikId = uzytkownikId;
    }

    public boolean isPotwierdzenie() {
        return potwierdzenie;
    }

    public void setPotwierdzenie(boolean potwierdzenie) {
        this.potwierdzenie = potwierdzenie;
    }

    public int getMiejsce() {
        return miejsce;
    }

    public void setMiejsce(int miejsce) {
        this.miejsce = miejsce;
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

    public double getSzerokoscGeo() {
        return szerokoscGeo;
    }

    public void setSzerokoscGeo(double szerokoscGeo) {
        this.szerokoscGeo = szerokoscGeo;
    }

    public double getDlugoscGeo() {
        return dlugoscGeo;
    }

    public void setDlugoscGeo(double dlugoscGeo) {
        this.dlugoscGeo = dlugoscGeo;
    }
}
