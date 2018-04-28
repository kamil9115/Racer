package pl.edu.wat.wcy.tim.racer.domain;

import javax.persistence.*;

@Entity
@Table(name="Pojazd",catalog="Racer",schema="dbo")
public class Pojazd {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @Column(length=50)
    private String marka;
    @Column(length=50)
    private String model;
    @Column(length=50)
    private String typ;
    private int pojemnosc;
    private float moc;

    public Pojazd(){}

    public Pojazd(String marka,String model,String typ,int pojemnosc,float moc){
        this.marka = marka;
        this.model = model;
        this.typ = typ;
        this.pojemnosc = pojemnosc;
        this.moc = moc;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getMarka() {
        return marka;
    }

    public void setMarka(String marka) {
        this.marka = marka;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public String getTyp() {
        return typ;
    }

    public void setTyp(String typ) {
        this.typ = typ;
    }

    public int getPojemnosc() {
        return pojemnosc;
    }

    public void setPojemnosc(int pojemnosc) {
        this.pojemnosc = pojemnosc;
    }

    public float getMoc() {
        return moc;
    }

    public void setMoc(float moc) {
        this.moc = moc;
    }
}
