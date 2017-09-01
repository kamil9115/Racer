package pl.edu.wat.wcy.tim.racer.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import pl.edu.wat.wcy.tim.racer.domain.UczestnicyWyscigu;
import pl.edu.wat.wcy.tim.racer.domain.Uzytkownik;
import pl.edu.wat.wcy.tim.racer.domain.Wyscig;
import pl.edu.wat.wcy.tim.racer.domain.idClass.UczestnicyWysciguId;

import java.util.List;

@Repository
public interface UczestnicyWysciguRepository extends JpaRepository<UczestnicyWyscigu,UczestnicyWysciguId>{
    List<UczestnicyWyscigu> findByWyscigId(Wyscig wyscigId);
    List<UczestnicyWyscigu> findByUzytkownikId(Uzytkownik uzytkownikId);
    List<UczestnicyWyscigu> findByNrAndWyscigId(int nr,Wyscig wyscigId);
    List<UczestnicyWyscigu> findByWyscigIdAndUzytkownikId(Wyscig wyscigId, Uzytkownik uzytkownikId);
    List<UczestnicyWyscigu> findByWyscigIdAndMiejsce(Wyscig wyscigId,int miejsce);
    int countByWyscigId(Wyscig wyscigId);
    @Modifying
    @Transactional
    void deleteByWyscigId(Wyscig wyscigId);
}
