package pl.edu.wat.wcy.tim.racer.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pl.edu.wat.wcy.tim.racer.domain.Pojazd;

import java.util.List;

@Repository
public interface PojazdRepository extends JpaRepository<Pojazd,Long>{
    List<Pojazd> findById(Long id);
    List<Pojazd> findByMarka(String marka);
    List<Pojazd> findByModel(String model);
    List<Pojazd> findByTyp(String typ);
    List<Pojazd> findByPojemnoscBetween(int min,int max);
    List<Pojazd> findByMocBetween(float min,float max);
    List<Pojazd> findByMarkaAndModel(String marka,String model);
    List<Pojazd> findByMarkaAndTyp(String marka,String typ);
    List<Pojazd> findByMarkaAndModelContainingIgnoreCase(String marka,String model);
    List<Pojazd> findByModelContainingIgnoreCase(String model);
}
