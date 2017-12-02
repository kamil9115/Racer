package pl.edu.wat.wcy.tim.racer.core;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import pl.edu.wat.wcy.tim.racer.dao.PojazdyUzytkownikaRepository;
import pl.edu.wat.wcy.tim.racer.dao.StatystykiTrasyRepository;
import pl.edu.wat.wcy.tim.racer.dao.TrasaRepository;
import pl.edu.wat.wcy.tim.racer.dao.UzytkownikRepository;
import pl.edu.wat.wcy.tim.racer.domain.PojazdyUzytkownika;
import pl.edu.wat.wcy.tim.racer.domain.StatystykiTrasy;
import pl.edu.wat.wcy.tim.racer.domain.Trasa;
import pl.edu.wat.wcy.tim.racer.domain.Uzytkownik;
import pl.edu.wat.wcy.tim.racer.domain.idClass.PojazdyUzytkownikaId;
import pl.edu.wat.wcy.tim.racer.domain.idClass.StatystykiTrasyId;

import java.sql.Time;
import java.util.List;

@Service
public class StatystykiTrasyService {
    private StatystykiTrasyRepository statystykiTrasyRepository;
    private TrasaRepository trasaRepository;
    private PojazdyUzytkownikaRepository pojazdyUzytkownikaRepository;
    private UzytkownikRepository uzytkownikRepository;

    public StatystykiTrasyService(StatystykiTrasyRepository statystykiTrasyRepository, TrasaRepository trasaRepository, PojazdyUzytkownikaRepository pojazdyUzytkownikaRepository, UzytkownikRepository uzytkownikRepository) {
        this.statystykiTrasyRepository = statystykiTrasyRepository;
        this.trasaRepository = trasaRepository;
        this.pojazdyUzytkownikaRepository = pojazdyUzytkownikaRepository;
        this.uzytkownikRepository = uzytkownikRepository;
    }

    @Autowired


    public ResponseEntity<List<StatystykiTrasy>> getStatystykiTrasy(){
        List<StatystykiTrasy> list = null;
        list = statystykiTrasyRepository.findAll();
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

    public ResponseEntity<StatystykiTrasy> addStatystykiTrasy(int nrPojazdu, Long uzytkownikId, Long trasaId, Time czas,int vMax,int vAvg,Time czas_0_100,Time czas_0_vmax,int ocena){
        List<Uzytkownik> uzytkownik = uzytkownikRepository.findById(uzytkownikId);
        if(uzytkownik != null) {
            if(uzytkownik.size() > 0) {
                List<PojazdyUzytkownika> pojazdyUzytk = pojazdyUzytkownikaRepository.findByNrAndUzytkownikId(nrPojazdu,uzytkownik.get(0));
                if(pojazdyUzytk != null) {
                    if (pojazdyUzytk.size() > 0) {
                        List<Trasa> trasa = trasaRepository.findById(trasaId);
                        if (trasa != null) {
                            if (trasa.size() > 0) {
                                StatystykiTrasy statystykiTrasy = new StatystykiTrasy(trasa.get(0),pojazdyUzytk.get(0),czas,vMax,vAvg,czas_0_100,czas_0_vmax,ocena);
                                statystykiTrasyRepository.saveAndFlush(statystykiTrasy);
                                return ResponseEntity.ok(statystykiTrasy);
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

    public ResponseEntity<List<StatystykiTrasy>> getStatystykiTrasyByTrasaId(Long trasaId){
        List<Trasa> trasa = trasaRepository.findById(trasaId);
        if(trasa != null) {
            if(trasa.size() > 0) {
                List<StatystykiTrasy> list = null;
                list = statystykiTrasyRepository.findByTrasaId(trasa.get(0));
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

    public ResponseEntity<List<StatystykiTrasy>> getStatystykiTrasyById(Long trasaId,int nrPojazdu,Long uzytkownikId){
        List<Uzytkownik> uzytkownik = uzytkownikRepository.findById(uzytkownikId);
        if(uzytkownik != null) {
            if(uzytkownik.size() > 0) {
                List<PojazdyUzytkownika> pojazdyUzytk = pojazdyUzytkownikaRepository.findByNrAndUzytkownikId(nrPojazdu,uzytkownik.get(0));
                if(pojazdyUzytk != null) {
                    if (pojazdyUzytk.size() > 0) {
                        List<Trasa> trasa = trasaRepository.findById(trasaId);
                        if (trasa != null) {
                            if (trasa.size() > 0) {
                                List<StatystykiTrasy> list = null;
                                list = statystykiTrasyRepository.findByTrasaIdAndPojazdyUzytkownikaId(trasa.get(0),pojazdyUzytk.get(0));
                                if(list != null){
                                    if(list.size() > 0) {
                                        return ResponseEntity.ok(list);
                                    }else{
                                        return new ResponseEntity(HttpStatus.NO_CONTENT);
                                    }
                                }else{
                                    return new ResponseEntity(HttpStatus.EXPECTATION_FAILED);
                                }
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

    public ResponseEntity<List<StatystykiTrasy>> getStatystykiTrasyByPojazdyUzytkownikaId(int nrPojazdu,Long uzytkownikId){
        List<Uzytkownik> uzytkownik = uzytkownikRepository.findById(uzytkownikId);
        if(uzytkownik != null) {
            if(uzytkownik.size() > 0) {
                List<PojazdyUzytkownika> pojazdyUzytk = pojazdyUzytkownikaRepository.findByNrAndUzytkownikId(nrPojazdu,uzytkownik.get(0));
                if(pojazdyUzytk != null) {
                    if (pojazdyUzytk.size() > 0) {
                        List<StatystykiTrasy> list = null;
                        list = statystykiTrasyRepository.findByPojazdyUzytkownikaId(pojazdyUzytk.get(0));
                        if(list != null){
                            if(list.size() > 0) {
                                return ResponseEntity.ok(list);
                            }else{
                                return new ResponseEntity(HttpStatus.NO_CONTENT);
                            }
                        }else{
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

    public ResponseEntity<List<StatystykiTrasy>> getStatystykiTrasyByOcenaBetween(int min,int max){
        List<StatystykiTrasy> list = null;
        list = statystykiTrasyRepository.findByOcenaBetween(min,max);
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

    public ResponseEntity<StatystykiTrasy> deleteStatystykiTrasy(Long trasaId,int nrPojazdu,Long uzytkownikId){
        List<Uzytkownik> uzytkownik = uzytkownikRepository.findById(uzytkownikId);
        if(uzytkownik != null) {
            if(uzytkownik.size() > 0) {
                List<PojazdyUzytkownika> pojazdyUzytk = pojazdyUzytkownikaRepository.findByNrAndUzytkownikId(nrPojazdu,uzytkownik.get(0));
                if(pojazdyUzytk != null) {
                    if (pojazdyUzytk.size() > 0) {
                        List<Trasa> trasa = trasaRepository.findById(trasaId);
                        if (trasa != null) {
                            if (trasa.size() > 0) {
                                List<StatystykiTrasy> statystykiTrasy = statystykiTrasyRepository.findByTrasaIdAndPojazdyUzytkownikaId(trasa.get(0),pojazdyUzytk.get(0));
                                if (statystykiTrasy != null && statystykiTrasy.size() > 0) {
                                    statystykiTrasyRepository.delete(new StatystykiTrasyId(trasa.get(0).getId(),new PojazdyUzytkownikaId(nrPojazdu,uzytkownik.get(0).getId())));
                                    return ResponseEntity.ok(statystykiTrasy.get(0));
                                } else {
                                    return new ResponseEntity(HttpStatus.NO_CONTENT);
                                }
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

    public ResponseEntity<List<StatystykiTrasy>> deleteStatystykiTrasyByTrasaId(Long trasaId){
        List<Trasa> trasa = trasaRepository.findById(trasaId);
        if(trasa != null) {
            if(trasa.size() > 0) {
                List<StatystykiTrasy> statystykiTrasy = statystykiTrasyRepository.findByTrasaId(trasa.get(0));
                if (statystykiTrasy != null && statystykiTrasy.size() > 0) {
                    statystykiTrasyRepository.deleteByTrasaId(trasa.get(0));
                    return ResponseEntity.ok(statystykiTrasy);
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

    public ResponseEntity<List<StatystykiTrasy>> deleteStatystykiTrasyByPojazdyUzytkownikaId(int nr,long uzytkownikId){
        List<Uzytkownik> uzyt = uzytkownikRepository.findById(uzytkownikId);
        if(uzyt != null){
            if(uzyt.size() > 0){
                List<PojazdyUzytkownika> pojazd = pojazdyUzytkownikaRepository.findByNrAndUzytkownikId(nr,uzyt.get(0));
                if(pojazd != null){
                    if(pojazd.size() > 0){
                        List<StatystykiTrasy> stat = statystykiTrasyRepository.findByPojazdyUzytkownikaId(pojazd.get(0));
                        if(stat != null){
                            if(stat.size() > 0){
                                statystykiTrasyRepository.deleteByPojazdyUzytkownikaId(pojazd.get(0));
                                return ResponseEntity.ok(stat);
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
            }else{
                return new ResponseEntity(HttpStatus.NO_CONTENT);
            }
        }else{
            return new ResponseEntity(HttpStatus.EXPECTATION_FAILED);
        }
    }

    public ResponseEntity<StatystykiTrasy> updateStatystykiTrasy(StatystykiTrasy statystykiTrasy){
        if(statystykiTrasyRepository.exists(new StatystykiTrasyId(statystykiTrasy.getTrasaId().getId(),new PojazdyUzytkownikaId(statystykiTrasy.getPojazdyUzytkownikaId().getNr(),statystykiTrasy.getPojazdyUzytkownikaId().getUzytkownikId().getId())))){
            statystykiTrasyRepository.save(statystykiTrasy);
            return ResponseEntity.ok(statystykiTrasy);
        }else{
            return new ResponseEntity(HttpStatus.NO_CONTENT);
        }
    }

    public ResponseEntity<List<StatystykiTrasy>> getStatystykiTrasyByUzytkownikId(long uzytkownikId){
        List<Uzytkownik> uzytkownik = uzytkownikRepository.findById(uzytkownikId);
        if(uzytkownik != null){
            if(uzytkownik.size() > 0){
                List<StatystykiTrasy> statystyki = statystykiTrasyRepository.findByPojazdyUzytkownikaId_UzytkownikId(uzytkownik.get(0));
                if(statystyki != null){
                    if(statystyki.size() > 0){
                        return ResponseEntity.ok(statystyki);
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

    public ResponseEntity<Float> setOcenaAvg(long trasaId,long uzytkownikId,int ocena){
        List<Uzytkownik> uzytkownik = uzytkownikRepository.findById(uzytkownikId);
        if(uzytkownik != null){
            if(uzytkownik.size() > 0){
                List<Trasa> trasa = trasaRepository.findById(trasaId);
                if(trasa != null) {
                    if(trasa.size() > 0) {
                        statystykiTrasyRepository.updateOcenaByUzytkownikId(trasa.get(0),uzytkownik.get(0),ocena);
                        Float avg = statystykiTrasyRepository.findOcenaAvgByTrasaId(trasa.get(0));
                        if(avg != null){
                            Trasa tras = trasa.get(0);
                            tras.setOcenaAvg(avg);
                            trasaRepository.save(tras);
                            return ResponseEntity.ok(avg);
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
}
