package pl.edu.wat.wcy.tim.racer.domain;

import javax.persistence.*;

@Entity
@Table(name="Trasa",catalog="Racer",schema="dbo")
public class Trasa {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @ManyToOne
    @JoinColumn(name = "id_uzytkownika")
    private Uzytkownik uzytkownikId;
    @Column(length=50)
    private String nazwa;
    @Column(length=256)
    private String opis;
    @Column(name="ocena_avg",nullable=false)
    private float ocenaAvg;

    public Trasa(){}

    public Trasa(Uzytkownik uzytkownikId,String nazwa,String opis){
        this.uzytkownikId = uzytkownikId;
        this.nazwa = nazwa;
        this.opis = opis;
        this.ocenaAvg = 0;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Uzytkownik getUzytkownikId() {
        return uzytkownikId;
    }

    public void setUzytkownikId(Uzytkownik uzytkownikId) {
        this.uzytkownikId = uzytkownikId;
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

    public float getOcenaAvg() {
        return ocenaAvg;
    }

    public void setOcenaAvg(float ocena_avg) {
        this.ocenaAvg = ocena_avg;
    }
}
