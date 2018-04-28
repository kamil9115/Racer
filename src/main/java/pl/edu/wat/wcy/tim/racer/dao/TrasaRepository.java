package pl.edu.wat.wcy.tim.racer.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pl.edu.wat.wcy.tim.racer.domain.Trasa;
import pl.edu.wat.wcy.tim.racer.domain.Uzytkownik;

import java.util.List;

@Repository
public interface TrasaRepository extends JpaRepository<Trasa,Long>{
    List<Trasa> findById(Long id);
    List<Trasa> findByNazwa(String nazwa);
    List<Trasa> findByUzytkownikId(Uzytkownik uzytkownikId);
    List<Trasa> findByOcenaAvgBetween(float min,float max);
    List<Trasa> findByNazwaContainsIgnoreCase(String nazwa);
}
