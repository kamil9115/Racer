package pl.edu.wat.wcy.tim.racer.domain.idClass;

import java.io.Serializable;

public class StatystykiTrasyId implements Serializable{
    long trasaId;
    PojazdyUzytkownikaId pojazdyUzytkownikaId;

    public StatystykiTrasyId() {}

    public StatystykiTrasyId(long trasaId, PojazdyUzytkownikaId pojazdyUzytkownikaId) {
        this.trasaId = trasaId;
        this.pojazdyUzytkownikaId = pojazdyUzytkownikaId;
    }

    public long getTrasaId() {
        return trasaId;
    }

    public void setTrasaId(long trasaId) {
        this.trasaId = trasaId;
    }

    public PojazdyUzytkownikaId getPojazdyUzytkownikaId() {
        return pojazdyUzytkownikaId;
    }

    public void setPojazdyUzytkownikaId(PojazdyUzytkownikaId pojazdyUzytkownikaId) {
        this.pojazdyUzytkownikaId = pojazdyUzytkownikaId;
    }

    @Override
    public boolean equals(Object obj) {
        if(obj != null && this.getClass().equals(obj.getClass())) {
            if ((this.trasaId == ((StatystykiTrasyId) obj).trasaId) && this.pojazdyUzytkownikaId.equals(((StatystykiTrasyId)obj).pojazdyUzytkownikaId)) {
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
        return (int)(trasaId + pojazdyUzytkownikaId.hashCode());
    }
}
