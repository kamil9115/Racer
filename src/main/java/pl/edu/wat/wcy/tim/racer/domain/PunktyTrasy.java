package pl.edu.wat.wcy.tim.racer.domain;

import pl.edu.wat.wcy.tim.racer.domain.idClass.PunktyTrasyId;

import javax.persistence.*;

@Entity
@IdClass(PunktyTrasyId.class)
@Table(name="Punkty_trasy",catalog="Racer",schema="dbo")
public class PunktyTrasy {
    @Id
    private int nr;
    @Id
    @ManyToOne
    @JoinColumn(name="id_trasy")
    private Trasa trasaId;
    @Column(name="szerokosc_geo")
    private double szerokoscGeo;
    @Column(name="dlugosc_geo")
    private double dlugoscGeo;

    public PunktyTrasy(){}

    public PunktyTrasy(int nr,Trasa trasaId,double szerokoscGeo,double dlugoscGeo){
        this.nr = nr;
        this.trasaId = trasaId;
        this.szerokoscGeo = szerokoscGeo;
        this.dlugoscGeo = dlugoscGeo;
    }

    public int getNr() {
        return nr;
    }

    public void setNr(int nr) {
        this.nr = nr;
    }

    public Trasa getTrasaId() {
        return trasaId;
    }

    public void setTrasaId(Trasa trasaId) {
        this.trasaId = trasaId;
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
