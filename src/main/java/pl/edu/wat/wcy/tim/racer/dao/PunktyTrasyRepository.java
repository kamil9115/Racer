package pl.edu.wat.wcy.tim.racer.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import pl.edu.wat.wcy.tim.racer.domain.PunktyTrasy;
import pl.edu.wat.wcy.tim.racer.domain.Trasa;
import pl.edu.wat.wcy.tim.racer.domain.idClass.PunktyTrasyId;

import java.util.List;

@Repository
public interface PunktyTrasyRepository extends JpaRepository<PunktyTrasy,PunktyTrasyId>{
    List<PunktyTrasy> findByNrAndTrasaId(int nr,Trasa trasaId);
    List<PunktyTrasy> findByTrasaId(Trasa trasaId);
    int countByTrasaId(Trasa trasaId);
    @Modifying
    @Transactional
    void deleteByTrasaId(Trasa trasaId);
}
