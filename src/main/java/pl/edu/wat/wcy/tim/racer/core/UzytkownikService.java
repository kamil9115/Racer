package pl.edu.wat.wcy.tim.racer.core;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import pl.edu.wat.wcy.tim.racer.dao.UzytkownikRepository;
import pl.edu.wat.wcy.tim.racer.domain.Uzytkownik;

import java.util.List;

/**
 * Created by Kamil on 25.07.2017.
 */
@Service
@Transactional
public class UzytkownikService {
    private UzytkownikRepository uzytkownikRepository;

    @Autowired
    public UzytkownikService(UzytkownikRepository uzytkownikRepository){
        this.uzytkownikRepository = uzytkownikRepository;
    }

    public ResponseEntity<List<Uzytkownik>> getUzytkownik() {
        List<Uzytkownik> list = null;
        list = uzytkownikRepository.findAll();
        if(list != null){
            if(list.size() > 0) {
                return ResponseEntity.ok(list);
            }else{
                return new ResponseEntity(HttpStatus.NO_CONTENT);
            }
        }else{
            return new ResponseEntity(HttpStatus.EXPECTATION_FAILED);
        }

    }

    public ResponseEntity addUzytkownik(String nazwa,String haslo){
        Uzytkownik uzytkownik = new Uzytkownik(nazwa,haslo);
        uzytkownikRepository.saveAndFlush(uzytkownik);
        return new ResponseEntity(HttpStatus.CREATED);
    }

    public ResponseEntity<List<Uzytkownik>> getUzytkownikByNazwa(String nazwa){
        List<Uzytkownik> list = null;
        list = uzytkownikRepository.findByNazwa(nazwa);
        if(list != null){
            if(list.size() > 0) {
                return ResponseEntity.ok(list);
            }else{
                return new ResponseEntity(HttpStatus.NO_CONTENT);
            }
        }else{
            return new ResponseEntity(HttpStatus.EXPECTATION_FAILED);
        }
    }

    public ResponseEntity<List<Uzytkownik>> getUzytkownikById(Long id) {
        List<Uzytkownik> list = null;
        list = uzytkownikRepository.findById(id);
        if(list != null){
            if(list.size() > 0) {
                return ResponseEntity.ok(list);
            }else{
                return new ResponseEntity(HttpStatus.NO_CONTENT);
            }
        }else{
            return new ResponseEntity(HttpStatus.EXPECTATION_FAILED);
        }
    }

    public ResponseEntity<List<Uzytkownik>> getUzytkownikByAdministrator(boolean administrator) {
        List<Uzytkownik> list = null;
        list = uzytkownikRepository.findByAdministrator(administrator);
        if(list != null){
            if(list.size() > 0) {
                return ResponseEntity.ok(list);
            }else{
                return new ResponseEntity(HttpStatus.NO_CONTENT);
            }
        }else{
            return new ResponseEntity(HttpStatus.EXPECTATION_FAILED);
        }
    }

    public ResponseEntity<Boolean> checkHaslo(String nazwa,String haslo){
        List<Uzytkownik> list = null;
        list = uzytkownikRepository.findByNazwa(nazwa);
        if(list != null){
            if(list.size() > 0) {
                String response = list.get(0).getHaslo().trim();
                return ResponseEntity.ok(haslo.equals(response));
            }else{
                return new ResponseEntity(HttpStatus.NO_CONTENT);
            }
        }else{
            return new ResponseEntity(HttpStatus.EXPECTATION_FAILED);
        }
    }

    public ResponseEntity deleteUzytkownik(Long id){
        if(uzytkownikRepository.exists(id)){
            uzytkownikRepository.delete(id);
            return new ResponseEntity(HttpStatus.OK);
        }else{
            return new ResponseEntity(HttpStatus.NO_CONTENT);
        }
    }
}
