package pl.edu.wat.wcy.tim.racer.core;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import pl.edu.wat.wcy.tim.racer.dao.UzytkownikRepository;
import pl.edu.wat.wcy.tim.racer.domain.Trasa;
import pl.edu.wat.wcy.tim.racer.domain.UczestnicyWyscigu;
import pl.edu.wat.wcy.tim.racer.domain.Uzytkownik;
import pl.edu.wat.wcy.tim.racer.domain.Wyscig;

import java.util.List;

/**
 * Created by Kamil on 25.07.2017.
 */
@Service
@Transactional
public class UzytkownikService {
    private UzytkownikRepository uzytkownikRepository;
    private WyscigService wyscigService;
    private TrasaService trasaService;
    private UczestnicyWysciguService uczestnicyWysciguService;
    private PojazdyUzytkownikaService pojazdyUzytkownikaService;

    @Autowired
    public UzytkownikService(UzytkownikRepository uzytkownikRepository, WyscigService wyscigService, TrasaService trasaService, UczestnicyWysciguService uczestnicyWysciguService,PojazdyUzytkownikaService pojazdyUzytkownikaService){
        this.uzytkownikRepository = uzytkownikRepository;
        this.wyscigService = wyscigService;
        this.trasaService = trasaService;
        this.uczestnicyWysciguService = uczestnicyWysciguService;
        this.pojazdyUzytkownikaService = pojazdyUzytkownikaService;
    }

    public ResponseEntity<List<Uzytkownik>> getUzytkownik() {
        List<Uzytkownik> list = null;
        list = uzytkownikRepository.findAll();
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

    public ResponseEntity<Uzytkownik> addUzytkownik(String nazwa,String haslo){
        Uzytkownik uzytkownik = new Uzytkownik(nazwa,haslo);
        uzytkownikRepository.saveAndFlush(uzytkownik);
        return ResponseEntity.ok(uzytkownik);
    }

    public ResponseEntity<List<Uzytkownik>> getUzytkownikByNazwa(String nazwa){
        List<Uzytkownik> list = null;
        list = uzytkownikRepository.findByNazwa(nazwa);
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

    public ResponseEntity<List<Uzytkownik>> getUzytkownikById(Long id) {
        List<Uzytkownik> list = null;
        list = uzytkownikRepository.findById(id);
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

    public ResponseEntity<List<Uzytkownik>> getUzytkownikByAdministrator(boolean administrator) {
        List<Uzytkownik> list = null;
        list = uzytkownikRepository.findByAdministrator(administrator);
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

    public ResponseEntity<Boolean> checkHaslo(String nazwa,String haslo){
        List<Uzytkownik> list = null;
        list = uzytkownikRepository.findByNazwa(nazwa);
        if(list != null){
            if(list.size() > 0) {
                String response = list.get(0).getHaslo().trim();
                return ResponseEntity.ok(haslo.equals(response));
            }else{
                return new ResponseEntity(HttpStatus.NO_CONTENT);
            }
        }else{
            return new ResponseEntity(HttpStatus.EXPECTATION_FAILED);
        }
    }

    public ResponseEntity<Uzytkownik> deleteUzytkownik(Long id){
        List<Uzytkownik> uzytkownik = uzytkownikRepository.findById(id);
        if(uzytkownik != null){
            if(uzytkownik.size() > 0) {
                pojazdyUzytkownikaService.deletePojazdyUzytkownikaByUzytkownikId(id);
                uczestnicyWysciguService.deleteUczestnicyWysciguByUzytkownikId(id);
                ResponseEntity<List<Wyscig>> wyscig = wyscigService.getWyscigByUzytkownikId(id);
                if(wyscig.getBody() != null){
                    if(wyscig.getBody().size() > 0){
                        List<Wyscig> wysc = wyscig.getBody();
                        for(int i=0;i<wyscig.getBody().size();i++){
                            ResponseEntity<List<UczestnicyWyscigu>> ucz = uczestnicyWysciguService.getUczestnicyWysciguByWyscigId(wysc.get(i).getId());
                            if(ucz.getBody() != null){
                                if(ucz.getBody().size() > 0){
                                    Uzytkownik uzyt = null;
                                    List<UczestnicyWyscigu> uczes = ucz.getBody();
                                    for(int j=0;j<uczes.size();j++){
                                        if(uczes.get(j).getUzytkownikId().getId() != wysc.get(i).getUzytkownikId().getId()){
                                            uzyt = uczes.get(j).getUzytkownikId();
                                            break;
                                        }
                                    }
                                    if(uzyt != null){
                                        wysc.get(i).setUzytkownikId(uzyt);
                                        wyscigService.updateWyscig(wysc.get(i));
                                    }else{
                                        wyscigService.deleteWyscig(wysc.get(i).getId());
                                    }
                                }else{
                                    wyscigService.deleteWyscig(wysc.get(i).getId());
                                }
                            }
                        }
                    }
                }
                ResponseEntity<List<Trasa>> trasa = trasaService.getTrasaByUzytkownikId(id);
                if(trasa.getBody() != null){
                    if(trasa.getBody().size() > 0){
                        List<Trasa> tra = trasa.getBody();
                        for(int i=0;i<tra.size();i++){
                            tra.get(i).setUzytkownikId(null);
                            trasaService.updateTrasa(tra.get(i));
                        }
                    }
                }

                uzytkownikRepository.delete(id);
                return ResponseEntity.ok(uzytkownik.get(0));
            }else{
                return new ResponseEntity(HttpStatus.NO_CONTENT);
            }
        }else{
            return new ResponseEntity(HttpStatus.EXPECTATION_FAILED);
        }
    }

    public ResponseEntity<Uzytkownik> updateUzytkownik(Uzytkownik uzytkownik){
        if(uzytkownikRepository.exists(uzytkownik.getId())){
            uzytkownikRepository.save(uzytkownik);
            return ResponseEntity.ok(uzytkownik);
        }else{
            return new ResponseEntity(HttpStatus.NO_CONTENT);
        }
    }
}
