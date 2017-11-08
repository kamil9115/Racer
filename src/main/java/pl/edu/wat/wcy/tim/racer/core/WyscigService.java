package pl.edu.wat.wcy.tim.racer.core;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import pl.edu.wat.wcy.tim.racer.dao.TrasaRepository;
import pl.edu.wat.wcy.tim.racer.dao.UzytkownikRepository;
import pl.edu.wat.wcy.tim.racer.dao.WyscigRepository;
import pl.edu.wat.wcy.tim.racer.domain.Trasa;
import pl.edu.wat.wcy.tim.racer.domain.Uzytkownik;
import pl.edu.wat.wcy.tim.racer.domain.Wyscig;

import java.util.Date;
import java.util.List;

@Service
@Transactional
public class WyscigService {
    private WyscigRepository wyscigRepository;
    private TrasaRepository trasaRepository;
    private UzytkownikRepository uzytkownikRepository;
    private UczestnicyWysciguService uczestnicyWysciguService;

    @Autowired
    public WyscigService(WyscigRepository wyscigRepository,TrasaRepository trasaRepository,UzytkownikRepository uzytkownikRepository, UczestnicyWysciguService uczestnicyWysciguService){
        this.wyscigRepository = wyscigRepository;
        this.trasaRepository = trasaRepository;
        this.uzytkownikRepository = uzytkownikRepository;
        this.uczestnicyWysciguService = uczestnicyWysciguService;
    }

    public ResponseEntity<List<Wyscig>> getWyscig(){
        List<Wyscig> list = null;
        list = wyscigRepository.findAll();
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

    public ResponseEntity<Wyscig> addWyscig(Long uzytkownikId, Long trasaId, String nazwa, String opis, String typ, Date data){
        List<Uzytkownik> uzytkownik = uzytkownikRepository.findById(uzytkownikId);
        List<Trasa> trasa = trasaRepository.findById(trasaId);
        if(uzytkownik != null && trasa != null) {
            if(uzytkownik.size() > 0 && trasa.size() > 0) {
                Wyscig wyscig = new Wyscig(uzytkownik.get(0),trasa.get(0), nazwa, opis, typ, data);
                wyscigRepository.saveAndFlush(wyscig);
                return ResponseEntity.ok(wyscig);
            }else{
                return new ResponseEntity(HttpStatus.NO_CONTENT);
            }
        }else{
            return new ResponseEntity(HttpStatus.EXPECTATION_FAILED);
        }
    }

    public ResponseEntity<List<Wyscig>> getWyscigById(Long id){
        List<Wyscig> list = null;
        list = wyscigRepository.findById(id);
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

    public ResponseEntity<List<Wyscig>> getWyscigByNazwa(String nazwa){
        List<Wyscig> list = null;
        list = wyscigRepository.findByNazwa(nazwa);
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

    public ResponseEntity<List<Wyscig>> getWyscigByTyp(String typ){
        List<Wyscig> list = null;
        list = wyscigRepository.findByTyp(typ);
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

    public ResponseEntity<List<Wyscig>> getWyscigByDataBetween(Date min,Date max){
        List<Wyscig> list = null;
        list = wyscigRepository.findByDataBetween(min,max);
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

    public ResponseEntity<List<Wyscig>> getWyscigByUzytkownikId(Long uzytkownikId){
        List<Uzytkownik> uzytkownik = uzytkownikRepository.findById(uzytkownikId);
        if(uzytkownik != null) {
            if(uzytkownik.size() > 0) {
                List<Wyscig> list = null;
                list = wyscigRepository.findByUzytkownikId(uzytkownik.get(0));
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

    public ResponseEntity<List<Wyscig>> getWyscigByTrasaId(Long trasaId){
        List<Trasa> trasa = trasaRepository.findById(trasaId);
        if(trasa != null) {
            if(trasa.size() > 0) {
                List<Wyscig> list = null;
                list = wyscigRepository.findByTrasaId(trasa.get(0));
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

    public ResponseEntity<List<Wyscig>> getWyscigByNazwaLike(String nazwa){
        List<Wyscig> list = null;
        list = wyscigRepository.findByNazwaContainsIgnoreCase(nazwa);
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

    public ResponseEntity<Wyscig> deleteWyscig(Long id){
        List<Wyscig> wyscig = wyscigRepository.findById(id);
        if(wyscig != null ){
            if(wyscig.size() > 0) {
                uczestnicyWysciguService.deleteUczestnicyWysciguByWyscigId(id);
                wyscigRepository.delete(id);
                return ResponseEntity.ok(wyscig.get(0));
            }else{
                return new ResponseEntity(HttpStatus.NO_CONTENT);
            }
        }else{
            return new ResponseEntity(HttpStatus.EXPECTATION_FAILED);
        }
    }

    public ResponseEntity<List<Wyscig>> deleteWyscigByTrasaId(Long trasaId){
        List<Trasa> trasa = trasaRepository.findById(trasaId);
        if (trasa != null) {
            if(trasa.size() > 0){
                List<Wyscig> wyscig = wyscigRepository.findByTrasaId(trasa.get(0));
                if(wyscig != null){
                    if(wyscig.size() > 0){
                        for(int i=0;i<wyscig.size();i++){
                            uczestnicyWysciguService.deleteUczestnicyWysciguByWyscigId(wyscig.get(i).getId());
                        }
                        wyscigRepository.deleteByTrasaId(trasa.get(0));
                        return ResponseEntity.ok(wyscig);
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

    public ResponseEntity<Wyscig> updateWyscig(Wyscig wyscig){
        if(wyscigRepository.exists(wyscig.getId())){
            wyscigRepository.save(wyscig);
            return ResponseEntity.ok(wyscig);
        }else{
            return new ResponseEntity(HttpStatus.NO_CONTENT);
        }
    }
}
