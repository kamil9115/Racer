package pl.edu.wat.wcy.tim.racer.core;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import pl.edu.wat.wcy.tim.racer.dao.PojazdRepository;
import pl.edu.wat.wcy.tim.racer.dao.PojazdyUzytkownikaRepository;
import pl.edu.wat.wcy.tim.racer.dao.UzytkownikRepository;
import pl.edu.wat.wcy.tim.racer.domain.Pojazd;
import pl.edu.wat.wcy.tim.racer.domain.PojazdyUzytkownika;
import pl.edu.wat.wcy.tim.racer.domain.Uzytkownik;
import pl.edu.wat.wcy.tim.racer.domain.idClass.PojazdyUzytkownikaId;

import java.util.List;

@Service
@Transactional
public class PojazdyUzytkownikaService {
    private PojazdyUzytkownikaRepository pojazdyUzytkownikaRepository;
    private UzytkownikRepository uzytkownikRepository;
    private PojazdRepository pojazdRepository;

    @Autowired
    public PojazdyUzytkownikaService(PojazdyUzytkownikaRepository pojazdyUzytkownikaRepository, UzytkownikRepository uzytkownikRepository, PojazdRepository pojazdRepository) {
        this.pojazdyUzytkownikaRepository = pojazdyUzytkownikaRepository;
        this.uzytkownikRepository = uzytkownikRepository;
        this.pojazdRepository = pojazdRepository;
    }

    public ResponseEntity<List<PojazdyUzytkownika>> getPojazdyUzytkownika(){
        List<PojazdyUzytkownika> list = null;
        list = pojazdyUzytkownikaRepository.findAll();
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

    public ResponseEntity addPojazdyUzytkownika(Long uzytkownikId,Long pojazdId,String nazwa,String opis){
        List<Uzytkownik> uzytkownik = uzytkownikRepository.findById(uzytkownikId);
        if(uzytkownik != null) {
            if(uzytkownik.size() > 0) {
                List<Pojazd> pojazd = pojazdRepository.findById(pojazdId);
                if(pojazd != null){
                    if(pojazd.size() > 0){
                        int nr = pojazdyUzytkownikaRepository.countByUzytkownikId(uzytkownik.get(0));
                        PojazdyUzytkownika pojazdyUzytkownika = new PojazdyUzytkownika(nr,uzytkownik.get(0),pojazd.get(0),nazwa,opis);
                        pojazdyUzytkownikaRepository.saveAndFlush(pojazdyUzytkownika);
                        return new ResponseEntity(HttpStatus.CREATED);
                    }else{
                        return new ResponseEntity(HttpStatus.NO_CONTENT);
                    }
                }else{
                    return new ResponseEntity(HttpStatus.EXPECTATION_FAILED);
                }

            }else{
                return new ResponseEntity(HttpStatus.NO_CONTENT);
            }
        }else{
            return new ResponseEntity(HttpStatus.EXPECTATION_FAILED);
        }
    }

    public ResponseEntity<List<PojazdyUzytkownika>> getPojazdyUzytkownikaById(int nr,Long uzytkownikId){
        List<Uzytkownik> uzytkownik = uzytkownikRepository.findById(uzytkownikId);

        if(uzytkownik != null) {
            if(uzytkownik.size() > 0) {
                List<PojazdyUzytkownika> list = null;
                list = pojazdyUzytkownikaRepository.findByNrAndUzytkownikId(nr,uzytkownik.get(0));
                if(list != null){
                    if(list.size() > 0) {
                        return ResponseEntity.ok(list);
                    }else{
                        return new ResponseEntity(HttpStatus.NO_CONTENT);
                    }
                }else{
                    return new ResponseEntity(HttpStatus.EXPECTATION_FAILED);
                }
            }else{
                return new ResponseEntity(HttpStatus.NO_CONTENT);
            }
        }else{
            return new ResponseEntity(HttpStatus.EXPECTATION_FAILED);
        }
    }

    public ResponseEntity<List<PojazdyUzytkownika>> getPojazdyUzytkownikaByUzytkownikId(Long uzytkownikId){
        List<Uzytkownik> uzytkownik = uzytkownikRepository.findById(uzytkownikId);
        if(uzytkownik != null) {
            if(uzytkownik.size() > 0) {
                List<PojazdyUzytkownika> list = null;
                list = pojazdyUzytkownikaRepository.findByUzytkownikId(uzytkownik.get(0));
                if(list != null){
                    if(list.size() > 0) {
                        return ResponseEntity.ok(list);
                    }else{
                        return new ResponseEntity(HttpStatus.NO_CONTENT);
                    }
                }else{
                    return new ResponseEntity(HttpStatus.EXPECTATION_FAILED);
                }
            }else{
                return new ResponseEntity(HttpStatus.NO_CONTENT);
            }
        }else{
            return new ResponseEntity(HttpStatus.EXPECTATION_FAILED);
        }
    }

    public ResponseEntity<List<PojazdyUzytkownika>> getPojazdyUzytkownikaByPojazdId(Long pojazdId){
        List<Pojazd> pojazd = pojazdRepository.findById(pojazdId);
        if(pojazd != null) {
            if(pojazd.size() > 0) {
                List<PojazdyUzytkownika> list = null;
                list = pojazdyUzytkownikaRepository.findByPojazdId(pojazd.get(0));
                if(list != null){
                    if(list.size() > 0) {
                        return ResponseEntity.ok(list);
                    }else{
                        return new ResponseEntity(HttpStatus.NO_CONTENT);
                    }
                }else{
                    return new ResponseEntity(HttpStatus.EXPECTATION_FAILED);
                }
            }else{
                return new ResponseEntity(HttpStatus.NO_CONTENT);
            }
        }else{
            return new ResponseEntity(HttpStatus.EXPECTATION_FAILED);
        }
    }

    public ResponseEntity<List<PojazdyUzytkownika>> getPojazdyUzytkownikaByNazwa(String nazwa){
        List<PojazdyUzytkownika> list = null;
        list = pojazdyUzytkownikaRepository.findByNazwa(nazwa);
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

    public ResponseEntity deletePojazdyUzytkownika(int nr,Long uzytkownikId){
        List<Uzytkownik> uzytkownik = uzytkownikRepository.findById(uzytkownikId);
        if(uzytkownik != null) {
            if(uzytkownik.size() > 0) {
                if (pojazdyUzytkownikaRepository.findByNrAndUzytkownikId(nr, uzytkownik.get(0)).size() > 0) {
                    pojazdyUzytkownikaRepository.delete(new PojazdyUzytkownikaId(nr,uzytkownik.get(0).getId()));
                    return new ResponseEntity(HttpStatus.OK);
                } else {
                    return new ResponseEntity(HttpStatus.NO_CONTENT);
                }
            }else{
                return new ResponseEntity(HttpStatus.NO_CONTENT);
            }
        }else{
            return new ResponseEntity(HttpStatus.EXPECTATION_FAILED);
        }
    }

    public ResponseEntity deletePojazdyUzytkownikaByUzytkownikId(Long uzytkownikId){
        List<Uzytkownik> uzytkownik = uzytkownikRepository.findById(uzytkownikId);
        if(uzytkownik != null) {
            if(uzytkownik.size() > 0) {
                if (pojazdyUzytkownikaRepository.findByUzytkownikId(uzytkownik.get(0)).size() > 0) {
                    pojazdyUzytkownikaRepository.deleteByUzytkownikId(uzytkownik.get(0));
                    return new ResponseEntity(HttpStatus.OK);
                } else {
                    return new ResponseEntity(HttpStatus.NO_CONTENT);
                }
            }else{
                return new ResponseEntity(HttpStatus.NO_CONTENT);
            }
        }else{
            return new ResponseEntity(HttpStatus.EXPECTATION_FAILED);
        }
    }
}
