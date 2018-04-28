package pl.edu.wat.wcy.tim.racer.domain;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name="Wyscig",catalog="Racer",schema="dbo")
public class Wyscig {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @ManyToOne
    @JoinColumn(name = "id_uzytkownika")
    private Uzytkownik uzytkownikId;
    @ManyToOne
    @JoinColumn(name = "id_trasy")
    private Trasa trasaId;
    @Column(length=50)
    private String nazwa;
    @Column(length=256)
    private String opis;
    @Column(length=20)
    private String typ;
    @Column(nullable = false)
    private Date data;

    public Wyscig(){}

    public Wyscig(Uzytkownik uzytkownikId,Trasa trasaId,String nazwa,String opis,String typ,Date data){
        this.uzytkownikId = uzytkownikId;
        this.trasaId = trasaId;
        this.nazwa = nazwa;
        this.opis = opis;
        this.typ = typ;
        this.data = data;
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

    public Trasa getTrasaId() {
        return trasaId;
    }

    public void setTrasaId(Trasa trasaId) {
        this.trasaId = trasaId;
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

    public String getTyp() {
        return typ;
    }

    public void setTyp(String typ) {
        this.typ = typ;
    }

    public Date getData() {
        return data;
    }

    public void setData(Date data) {
        this.data = data;
    }
}
