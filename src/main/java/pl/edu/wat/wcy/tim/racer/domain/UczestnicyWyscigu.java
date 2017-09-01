package pl.edu.wat.wcy.tim.racer.domain;

import pl.edu.wat.wcy.tim.racer.domain.idClass.UczestnicyWysciguId;

import javax.persistence.*;

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

    public UczestnicyWyscigu() {}

    public UczestnicyWyscigu(int nr, Wyscig wyscigId, Uzytkownik uzytkownikId, boolean potwierdzenie, int miejsce) {
        this.nr = nr;
        this.wyscigId = wyscigId;
        this.uzytkownikId = uzytkownikId;
        this.potwierdzenie = potwierdzenie;
        this.miejsce = miejsce;
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
}
