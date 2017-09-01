package pl.edu.wat.wcy.tim.racer.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.transaction.annotation.Transactional;
import pl.edu.wat.wcy.tim.racer.domain.Pojazd;
import pl.edu.wat.wcy.tim.racer.domain.PojazdyUzytkownika;
import pl.edu.wat.wcy.tim.racer.domain.Uzytkownik;
import pl.edu.wat.wcy.tim.racer.domain.idClass.PojazdyUzytkownikaId;

import java.util.List;

public interface PojazdyUzytkownikaRepository extends JpaRepository<PojazdyUzytkownika,PojazdyUzytkownikaId>{
    List<PojazdyUzytkownika> findByUzytkownikId(Uzytkownik uzytkownikId);
    List<PojazdyUzytkownika> findByPojazdId(Pojazd pojazdId);
    List<PojazdyUzytkownika> findByNazwa(String nazwa);
    List<PojazdyUzytkownika> findByNrAndUzytkownikId(int nr,Uzytkownik uzytkownikId);
    int countByUzytkownikId(Uzytkownik uzytkownikId);
    @Modifying
    @Transactional
    void deleteByUzytkownikId(Uzytkownik uzytkownikId);
}
