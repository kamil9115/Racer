package pl.edu.wat.wcy.tim.Racer.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Uzytkownik {
    @Id
    @GeneratedValue
    private Long id;
    @Column(length=30,nullable=false)
    private String nazwa;
    @Column(length=30,nullable=false)
    private String haslo;
    @Column(nullable=false)
    private boolean administrator;

    public Uzytkownik(){}

    public Uzytkownik(String nazwa,String haslo){
        this.nazwa = nazwa;
        this.haslo = haslo;
        this.administrator = false;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNazwa() {
        return nazwa;
    }

    public void setNazwa(String nazwa) {
        this.nazwa = nazwa;
    }

    public String getHaslo() {
        return haslo;
    }

    public void setHaslo(String haslo) {
        this.haslo = haslo;
    }

    public boolean getAdministrator() {
        return administrator;
    }

    public void setAdministrator(boolean administrator) {
        this.administrator = administrator;
    }
}
