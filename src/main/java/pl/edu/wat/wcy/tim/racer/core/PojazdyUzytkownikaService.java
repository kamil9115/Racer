package pl.edu.wat.wcy.tim.racer.core;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import pl.edu.wat.wcy.tim.racer.dao.*;
import pl.edu.wat.wcy.tim.racer.domain.*;
import pl.edu.wat.wcy.tim.racer.domain.idClass.PojazdyUzytkownikaId;

import java.util.List;

@Service
@Transactional
public class PojazdyUzytkownikaService {
    private PojazdyUzytkownikaRepository pojazdyUzytkownikaRepository;
    private UzytkownikRepository uzytkownikRepository;
    private PojazdRepository pojazdRepository;
    private StatystykiTrasyService statystykiTrasyService;
    private CzasNaTrasieService czasNaTrasieService;

    @Autowired
    public PojazdyUzytkownikaService(PojazdyUzytkownikaRepository pojazdyUzytkownikaRepository, UzytkownikRepository uzytkownikRepository, PojazdRepository pojazdRepository, StatystykiTrasyService statystykiTrasyService, CzasNaTrasieService czasNaTrasieService) {
        this.pojazdyUzytkownikaRepository = pojazdyUzytkownikaRepository;
        this.uzytkownikRepository = uzytkownikRepository;
        this.pojazdRepository = pojazdRepository;
        this.statystykiTrasyService = statystykiTrasyService;
        this.czasNaTrasieService = czasNaTrasieService;
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

    public ResponseEntity<PojazdyUzytkownika> addPojazdyUzytkownika(Long uzytkownikId,Long pojazdId,String nazwa,String opis){
        List<Uzytkownik> uzytkownik = uzytkownikRepository.findById(uzytkownikId);
        if(uzytkownik != null) {
            if(uzytkownik.size() > 0) {
                List<Pojazd> pojazd = pojazdRepository.findById(pojazdId);
                if(pojazd != null){
                    if(pojazd.size() > 0){
                        int nr = 0;
                        List<PojazdyUzytkownika> pojazdy = pojazdyUzytkownikaRepository.findByUzytkownikId(uzytkownik.get(0));
                        if(pojazdy != null) {
                            if (pojazdy.size() > 0) {
                                nr = pojazdy.get(0).getNr();
                                for (int i = 1; i < pojazdy.size(); i++) {
                                    if (nr < pojazdy.get(i).getNr()) {
                                        nr = pojazdy.get(i).getNr();
                                    }
                                }
                                nr++;
                            }
                            PojazdyUzytkownika pojazdyUzytkownika = new PojazdyUzytkownika(nr, uzytkownik.get(0), pojazd.get(0), nazwa, opis);
                            pojazdyUzytkownikaRepository.saveAndFlush(pojazdyUzytkownika);
                            return ResponseEntity.ok(pojazdyUzytkownika);
                        }else{
                            return new ResponseEntity(HttpStatus.EXPECTATION_FAILED);
                        }
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

    public ResponseEntity<PojazdyUzytkownika> deletePojazdyUzytkownika(int nr,Long uzytkownikId){
        List<Uzytkownik> uzytkownik = uzytkownikRepository.findById(uzytkownikId);
        if(uzytkownik != null) {
            if(uzytkownik.size() > 0) {
                List<PojazdyUzytkownika> pojazdyUzytkownika = pojazdyUzytkownikaRepository.findByNrAndUzytkownikId(nr, uzytkownik.get(0));
                if (pojazdyUzytkownika != null && pojazdyUzytkownika.size() > 0) {
                    statystykiTrasyService.deleteStatystykiTrasyByPojazdyUzytkownikaId(nr,uzytkownikId);
                    czasNaTrasieService.deleteCzasNaTrasieByPojazdyUzytkownikaId(nr,uzytkownikId);
                    pojazdyUzytkownikaRepository.delete(new PojazdyUzytkownikaId(nr,uzytkownik.get(0).getId()));
                    return ResponseEntity.ok(pojazdyUzytkownika.get(0));
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

    public ResponseEntity<List<PojazdyUzytkownika>> deletePojazdyUzytkownikaByUzytkownikId(Long uzytkownikId){
        List<Uzytkownik> uzytkownik = uzytkownikRepository.findById(uzytkownikId);
        if(uzytkownik != null) {
            if(uzytkownik.size() > 0) {
                List<PojazdyUzytkownika> pojazdyUzytkownika = pojazdyUzytkownikaRepository.findByUzytkownikId(uzytkownik.get(0));
                if (pojazdyUzytkownika != null && pojazdyUzytkownika.size() > 0) {
                    for(int i=0;i<pojazdyUzytkownika.size();i++){
                        statystykiTrasyService.deleteStatystykiTrasyByPojazdyUzytkownikaId(pojazdyUzytkownika.get(i).getNr(),uzytkownikId);
                        czasNaTrasieService.deleteCzasNaTrasieByPojazdyUzytkownikaId(pojazdyUzytkownika.get(i).getNr(),uzytkownikId);
                    }
                    pojazdyUzytkownikaRepository.deleteByUzytkownikId(uzytkownik.get(0));
                    return ResponseEntity.ok(pojazdyUzytkownika);
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

    public ResponseEntity<List<PojazdyUzytkownika>> deletePojazdyUzytkownikaByPojazdId(Long pojazdId){
        List<Pojazd> pojazd = pojazdRepository.findById(pojazdId);
        if(pojazd != null){
            if(pojazd.size() > 0){
                List<PojazdyUzytkownika> pojazdy = pojazdyUzytkownikaRepository.findByPojazdId(pojazd.get(0));
                if(pojazdy != null){
                    if(pojazdy.size() > 0){
                        pojazdyUzytkownikaRepository.deleteByPojazdId(pojazd.get(0));
                        return ResponseEntity.ok(pojazdy);
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

    public ResponseEntity<PojazdyUzytkownika> updatePojazdyUzytkownika(PojazdyUzytkownika pojazdyUzytkownika){
        if(pojazdyUzytkownikaRepository.exists(new PojazdyUzytkownikaId(pojazdyUzytkownika.getNr(),pojazdyUzytkownika.getUzytkownikId().getId()))){
            pojazdyUzytkownikaRepository.save(pojazdyUzytkownika);
            return ResponseEntity.ok(pojazdyUzytkownika);
        }else{
            return new ResponseEntity(HttpStatus.NO_CONTENT);
        }
    }
}
