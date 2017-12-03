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
    private CzasNaTrasieService czasNaTrasieService;

    @Autowired
    public PunktyTrasyService(PunktyTrasyRepository punktyTrasyRepository,TrasaRepository trasaRepository, CzasNaTrasieService czasNaTrasieService){
        this.punktyTrasyRepository = punktyTrasyRepository;
        this.trasaRepository = trasaRepository;
        this.czasNaTrasieService = czasNaTrasieService;
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

    public ResponseEntity<PunktyTrasy> addPunktyTrasy(Long trasaId,double szer,double dlug){
        List<Trasa> trasa = trasaRepository.findById(trasaId);

        if(trasa != null) {
            if(trasa.size() > 0) {
                int nr = 0;
                List<PunktyTrasy> punkty = punktyTrasyRepository.findByTrasaId(trasa.get(0));
                if(punkty != null){
                    if(punkty.size() > 0){
                        nr = punkty.get(0).getNr();
                        for(int i=1;i<punkty.size();i++){
                            if(nr < punkty.get(i).getNr()){
                                nr = punkty.get(i).getNr();
                            }
                        }
                        nr++;
                    }
                    PunktyTrasy punktyTrasy = new PunktyTrasy(nr,trasa.get(0),szer,dlug);
                    punktyTrasyRepository.saveAndFlush(punktyTrasy);
                    return ResponseEntity.ok(punktyTrasy);
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

    public ResponseEntity<List<PunktyTrasy>> addPunktyTrasy(List<PunktyTrasy> punkty){
        punktyTrasyRepository.save(punkty);
        return ResponseEntity.ok(punkty);
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

    public ResponseEntity<PunktyTrasy> deletePunktyTrasy(int nr,Long trasaId){
        List<Trasa> trasa = trasaRepository.findById(trasaId);
        if(trasa != null) {
            if(trasa.size() > 0) {
                List<PunktyTrasy> punktyTrasy = punktyTrasyRepository.findByNrAndTrasaId(nr, trasa.get(0));
                if (punktyTrasy != null && punktyTrasy.size() > 0) {
                    czasNaTrasieService.deleteCzasNaTrasieByPunktyTrasyId(nr,trasaId);
                    punktyTrasyRepository.delete(new PunktyTrasyId(nr,trasa.get(0).getId()));
                    return ResponseEntity.ok(punktyTrasy.get(0));
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

    public ResponseEntity<List<PunktyTrasy>> deletePunktyTrasyByTrasaId(Long trasaId){
        List<Trasa> trasa = trasaRepository.findById(trasaId);
        if(trasa != null) {
            if(trasa.size() > 0) {
                List<PunktyTrasy> punktyTrasy = punktyTrasyRepository.findByTrasaId(trasa.get(0));
                if (punktyTrasy != null && punktyTrasy.size() > 0) {
                    for(int i=0;i<punktyTrasy.size();i++){
                        czasNaTrasieService.deleteCzasNaTrasieByPunktyTrasyId(punktyTrasy.get(i).getNr(),trasaId);
                    }
                    punktyTrasyRepository.deleteByTrasaId(trasa.get(0));
                    return ResponseEntity.ok(punktyTrasy);
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

    public ResponseEntity<PunktyTrasy> updatePunktyTrasy(PunktyTrasy punktyTrasy){
        if(punktyTrasyRepository.exists(new PunktyTrasyId(punktyTrasy.getNr(),punktyTrasy.getTrasaId().getId()))){
            punktyTrasyRepository.save(punktyTrasy);
            return ResponseEntity.ok(punktyTrasy);
        }else{
            return new ResponseEntity(HttpStatus.NO_CONTENT);
        }
    }
}
