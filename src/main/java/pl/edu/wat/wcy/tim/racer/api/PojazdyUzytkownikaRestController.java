package pl.edu.wat.wcy.tim.racer.api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import pl.edu.wat.wcy.tim.racer.core.PojazdyUzytkownikaService;
import pl.edu.wat.wcy.tim.racer.domain.PojazdyUzytkownika;

import java.util.List;

@RestController
public class PojazdyUzytkownikaRestController {
    private PojazdyUzytkownikaService pojazdyUzytkownikaService;

    @Autowired
    public PojazdyUzytkownikaRestController(PojazdyUzytkownikaService pojazdyUzytkownikaService) {
        this.pojazdyUzytkownikaService = pojazdyUzytkownikaService;
    }

    @RequestMapping(value = "/pojazdy_uzytkownika", method = RequestMethod.GET)
    public ResponseEntity<List<PojazdyUzytkownika>> getPojazdyUzytkownika(){
        ResponseEntity<List<PojazdyUzytkownika>> response = pojazdyUzytkownikaService.getPojazdyUzytkownika();
        if(response != null){
            return response;
        }else{
            return new ResponseEntity(HttpStatus.EXPECTATION_FAILED);
        }
    }

    @RequestMapping(value = "/pojazdy_uzytkownika", method = RequestMethod.POST)
    public ResponseEntity addPojazdyUzytkownika(@RequestParam("uzytkownikId") Long uzytkownikId, @RequestParam("pojazdId") Long pojazdId, @RequestParam("nazwa") String nazwa,String opis) {
        ResponseEntity response = pojazdyUzytkownikaService.addPojazdyUzytkownika(uzytkownikId,pojazdId,nazwa,opis);
        if(response != null){
            return response;
        }else{
            return new ResponseEntity(HttpStatus.EXPECTATION_FAILED);
        }
    }

    @RequestMapping(value = "/pojazdy_uzytkownika/id", method = RequestMethod.GET)
    public ResponseEntity<List<PojazdyUzytkownika>> getPojazdyUzytkownikaById(@RequestParam("nr") int nr,@RequestParam("uzytkownikId") Long uzytkownikId) {
        ResponseEntity<List<PojazdyUzytkownika>> response = pojazdyUzytkownikaService.getPojazdyUzytkownikaById(nr,uzytkownikId);
        if(response != null){
            return response;
        }else{
            return new ResponseEntity(HttpStatus.EXPECTATION_FAILED);
        }
    }

    @RequestMapping(value = "/pojazdy_uzytkownika/uzytkownikId", method = RequestMethod.GET)
    public ResponseEntity<List<PojazdyUzytkownika>> getPojazdyUzytkownikaByUzytkownikId(@RequestParam("uzytkownikId") Long uzytkownikId) {
        ResponseEntity<List<PojazdyUzytkownika>> response = pojazdyUzytkownikaService.getPojazdyUzytkownikaByUzytkownikId(uzytkownikId);
        if(response != null){
            return response;
        }else{
            return new ResponseEntity(HttpStatus.EXPECTATION_FAILED);
        }
    }

    @RequestMapping(value = "/pojazdy_uzytkownika/nazwa", method = RequestMethod.GET)
    public ResponseEntity<List<PojazdyUzytkownika>> getPojazdyUzytkownikaByNazwa(@RequestParam("nazwa") String nazwa) {
        ResponseEntity<List<PojazdyUzytkownika>> response = pojazdyUzytkownikaService.getPojazdyUzytkownikaByNazwa(nazwa);
        if(response != null){
            return response;
        }else{
            return new ResponseEntity(HttpStatus.EXPECTATION_FAILED);
        }
    }

    @RequestMapping(value = "/pojazdy_uzytkownika", method = RequestMethod.DELETE)
    public ResponseEntity deletePojazdyUzytkownika(@RequestParam("nr") int nr,@RequestParam("uzytkownikId") Long uzytkownikId) {
        ResponseEntity response = pojazdyUzytkownikaService.deletePojazdyUzytkownika(nr,uzytkownikId);
        if(response != null){
            return response;
        }else{
            return new ResponseEntity(HttpStatus.EXPECTATION_FAILED);
        }
    }

    @RequestMapping(value = "/pojazdy_uzytkownika/uzytkownikId", method = RequestMethod.DELETE)
    public ResponseEntity deletePojazdyUzytkownika(@RequestParam("uzytkownikId") Long uzytkownikId) {
        ResponseEntity response = pojazdyUzytkownikaService.deletePojazdyUzytkownikaByUzytkownikId(uzytkownikId);
        if(response != null){
            return response;
        }else{
            return new ResponseEntity(HttpStatus.EXPECTATION_FAILED);
        }
    }
}
