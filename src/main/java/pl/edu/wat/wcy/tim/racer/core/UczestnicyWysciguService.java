package pl.edu.wat.wcy.tim.racer.core;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import pl.edu.wat.wcy.tim.racer.dao.UczestnicyWysciguRepository;
import pl.edu.wat.wcy.tim.racer.dao.UzytkownikRepository;
import pl.edu.wat.wcy.tim.racer.dao.WyscigRepository;
import pl.edu.wat.wcy.tim.racer.domain.UczestnicyWyscigu;
import pl.edu.wat.wcy.tim.racer.domain.Uzytkownik;
import pl.edu.wat.wcy.tim.racer.domain.Wyscig;
import pl.edu.wat.wcy.tim.racer.domain.idClass.UczestnicyWysciguId;

import java.util.List;

@Service
@Transactional
public class UczestnicyWysciguService {
    private UczestnicyWysciguRepository uczestnicyWysciguRepository;
    private WyscigRepository wyscigRepository;
    private UzytkownikRepository uzytkownikRepository;

    @Autowired
    public UczestnicyWysciguService(UczestnicyWysciguRepository uczestnicyWysciguRepository, WyscigRepository wyscigRepository, UzytkownikRepository uzytkownikRepository) {
        this.uczestnicyWysciguRepository = uczestnicyWysciguRepository;
        this.wyscigRepository = wyscigRepository;
        this.uzytkownikRepository = uzytkownikRepository;
    }

    public ResponseEntity<List<UczestnicyWyscigu>> getUczestnicyWyscigu(){
        List<UczestnicyWyscigu> list = null;
        list = uczestnicyWysciguRepository.findAll();
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

    public ResponseEntity addUczestnicyWyscigu(Long uzytkownikId,Long wyscigId){
        List<Uzytkownik> uzytkownik = uzytkownikRepository.findById(uzytkownikId);
        if(uzytkownik != null) {
            if(uzytkownik.size() > 0) {
                List<Wyscig> wyscig = wyscigRepository.findById(wyscigId);
                if(wyscig != null){
                    if(wyscig.size() > 0){
                        int nr = uczestnicyWysciguRepository.countByWyscigId(wyscig.get(0));
                        UczestnicyWyscigu uczestnicyWyscigu = new UczestnicyWyscigu(nr,wyscig.get(0),uzytkownik.get(0),false,0);
                        uczestnicyWysciguRepository.saveAndFlush(uczestnicyWyscigu);
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

    public ResponseEntity<List<UczestnicyWyscigu>> getUczestnicyWysciguById(int nr,Long wyscigId){
        List<Wyscig> wyscig = wyscigRepository.findById(wyscigId);

        if(wyscig != null) {
            if(wyscig.size() > 0) {
                List<UczestnicyWyscigu> list = null;
                list = uczestnicyWysciguRepository.findByNrAndWyscigId(nr,wyscig.get(0));
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
    public ResponseEntity<List<UczestnicyWyscigu>> getUczestnicyWysciguByWyscigIdAndUzytkownikId(Long wyscigId,Long uzytkownikId){
        List<Wyscig> wyscig = wyscigRepository.findById(wyscigId);
        if(wyscig != null) {
            if(wyscig.size() > 0) {
                List<Uzytkownik> uzytkownik = uzytkownikRepository.findById(uzytkownikId);
                if(uzytkownik != null) {
                    if (uzytkownik.size() > 0) {
                        List<UczestnicyWyscigu> list = null;
                        list = uczestnicyWysciguRepository.findByWyscigIdAndUzytkownikId(wyscig.get(0),uzytkownik.get(0));
                        if (list != null) {
                            if (list.size() > 0) {
                                return ResponseEntity.ok(list);
                            } else {
                                return new ResponseEntity(HttpStatus.NO_CONTENT);
                            }
                        } else {
                            return new ResponseEntity(HttpStatus.EXPECTATION_FAILED);
                        }
                    } else {
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

    public ResponseEntity<List<UczestnicyWyscigu>> getUczestnicyWysciguByWyscigIdAndMiejsce(Long wyscigId,int miejsce){
        List<Wyscig> wyscig = wyscigRepository.findById(wyscigId);
        if(wyscig != null) {
            if(wyscig.size() > 0) {
                List<UczestnicyWyscigu> list = null;
                list = uczestnicyWysciguRepository.findByWyscigIdAndMiejsce(wyscig.get(0),miejsce);
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

    public ResponseEntity<List<UczestnicyWyscigu>> getUczestnicyWysciguByWyscigId(Long wyscigId){
        List<Wyscig> wyscig = wyscigRepository.findById(wyscigId);
        if(wyscig != null) {
            if(wyscig.size() > 0) {
                List<UczestnicyWyscigu> list = null;
                list = uczestnicyWysciguRepository.findByWyscigId(wyscig.get(0));
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

    public ResponseEntity<List<UczestnicyWyscigu>> getUczestnicyWysciguByUzytkownikId(Long uzytkownikId){
        List<Uzytkownik> uzytkownik = uzytkownikRepository.findById(uzytkownikId);
        if(uzytkownik != null) {
            if(uzytkownik.size() > 0) {
                List<UczestnicyWyscigu> list = null;
                list = uczestnicyWysciguRepository.findByUzytkownikId(uzytkownik.get(0));
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

    public ResponseEntity deleteUczestnicyWyscigu(int nr,Long wyscigId){
        List<Wyscig> wyscig = wyscigRepository.findById(wyscigId);
        if(wyscig != null) {
            if(wyscig.size() > 0) {
                if (uczestnicyWysciguRepository.findByNrAndWyscigId(nr, wyscig.get(0)).size() > 0) {
                    uczestnicyWysciguRepository.delete(new UczestnicyWysciguId(nr,wyscig.get(0).getId()));
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

    public ResponseEntity deleteUczestnicyWysciguByWyscigId(Long wyscigId){
        List<Wyscig> wyscig = wyscigRepository.findById(wyscigId);
        if(wyscig != null) {
            if(wyscig.size() > 0) {
                if (uczestnicyWysciguRepository.findByWyscigId(wyscig.get(0)).size() > 0) {
                    uczestnicyWysciguRepository.deleteByWyscigId(wyscig.get(0));
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
