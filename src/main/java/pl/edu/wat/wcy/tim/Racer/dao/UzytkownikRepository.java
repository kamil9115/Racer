package pl.edu.wat.wcy.tim.Racer.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pl.edu.wat.wcy.tim.Racer.domain.Uzytkownik;

import java.util.List;

@Repository
public interface UzytkownikRepository extends JpaRepository<Uzytkownik,Long> {
    public List<Uzytkownik> findByNazwa(String nazwa);
}
