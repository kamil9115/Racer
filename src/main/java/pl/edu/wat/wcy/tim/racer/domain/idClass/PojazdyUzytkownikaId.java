package pl.edu.wat.wcy.tim.racer.domain.idClass;

import java.io.Serializable;

public class PojazdyUzytkownikaId implements Serializable {
    int nr;
    long uzytkownikId;

    public PojazdyUzytkownikaId() {}

    public PojazdyUzytkownikaId(int nr, long uzytkownikId) {
        this.nr = nr;
        this.uzytkownikId = uzytkownikId;
    }

    public int getNr() {
        return nr;
    }

    public void setNr(int nr) {
        this.nr = nr;
    }

    public long getUzytkownikId() {
        return uzytkownikId;
    }

    public void setUzytkownikId(long uzytkownikId) {
        this.uzytkownikId = uzytkownikId;
    }

    @Override
    public boolean equals(Object obj) {
        if(obj != null && this.getClass().equals(obj.getClass())) {
            if ((this.nr == ((PojazdyUzytkownikaId) obj).nr) && this.uzytkownikId == ((PojazdyUzytkownikaId) obj).uzytkownikId) {
                return true;
            } else {
                return false;
            }
        }else{
            return false;
        }
    }

    @Override
    public int hashCode() {
        return (int)(nr + uzytkownikId);
    }
}
