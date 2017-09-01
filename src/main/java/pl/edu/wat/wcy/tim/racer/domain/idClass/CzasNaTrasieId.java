package pl.edu.wat.wcy.tim.racer.domain.idClass;



import java.io.Serializable;

public class CzasNaTrasieId implements Serializable{
    PunktyTrasyId punktyTrasyId;
    PojazdyUzytkownikaId pojazdyUzytkownikaId;

    public CzasNaTrasieId() {}

    public CzasNaTrasieId(PunktyTrasyId punktyTrasyId, PojazdyUzytkownikaId pojazdyUzytkownikaId) {
        this.punktyTrasyId = punktyTrasyId;
        this.pojazdyUzytkownikaId = pojazdyUzytkownikaId;
    }

    public PunktyTrasyId getPunktyTrasyId() {
        return punktyTrasyId;
    }

    public void setPunktyTrasyId(PunktyTrasyId punktyTrasyId) {
        this.punktyTrasyId = punktyTrasyId;
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
            if ((this.punktyTrasyId.equals(((CzasNaTrasieId) obj).punktyTrasyId)) && this.pojazdyUzytkownikaId.equals(((CzasNaTrasieId)obj).pojazdyUzytkownikaId)) {
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
        return (int)(punktyTrasyId.hashCode() + pojazdyUzytkownikaId.hashCode());
    }
}
