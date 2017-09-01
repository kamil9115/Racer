package pl.edu.wat.wcy.tim.racer.api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import pl.edu.wat.wcy.tim.racer.core.TrasaService;
import pl.edu.wat.wcy.tim.racer.domain.Trasa;

import java.util.List;

@RestController
public class TrasaRestController {
    private TrasaService trasaService;

    @Autowired
    public TrasaRestController(TrasaService trasaService){
        this.trasaService = trasaService;
    }

    @RequestMapping(value = "/trasa", method = RequestMethod.GET)
    public ResponseEntity<List<Trasa>> getTrasa(){
        ResponseEntity<List<Trasa>> response = trasaService.getTrasa();
        if(response != null){
            return response;
        }else{
            return new ResponseEntity(HttpStatus.EXPECTATION_FAILED);
        }
    }

    @RequestMapping(value = "/trasa", method = RequestMethod.POST)
    public ResponseEntity addTrasa(@RequestParam("uzytkownikId") Long uzytkownikId, @RequestParam("nazwa") String nazwa, @RequestParam("opis") String opis) {
        ResponseEntity response = trasaService.addTrasa(uzytkownikId,nazwa,opis);
        if(response != null){
            return response;
        }else{
            return new ResponseEntity(HttpStatus.EXPECTATION_FAILED);
        }
    }

    @RequestMapping(value = "/trasa/id", method = RequestMethod.GET)
    public ResponseEntity<List<Trasa>> getTrasaById(@RequestParam("id") Long id) {
        ResponseEntity<List<Trasa>> response = trasaService.getTrasaById(id);
        if(response != null){
            return response;
        }else{
            return new ResponseEntity(HttpStatus.EXPECTATION_FAILED);
        }
    }

    @RequestMapping(value = "/trasa/nazwa", method = RequestMethod.GET)
    public ResponseEntity<List<Trasa>> getTrasaByNazwa(@RequestParam("nazwa") String nazwa) {
        ResponseEntity<List<Trasa>> response = trasaService.getTrasaByNazwa(nazwa);
        if(response != null){
            return response;
        }else{
            return new ResponseEntity(HttpStatus.EXPECTATION_FAILED);
        }
    }

    @RequestMapping(value = "/trasa/uzytkownikId", method = RequestMethod.GET)
    public ResponseEntity<List<Trasa>> getTrasaByUzytkownikId(@RequestParam("uzytkownikId") Long uzytkownikId) {
        ResponseEntity<List<Trasa>> response = trasaService.getTrasaByUzytkownikId(uzytkownikId);
        if(response != null){
            return response;
        }else{
            return new ResponseEntity(HttpStatus.EXPECTATION_FAILED);
        }
    }

    @RequestMapping(value = "/trasa/ocenaAvg", method = RequestMethod.GET)
    public ResponseEntity<List<Trasa>> getTrasaByOcenaAvgBetween(@RequestParam("min") float min,@RequestParam("max") float max) {
        ResponseEntity<List<Trasa>> response = trasaService.getTrasaByOcenaAvgBetween(min,max);
        if(response != null){
            return response;
        }else{
            return new ResponseEntity(HttpStatus.EXPECTATION_FAILED);
        }
    }

    @RequestMapping(value = "/trasa/nazwa_like", method = RequestMethod.GET)
    public ResponseEntity<List<Trasa>> getTrasaByNazwaLike(@RequestParam("nazwa") String nazwa) {
        ResponseEntity<List<Trasa>> response = trasaService.getTrasaByNazwaLike(nazwa);
        if(response != null){
            return response;
        }else{
            return new ResponseEntity(HttpStatus.EXPECTATION_FAILED);
        }
    }

    @RequestMapping(value = "/trasa", method = RequestMethod.DELETE)
    public ResponseEntity deleteTrasa(@RequestParam("id") Long id) {
        ResponseEntity response = trasaService.deleteTrasa(id);
        if(response != null){
            return response;
        }else{
            return new ResponseEntity(HttpStatus.EXPECTATION_FAILED);
        }
    }
}
