package pl.edu.wat.wcy.tim.racer.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import pl.edu.wat.wcy.tim.racer.domain.Trasa;
import pl.edu.wat.wcy.tim.racer.domain.Uzytkownik;
import pl.edu.wat.wcy.tim.racer.domain.Wyscig;

import java.util.Date;
import java.util.List;

@Repository
public interface WyscigRepository extends JpaRepository<Wyscig,Long>{
    List<Wyscig> findById(Long id);
    List<Wyscig> findByNazwa(String nazwa);
    List<Wyscig> findByUzytkownikId(Uzytkownik uzytkownikId);
    List<Wyscig> findByTrasaId(Trasa trasaId);
    List<Wyscig> findByTyp(String typ);
    List<Wyscig> findByDataBetween(Date min,Date max);
    List<Wyscig> findByNazwaContainsIgnoreCase(String nazwa);
    @Modifying
    @Transactional
    void deleteByTrasaId(Trasa trasaId);
}
