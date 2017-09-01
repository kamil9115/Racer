package pl.edu.wat.wcy.tim.racer.core;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import pl.edu.wat.wcy.tim.racer.dao.PunktyTrasyRepository;
import pl.edu.wat.wcy.tim.racer.dao.TrasaRepository;
import pl.edu.wat.wcy.tim.racer.domain.PunktyTrasy;
import pl.edu.wat.wcy.tim.racer.domain.Trasa;
import pl.edu.wat.wcy.tim.racer.domain.idClass.PunktyTrasyId;

import java.util.List;

@Service
@Transactional
public class PunktyTrasyService {
    private PunktyTrasyRepository punktyTrasyRepository;
    private TrasaRepository trasaRepository;

    @Autowired
    public PunktyTrasyService(PunktyTrasyRepository punktyTrasyRepository,TrasaRepository trasaRepository){
        this.punktyTrasyRepository = punktyTrasyRepository;
        this.trasaRepository = trasaRepository;
    }

    public ResponseEntity<List<PunktyTrasy>> getPunktyTrasy(){
        List<PunktyTrasy> list = null;
        list = punktyTrasyRepository.findAll();
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

    public ResponseEntity addPunktyTrasy(Long trasaId,double szer,double dlug){
        List<Trasa> trasa = trasaRepository.findById(trasaId);

        if(trasa != null) {
            if(trasa.size() > 0) {
                int nr = punktyTrasyRepository.countByTrasaId(trasa.get(0));
                PunktyTrasy punktyTrasy = new PunktyTrasy(nr,trasa.get(0),szer,dlug);
                punktyTrasyRepository.saveAndFlush(punktyTrasy);
                return new ResponseEntity(HttpStatus.CREATED);
            }else{
                return new ResponseEntity(HttpStatus.NO_CONTENT);
            }
        }else{
            return new ResponseEntity(HttpStatus.EXPECTATION_FAILED);
        }
    }

    public ResponseEntity addPunktyTrasy(List<PunktyTrasy> punkty){
        punktyTrasyRepository.save(punkty);
        return new ResponseEntity(HttpStatus.CREATED);
    }

    public ResponseEntity<List<PunktyTrasy>> getPunktyTrasyById(int nr,Long trasaId){
        List<Trasa> trasa = trasaRepository.findById(trasaId);

        if(trasa != null) {
            if(trasa.size() > 0) {
                List<PunktyTrasy> list = null;
                list = punktyTrasyRepository.findByNrAndTrasaId(nr,trasa.get(0));
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

    public ResponseEntity<List<PunktyTrasy>> getPunktyTrasyByTrasaId(Long trasaId){
        List<Trasa> trasa = trasaRepository.findById(trasaId);

        if(trasa != null) {
            if(trasa.size() > 0) {
                List<PunktyTrasy> list = null;
                list = punktyTrasyRepository.findByTrasaId(trasa.get(0));
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

    public ResponseEntity deletePunktyTrasy(int nr,Long trasaId){
        List<Trasa> trasa = trasaRepository.findById(trasaId);
        if(trasa != null) {
            if(trasa.size() > 0) {
                if (punktyTrasyRepository.findByNrAndTrasaId(nr, trasa.get(0)).size() > 0) {
                    //punktyTrasyRepository.deleteByNrAndTrasaId(nr,trasa.get(0));
                    punktyTrasyRepository.delete(new PunktyTrasyId(nr,trasa.get(0).getId()));
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

    public ResponseEntity deletePunktyTrasyByTrasaId(Long trasaId){
        List<Trasa> trasa = trasaRepository.findById(trasaId);
        if(trasa != null) {
            if(trasa.size() > 0) {
                if (punktyTrasyRepository.findByTrasaId(trasa.get(0)).size() > 0) {
                    punktyTrasyRepository.deleteByTrasaId(trasa.get(0));
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
