package pl.edu.wat.wcy.tim.racer.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import pl.edu.wat.wcy.tim.racer.domain.CzasNaTrasie;
import pl.edu.wat.wcy.tim.racer.domain.PojazdyUzytkownika;
import pl.edu.wat.wcy.tim.racer.domain.PunktyTrasy;
import pl.edu.wat.wcy.tim.racer.domain.idClass.CzasNaTrasieId;

import java.util.List;

@Repository
public interface CzasNaTrasieRepository extends JpaRepository<CzasNaTrasie,CzasNaTrasieId>{
    List<CzasNaTrasie> findByPunktyTrasyId(PunktyTrasy punktyTrasyId);
    List<CzasNaTrasie> findByPojazdyUzytkownikaId(PojazdyUzytkownika pojazdyUzytkownikaId);
    List<CzasNaTrasie> findByPunktyTrasyIdAndPojazdyUzytkownikaId(PunktyTrasy punktyTrasyId,PojazdyUzytkownika pojazdyUzytkownikaId);
    @Modifying
    @Transactional
    void deleteByPunktyTrasyId(PunktyTrasy punktyTrasyId);
    @Modifying
    @Transactional
    void deleteByPojazdyUzytkownikaId(PojazdyUzytkownika pojazdyUzytkownikaId);
}
