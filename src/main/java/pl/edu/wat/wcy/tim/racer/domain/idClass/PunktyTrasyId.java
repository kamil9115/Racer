package pl.edu.wat.wcy.tim.racer.domain.idClass;

import pl.edu.wat.wcy.tim.racer.domain.Trasa;

import java.io.Serializable;

public class PunktyTrasyId implements Serializable {
    int nr;
    long trasaId;

    public PunktyTrasyId(){}

    public PunktyTrasyId(int nr, long trasaId) {
        this.nr = nr;
        this.trasaId = trasaId;
    }

    @Override
    public boolean equals(Object obj) {
        if(obj != null && this.getClass().equals(obj.getClass())) {
            if ((this.nr == ((PunktyTrasyId) obj).nr) && this.trasaId == ((PunktyTrasyId) obj).trasaId) {
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
        return (int)(nr + trasaId);
    }

    public int getNr() {
        return nr;
    }

    public void setNr(int nr) {
        this.nr = nr;
    }

    public long getTrasaId() {
        return trasaId;
    }

    public void setTrasaId(long trasaId) {
        this.trasaId = trasaId;
    }
}
