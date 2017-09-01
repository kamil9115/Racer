package pl.edu.wat.wcy.tim.racer.core;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import pl.edu.wat.wcy.tim.racer.dao.PojazdRepository;
import pl.edu.wat.wcy.tim.racer.domain.Pojazd;

import java.util.List;

@Service
@Transactional
public class PojazdService {
    private PojazdRepository pojazdRepository;

    @Autowired
    public PojazdService(PojazdRepository pojazdRepository){
        this.pojazdRepository = pojazdRepository;
    }

    public ResponseEntity<List<Pojazd>> getPojazd() {
        List<Pojazd> list = null;
        list = pojazdRepository.findAll();
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

    public ResponseEntity addPojazd(String marka,String model,String typ,int pojemnosc,float moc){
        Pojazd pojazd = new Pojazd(marka,model,typ,pojemnosc,moc);
        pojazdRepository.saveAndFlush(pojazd);
        return new ResponseEntity(HttpStatus.CREATED);
    }

    public ResponseEntity<List<Pojazd>> getPojazdById(Long id){
        List<Pojazd> list = null;
        list = pojazdRepository.findById(id);
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

    public ResponseEntity<List<Pojazd>> getPojazdByModel(String model){
        List<Pojazd> list = null;
        list = pojazdRepository.findByModel(model);
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

    public ResponseEntity<List<Pojazd>> getPojazdByMarka(String marka){
        List<Pojazd> list = null;
        list = pojazdRepository.findByMarka(marka);
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

    public ResponseEntity<List<Pojazd>> getPojazdByTyp(String typ){
        List<Pojazd> list = null;
        list = pojazdRepository.findByTyp(typ);
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

    public ResponseEntity<List<Pojazd>> getPojazdByPojemnoscBetween(int min,int max){
        List<Pojazd> list = null;
        list = pojazdRepository.findByPojemnoscBetween(min,max);
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

    public ResponseEntity<List<Pojazd>> getPojazdByMocBetween(float min,float max){
        List<Pojazd> list = null;
        list = pojazdRepository.findByMocBetween(min,max);
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

    public ResponseEntity<List<Pojazd>> getPojazdByMarkaAndModel(String marka,String model){
        List<Pojazd> list = null;
        list = pojazdRepository.findByMarkaAndModel(marka,model);
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

    public ResponseEntity<List<Pojazd>> getPojazdByMarkaAndTyp(String marka,String typ){
        List<Pojazd> list = null;
        list = pojazdRepository.findByMarkaAndTyp(marka,typ);
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

    public ResponseEntity<List<Pojazd>> getPojazdByMarkaAndModelLike(String marka,String model){
        List<Pojazd> list = null;
        list = pojazdRepository.findByMarkaAndModelContainingIgnoreCase(marka,model);
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

    public ResponseEntity<List<Pojazd>> getPojazdByModelLike(String model){
        List<Pojazd> list = null;
        list = pojazdRepository.findByModelContainingIgnoreCase(model);
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

    public ResponseEntity deletePojazd(Long id){
        if(pojazdRepository.exists(id)){
            pojazdRepository.delete(id);
            return new ResponseEntity(HttpStatus.OK);
        }else{
            return new ResponseEntity(HttpStatus.NO_CONTENT);
        }
    }
}
