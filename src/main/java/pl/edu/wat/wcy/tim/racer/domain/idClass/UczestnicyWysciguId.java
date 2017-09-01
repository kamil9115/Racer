package pl.edu.wat.wcy.tim.racer.domain.idClass;

import java.io.Serializable;

public class UczestnicyWysciguId implements Serializable{
    int nr;
    long wyscigId;

    public UczestnicyWysciguId() {}

    public UczestnicyWysciguId(int nr, long wyscigId) {
        this.nr = nr;
        this.wyscigId = wyscigId;
    }

    public int getNr() {
        return nr;
    }

    public void setNr(int nr) {
        this.nr = nr;
    }

    public long getWyscigId() {
        return wyscigId;
    }

    public void setWyscigId(long wyscigId) {
        this.wyscigId = wyscigId;
    }

    @Override
    public boolean equals(Object obj) {
        if(obj != null && this.getClass().equals(obj.getClass())) {
            if ((this.nr == ((UczestnicyWysciguId) obj).nr) && this.wyscigId == ((UczestnicyWysciguId) obj).wyscigId) {
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
        return (int)(nr + wyscigId);
    }
}
