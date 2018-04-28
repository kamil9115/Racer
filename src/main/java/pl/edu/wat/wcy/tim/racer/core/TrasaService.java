package pl.edu.wat.wcy.tim.racer.core;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import pl.edu.wat.wcy.tim.racer.dao.TrasaRepository;
import pl.edu.wat.wcy.tim.racer.dao.UzytkownikRepository;
import pl.edu.wat.wcy.tim.racer.domain.Trasa;
import pl.edu.wat.wcy.tim.racer.domain.Uzytkownik;

import java.util.List;

@Service
@Transactional
public class TrasaService {
    private TrasaRepository trasaRepository;
    private UzytkownikRepository uzytkownikRepository;
    private WyscigService wyscigService;
    private PunktyTrasyService punktyTrasyService;


    @Autowired
    public TrasaService(TrasaRepository trasaRepository,UzytkownikRepository uzytkownikRepository,WyscigService wyscigService,PunktyTrasyService punktyTrasyService){
        this.trasaRepository = trasaRepository;
        this.uzytkownikRepository = uzytkownikRepository;
        this.wyscigService = wyscigService;
        this.punktyTrasyService = punktyTrasyService;
    }

    public ResponseEntity<List<Trasa>> getTrasa(){
        List<Trasa> list = null;
        list = trasaRepository.findAll();
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

    public ResponseEntity<Trasa> addTrasa(Long uzytkownikId,String nazwa,String opis){
        List<Uzytkownik> uzytkownik = uzytkownikRepository.findById(uzytkownikId);

        if(uzytkownik != null) {
            if(uzytkownik.size() > 0) {
                Trasa trasa = new Trasa(uzytkownik.get(0), nazwa, opis);
                trasaRepository.saveAndFlush(trasa);
                return ResponseEntity.ok(trasa);
            }else{
                return new ResponseEntity(HttpStatus.NO_CONTENT);
            }
        }else{
            return new ResponseEntity(HttpStatus.EXPECTATION_FAILED);
        }
    }

    public ResponseEntity<List<Trasa>> getTrasaById(Long id){
        List<Trasa> list = null;
        list = trasaRepository.findById(id);
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

    public ResponseEntity<List<Trasa>> getTrasaByNazwa(String nazwa){
        List<Trasa> list = null;
        list = trasaRepository.findByNazwa(nazwa);
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

    public ResponseEntity<List<Trasa>> getTrasaByUzytkownikId(Long uzytkownikId){
        List<Uzytkownik> uzytkownik = uzytkownikRepository.findById(uzytkownikId);
        if(uzytkownik != null) {
            if(uzytkownik.size() > 0) {
                List<Trasa> list = null;
                list = trasaRepository.findByUzytkownikId(uzytkownik.get(0));
                if (list != null) {
                    if (list.size() > 0) {
                        return ResponseEntity.ok(list);
                    } else {
                        return new ResponseEntity(HttpStatus.NO_CONTENT);
                    }
                } else {
                    return new ResponseEntity(HttpStatus.EXPECTATION_FAILED);
                }
            }else{
                return new ResponseEntity(HttpStatus.NO_CONTENT);
            }
        }else{
            return new ResponseEntity(HttpStatus.EXPECTATION_FAILED);
        }
    }

    public ResponseEntity<List<Trasa>> getTrasaByOcenaAvgBetween(float min,float max){
        List<Trasa> list = null;
        list = trasaRepository.findByOcenaAvgBetween(min,max);
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

    public ResponseEntity<List<Trasa>> getTrasaByNazwaLike(String nazwa){
        List<Trasa> list = null;
        list = trasaRepository.findByNazwaContainsIgnoreCase(nazwa);
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

    public ResponseEntity<Trasa> deleteTrasa(Long id){
        List<Trasa> trasa = trasaRepository.findById(id);
        if(trasa != null){
            if(trasa.size() > 0) {
                wyscigService.deleteWyscigByTrasaId(id);
                punktyTrasyService.deletePunktyTrasyByTrasaId(id);
                trasaRepository.delete(id);
                return ResponseEntity.ok(trasa.get(0));
            }else{
                return new ResponseEntity(HttpStatus.NO_CONTENT);
            }
        }else{
            return new ResponseEntity(HttpStatus.EXPECTATION_FAILED);
        }
    }

    public ResponseEntity<Trasa> updateTrasa(Trasa trasa){
        if(trasaRepository.exists(trasa.getId())){
            trasaRepository.save(trasa);
            return ResponseEntity.ok(trasa);
        }else{
            return new ResponseEntity(HttpStatus.NO_CONTENT);
        }
    }
}
