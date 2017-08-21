package pl.edu.wat.wcy.tim.Racer.core;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import pl.edu.wat.wcy.tim.Racer.dao.UzytkownikRepository;
import pl.edu.wat.wcy.tim.Racer.domain.Uzytkownik;

import java.util.List;

@Service
@Transactional
public class UzytkownikService {
    private UzytkownikRepository uzytkownikRepository;

    @Autowired
    public UzytkownikService(UzytkownikRepository uzytkownikRepository){
        this.uzytkownikRepository = uzytkownikRepository;
    }

    public List<Uzytkownik> findAll(){
        return uzytkownikRepository.findAll();
    }

    public void addUzytkownik(Uzytkownik uzytkownik){
        uzytkownikRepository.saveAndFlush(uzytkownik);
    }

    public List<Uzytkownik> findByNazwa(String nazwa){
        return uzytkownikRepository.findByNazwa(nazwa);
    }

    public void delete(Long id){
        if(uzytkownikRepository.exists(id)){
            uzytkownikRepository.delete(id);
        }
    }
}
