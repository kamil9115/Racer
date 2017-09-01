package pl.edu.wat.wcy.tim.racer.core;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import pl.edu.wat.wcy.tim.racer.dao.*;
import pl.edu.wat.wcy.tim.racer.domain.*;
import pl.edu.wat.wcy.tim.racer.domain.idClass.CzasNaTrasieId;
import pl.edu.wat.wcy.tim.racer.domain.idClass.PojazdyUzytkownikaId;
import pl.edu.wat.wcy.tim.racer.domain.idClass.PunktyTrasyId;

import java.sql.Time;
import java.util.List;

@Service
public class CzasNaTrasieService {
    private CzasNaTrasieRepository czasNaTrasieRepository;
    private PunktyTrasyRepository punktyTrasyRepository;
    private PojazdyUzytkownikaRepository pojazdyUzytkownikaRepository;
    private UzytkownikRepository uzytkownikRepository;
    private TrasaRepository trasaRepository;

    @Autowired
    public CzasNaTrasieService(CzasNaTrasieRepository czasNaTrasieRepository, PunktyTrasyRepository punktyTrasyRepository, PojazdyUzytkownikaRepository pojazdyUzytkownikaRepository, UzytkownikRepository uzytkownikRepository, TrasaRepository trasaRepository) {
        this.czasNaTrasieRepository = czasNaTrasieRepository;
        this.punktyTrasyRepository = punktyTrasyRepository;
        this.pojazdyUzytkownikaRepository = pojazdyUzytkownikaRepository;
        this.uzytkownikRepository = uzytkownikRepository;
        this.trasaRepository = trasaRepository;
    }

    public ResponseEntity<List<CzasNaTrasie>> getCzasNaTrasie(){
        List<CzasNaTrasie> list = null;
        list = czasNaTrasieRepository.findAll();
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

    public ResponseEntity addCzasNaTrasie(int nrPunktu,Long trasaId,int nrPojazdu, Long uzytkownikId, Time czas){
        List<Uzytkownik> uzytkownik = uzytkownikRepository.findById(uzytkownikId);
        if(uzytkownik != null) {
            if(uzytkownik.size() > 0) {
                List<PojazdyUzytkownika> pojazdyUzytk = pojazdyUzytkownikaRepository.findByNrAndUzytkownikId(nrPojazdu,uzytkownik.get(0));
                if(pojazdyUzytk != null) {
                    if (pojazdyUzytk.size() > 0) {
                        List<Trasa> trasa = trasaRepository.findById(trasaId);
                        if (trasa != null) {
                            if (trasa.size() > 0) {
                                List<PunktyTrasy> punktyTrasy = punktyTrasyRepository.findByNrAndTrasaId(nrPunktu,trasa.get(0));
                                if (punktyTrasy != null) {
                                    if (punktyTrasy.size() > 0) {
                                        CzasNaTrasie czasNaTrasie = new CzasNaTrasie(punktyTrasy.get(0),pojazdyUzytk.get(0),czas);
                                        czasNaTrasieRepository.saveAndFlush(czasNaTrasie);
                                        return new ResponseEntity(HttpStatus.CREATED);
                                    } else {
                                        return new ResponseEntity(HttpStatus.NO_CONTENT);
                                    }
                                } else {
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

    public ResponseEntity addCzasNaTrasie(List<CzasNaTrasie> punkty){
        czasNaTrasieRepository.save(punkty);
        return new ResponseEntity(HttpStatus.CREATED);
    }

    public ResponseEntity getCzasNaTrasieById(int nrPunktu,Long trasaId,int nrPojazdu, Long uzytkownikId){
        List<Uzytkownik> uzytkownik = uzytkownikRepository.findById(uzytkownikId);
        if(uzytkownik != null) {
            if(uzytkownik.size() > 0) {
                List<PojazdyUzytkownika> pojazdyUzytk = pojazdyUzytkownikaRepository.findByNrAndUzytkownikId(nrPojazdu,uzytkownik.get(0));
                if(pojazdyUzytk != null) {
                    if (pojazdyUzytk.size() > 0) {
                        List<Trasa> trasa = trasaRepository.findById(trasaId);
                        if (trasa != null) {
                            if (trasa.size() > 0) {
                                List<PunktyTrasy> punktyTrasy = punktyTrasyRepository.findByNrAndTrasaId(nrPunktu,trasa.get(0));
                                if (punktyTrasy != null) {
                                    if (punktyTrasy.size() > 0) {
                                        List<CzasNaTrasie> list = null;
                                        list = czasNaTrasieRepository.findByPunktyTrasyIdAndPojazdyUzytkownikaId(punktyTrasy.get(0),pojazdyUzytk.get(0));
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

    public ResponseEntity getCzasNaTrasieByPojazdyUzytkownikaId(int nrPojazdu, Long uzytkownikId){
        List<Uzytkownik> uzytkownik = uzytkownikRepository.findById(uzytkownikId);
        if(uzytkownik != null) {
            if(uzytkownik.size() > 0) {
                List<PojazdyUzytkownika> pojazdyUzytk = pojazdyUzytkownikaRepository.findByNrAndUzytkownikId(nrPojazdu,uzytkownik.get(0));
                if(pojazdyUzytk != null) {
                    if (pojazdyUzytk.size() > 0) {
                        List<CzasNaTrasie> list = null;
                        list = czasNaTrasieRepository.findByPojazdyUzytkownikaId(pojazdyUzytk.get(0));
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

    public ResponseEntity getCzasNaTrasieByPunktyTrasyId(int nrPunktu,Long trasaId){
        List<Trasa> trasa = trasaRepository.findById(trasaId);
        if (trasa != null) {
            if (trasa.size() > 0) {
                List<PunktyTrasy> punktyTrasy = punktyTrasyRepository.findByNrAndTrasaId(nrPunktu,trasa.get(0));
                if (punktyTrasy != null) {
                    if (punktyTrasy.size() > 0) {
                        List<CzasNaTrasie> list = null;
                        list = czasNaTrasieRepository.findByPunktyTrasyId(punktyTrasy.get(0));
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
        } else {
            return new ResponseEntity(HttpStatus.EXPECTATION_FAILED);
        }
    }

    public ResponseEntity deleteCzasNaTrasie(int nrPunktu,Long trasaId,int nrPojazdu, Long uzytkownikId){
        List<Uzytkownik> uzytkownik = uzytkownikRepository.findById(uzytkownikId);
        if(uzytkownik != null) {
            if(uzytkownik.size() > 0) {
                List<PojazdyUzytkownika> pojazdyUzytk = pojazdyUzytkownikaRepository.findByNrAndUzytkownikId(nrPojazdu,uzytkownik.get(0));
                if(pojazdyUzytk != null) {
                    if (pojazdyUzytk.size() > 0) {
                        List<Trasa> trasa = trasaRepository.findById(trasaId);
                        if (trasa != null) {
                            if (trasa.size() > 0) {
                                List<PunktyTrasy> punktyTrasy = punktyTrasyRepository.findByNrAndTrasaId(nrPunktu,trasa.get(0));
                                if (punktyTrasy != null) {
                                    if (punktyTrasy.size() > 0) {
                                        if (czasNaTrasieRepository.findByPunktyTrasyIdAndPojazdyUzytkownikaId(punktyTrasy.get(0),pojazdyUzytk.get(0)).size() > 0) {
                                            czasNaTrasieRepository.delete(new CzasNaTrasieId(new PunktyTrasyId(nrPunktu,trasa.get(0).getId()),new PojazdyUzytkownikaId(nrPojazdu,uzytkownik.get(0).getId())));
                                            return new ResponseEntity(HttpStatus.OK);
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

    public ResponseEntity deleteCzasNaTrasieByPunktyTrasyId(int nrPunktu,Long trasaId){
        List<Trasa> trasa = trasaRepository.findById(trasaId);
        if (trasa != null) {
            if (trasa.size() > 0) {
                List<PunktyTrasy> punktyTrasy = punktyTrasyRepository.findByNrAndTrasaId(nrPunktu,trasa.get(0));
                if (punktyTrasy != null) {
                    if (punktyTrasy.size() > 0) {
                        if (czasNaTrasieRepository.findByPunktyTrasyId(punktyTrasy.get(0)).size() > 0) {
                            czasNaTrasieRepository.deleteByPunktyTrasyId(punktyTrasy.get(0));
                            return new ResponseEntity(HttpStatus.OK);
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
        } else {
            return new ResponseEntity(HttpStatus.EXPECTATION_FAILED);
        }
    }

    public ResponseEntity deleteCzasNaTrasieByPojazdyUzytkownikaId(int nrPojazdu, Long uzytkownikId){
        List<Uzytkownik> uzytkownik = uzytkownikRepository.findById(uzytkownikId);
        if(uzytkownik != null) {
            if(uzytkownik.size() > 0) {
                List<PojazdyUzytkownika> pojazdyUzytk = pojazdyUzytkownikaRepository.findByNrAndUzytkownikId(nrPojazdu,uzytkownik.get(0));
                if(pojazdyUzytk != null) {
                    if (pojazdyUzytk.size() > 0) {
                        if (czasNaTrasieRepository.findByPojazdyUzytkownikaId(pojazdyUzytk.get(0)).size() > 0) {
                            czasNaTrasieRepository.deleteByPojazdyUzytkownikaId(pojazdyUzytk.get(0));
                            return new ResponseEntity(HttpStatus.OK);
                        } else {
                            return new ResponseEntity(HttpStatus.NO_CONTENT);
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
}
