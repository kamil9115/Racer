package pl.edu.wat.wcy.tim.racer.api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pl.edu.wat.wcy.tim.racer.core.UzytkownikService;
import pl.edu.wat.wcy.tim.racer.dao.UzytkownikRepository;
import pl.edu.wat.wcy.tim.racer.domain.Uzytkownik;

import java.util.List;

/**
 * Created by Kamil on 25.07.2017.
 */
@RestController
public class UzytkownikRestController {
    private UzytkownikService uzytkownikService;

    @Autowired
    public UzytkownikRestController(UzytkownikService uzytkownikService){
        this.uzytkownikService = uzytkownikService;
    }

    @RequestMapping(value = "/uzytkownik", method = RequestMethod.GET)
    public ResponseEntity<List<Uzytkownik>> getUzytkownik(){
        ResponseEntity<List<Uzytkownik>> response = uzytkownikService.getUzytkownik();
        if(response != null){
            return response;
        }else{
            return new ResponseEntity(HttpStatus.EXPECTATION_FAILED);
        }
    }

    @RequestMapping(value = "/uzytkownik", method = RequestMethod.POST)
    public ResponseEntity addUzytkownik(@RequestParam("nazwa") String nazwa, @RequestParam("haslo") String haslo) {
        ResponseEntity response = uzytkownikService.addUzytkownik(nazwa,haslo);
        if(response != null){
            return response;
        }else{
            return new ResponseEntity(HttpStatus.EXPECTATION_FAILED);
        }
    }

    @RequestMapping(value = "/uzytkownik/nazwa", method = RequestMethod.GET)
    public ResponseEntity<List<Uzytkownik>> getUzytkownikByNazwa(@RequestParam("nazwa") String nazwa) {
        ResponseEntity<List<Uzytkownik>> response = uzytkownikService.getUzytkownikByNazwa(nazwa);
        if(response != null){
            return response;
        }else{
            return new ResponseEntity(HttpStatus.EXPECTATION_FAILED);
        }
    }

    @RequestMapping(value = "/uzytkownik/id", method = RequestMethod.GET)
    public ResponseEntity<List<Uzytkownik>> getUzytkownikById(@RequestParam("id") Long id) {
        ResponseEntity<List<Uzytkownik>> response = uzytkownikService.getUzytkownikById(id);
        if(response != null){
            return response;
        }else{
            return new ResponseEntity(HttpStatus.EXPECTATION_FAILED);
        }
    }

    @RequestMapping(value = "/uzytkownik/administrator", method = RequestMethod.GET)
    public ResponseEntity<List<Uzytkownik>> getUzytkownikByAdministrator(@RequestParam("administrator") boolean administrator) {
        ResponseEntity<List<Uzytkownik>> response = uzytkownikService.getUzytkownikByAdministrator(administrator);
        if(response != null){
            return response;
        }else{
            return new ResponseEntity(HttpStatus.EXPECTATION_FAILED);
        }
    }

    @RequestMapping(value = "/uzytkownik/check", method = RequestMethod.GET)
    public ResponseEntity<Boolean> checkHaslo(@RequestParam("nazwa") String nazwa,@RequestParam("haslo") String haslo) {
        ResponseEntity<Boolean> response = uzytkownikService.checkHaslo(nazwa,haslo);
        if(response != null){
            return response;
        }else{
            return new ResponseEntity(HttpStatus.EXPECTATION_FAILED);
        }
    }

    @RequestMapping(value = "/uzytkownik", method = RequestMethod.DELETE)
    public ResponseEntity deleteUzytkownik(@RequestParam("id") Long id) {
        ResponseEntity response = uzytkownikService.deleteUzytkownik(id);
        if(response != null){
            return response;
        }else{
            return new ResponseEntity(HttpStatus.EXPECTATION_FAILED);
        }
    }
}
