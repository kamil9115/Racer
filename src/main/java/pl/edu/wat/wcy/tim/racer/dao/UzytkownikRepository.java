package pl.edu.wat.wcy.tim.racer.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pl.edu.wat.wcy.tim.racer.domain.Uzytkownik;

import java.util.List;

/**
 * Created by Kamil on 25.07.2017.
 */
@Repository
public interface UzytkownikRepository extends JpaRepository<Uzytkownik, Long> {
    List<Uzytkownik> findByNazwa(String nazwa);
    List<Uzytkownik> findById(Long id);
    List<Uzytkownik> findByAdministrator(boolean administrator);
}
