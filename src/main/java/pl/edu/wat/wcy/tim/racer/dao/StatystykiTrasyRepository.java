package pl.edu.wat.wcy.tim.racer.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import pl.edu.wat.wcy.tim.racer.domain.PojazdyUzytkownika;
import pl.edu.wat.wcy.tim.racer.domain.StatystykiTrasy;
import pl.edu.wat.wcy.tim.racer.domain.Trasa;
import pl.edu.wat.wcy.tim.racer.domain.Uzytkownik;
import pl.edu.wat.wcy.tim.racer.domain.idClass.StatystykiTrasyId;

import java.util.List;

@Repository
public interface StatystykiTrasyRepository extends JpaRepository<StatystykiTrasy,StatystykiTrasyId> {
    List<StatystykiTrasy> findByTrasaId(Trasa trasaId);
    List<StatystykiTrasy> findByPojazdyUzytkownikaId(PojazdyUzytkownika pojazdyUzytkownikaId);
    List<StatystykiTrasy> findByTrasaIdAndPojazdyUzytkownikaId(Trasa trasaId, PojazdyUzytkownika pojazdyUzytkownikaId);
    List<StatystykiTrasy> findByOcenaBetween(int min, int max);
    @Modifying
    @Transactional
    void deleteByTrasaId(Trasa trasaId);
    @Modifying
    @Transactional
    void deleteByPojazdyUzytkownikaId(PojazdyUzytkownika pojazdyUzytkownikaId);
    List<StatystykiTrasy> findByPojazdyUzytkownikaId_UzytkownikId(Uzytkownik uzytkownikId);
    @Modifying
    @Transactional
    @Query(value = "update Statystyki_trasy set ocena = ?3 where id_trasy = ?1 and id_uzytkownika = ?2",nativeQuery = true)
    void updateOcenaByUzytkownikId(Trasa trasaId,Uzytkownik uzytkownikId,int ocena);

    @Query(value = "select avg(s.ocena) from StatystykiTrasy s where s.trasaId = ?1")
    Float findOcenaAvgByTrasaId(Trasa trasaId);
}
