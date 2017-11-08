package pl.edu.wat.wcy.tim.racer.api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pl.edu.wat.wcy.tim.racer.core.CzasNaTrasieService;
import pl.edu.wat.wcy.tim.racer.domain.CzasNaTrasie;

import java.sql.Time;
import java.util.List;

@RestController
public class CzasNaTrasieRestController {
    private CzasNaTrasieService czasNaTrasieService;

    @Autowired
    public CzasNaTrasieRestController(CzasNaTrasieService czasNaTrasieService) {
        this.czasNaTrasieService = czasNaTrasieService;
    }

    @RequestMapping(value = "/czas_na_trasie", method = RequestMethod.GET)
    public ResponseEntity<List<CzasNaTrasie>> getCzasNaTrasie(){
        ResponseEntity<List<CzasNaTrasie>> response = czasNaTrasieService.getCzasNaTrasie();
        if(response != null){
            return response;
        }else{
            return new ResponseEntity(HttpStatus.EXPECTATION_FAILED);
        }
    }

    @RequestMapping(value = "/czas_na_trasie", method = RequestMethod.POST)
    public ResponseEntity addCzasNaTrasie(@RequestParam("nrPunktu") int nrPunktu,@RequestParam("trasaId") Long trasaId,@RequestParam("nrPojazdu") int nrPojazdu, @RequestParam("uzytkownikId") Long uzytkownikId, @RequestParam("czas")Time czas) {
        ResponseEntity response = czasNaTrasieService.addCzasNaTrasie(nrPunktu,trasaId,nrPojazdu,uzytkownikId,czas);
        if(response != null){
            return response;
        }else{
            return new ResponseEntity(HttpStatus.EXPECTATION_FAILED);
        }
    }

    @RequestMapping(value = "/czas_na_trasie/all", method = RequestMethod.POST)
    public ResponseEntity<CzasNaTrasie> addCzasNaTrasieAll(@RequestBody List<CzasNaTrasie> punkty) {
        ResponseEntity<CzasNaTrasie> response = czasNaTrasieService.addCzasNaTrasie(punkty);
        if(response != null){
            return response;
        }else{
            return new ResponseEntity(HttpStatus.EXPECTATION_FAILED);
        }
    }

    @RequestMapping(value = "/czas_na_trasie/id", method = RequestMethod.GET)
    public ResponseEntity<List<CzasNaTrasie>> getCzasNaTrasieById(@RequestParam("nrPunktu") int nrPunktu,@RequestParam("trasaId") Long trasaId,@RequestParam("nrPojazdu") int nrPojazdu, @RequestParam("uzytkownikId") Long uzytkownikId) {
        ResponseEntity<List<CzasNaTrasie>> response = czasNaTrasieService.getCzasNaTrasieById(nrPunktu,trasaId,nrPojazdu,uzytkownikId);
        if(response != null){
            return response;
        }else{
            return new ResponseEntity(HttpStatus.EXPECTATION_FAILED);
        }
    }

    @RequestMapping(value = "/czas_na_trasie/pojazdyUzytkownikaId", method = RequestMethod.GET)
    public ResponseEntity<List<CzasNaTrasie>> getCzasNaTrasieById(@RequestParam("nrPojazdu") int nrPojazdu, @RequestParam("uzytkownikId") Long uzytkownikId) {
        ResponseEntity<List<CzasNaTrasie>> response = czasNaTrasieService.getCzasNaTrasieByPojazdyUzytkownikaId(nrPojazdu,uzytkownikId);
        if(response != null){
            return response;
        }else{
            return new ResponseEntity(HttpStatus.EXPECTATION_FAILED);
        }
    }

    @RequestMapping(value = "/czas_na_trasie/punktyTrasyId", method = RequestMethod.GET)
    public ResponseEntity<List<CzasNaTrasie>> getCzasNaTrasieByPunktyTrasyId(@RequestParam("nrPunktu") int nrPunktu,@RequestParam("trasaId") Long trasaId) {
        ResponseEntity<List<CzasNaTrasie>> response = czasNaTrasieService.getCzasNaTrasieByPunktyTrasyId(nrPunktu,trasaId);
        if(response != null){
            return response;
        }else{
            return new ResponseEntity(HttpStatus.EXPECTATION_FAILED);
        }
    }

    @RequestMapping(value = "/czas_na_trasie", method = RequestMethod.DELETE)
    public ResponseEntity<CzasNaTrasie> deleteCzasNaTrasie(@RequestParam("nrPunktu") int nrPunktu,@RequestParam("trasaId") Long trasaId,@RequestParam("nrPojazdu") int nrPojazdu, @RequestParam("uzytkownikId") Long uzytkownikId) {
        ResponseEntity<CzasNaTrasie> response = czasNaTrasieService.deleteCzasNaTrasie(nrPunktu,trasaId,nrPojazdu,uzytkownikId);
        if(response != null){
            return response;
        }else{
            return new ResponseEntity(HttpStatus.EXPECTATION_FAILED);
        }
    }

    @RequestMapping(value = "/czas_na_trasie/punktyTrasyId", method = RequestMethod.DELETE)
    public ResponseEntity<List<CzasNaTrasie>> deleteCzasNaTrasieByPunktyTrasyId(@RequestParam("nrPunktu") int nrPunktu,@RequestParam("trasaId") Long trasaId) {
        ResponseEntity<List<CzasNaTrasie>> response = czasNaTrasieService.deleteCzasNaTrasieByPunktyTrasyId(nrPunktu,trasaId);
        if(response != null){
            return response;
        }else{
            return new ResponseEntity(HttpStatus.EXPECTATION_FAILED);
        }
    }

    @RequestMapping(value = "/czas_na_trasie/pojazdyUzytkownikaId", method = RequestMethod.DELETE)
    public ResponseEntity<List<CzasNaTrasie>> deleteCzasNaTrasieByPojazdyUzytkownikaId(@RequestParam("nrPojazdu") int nrPojazdu, @RequestParam("uzytkownikId") Long uzytkownikId) {
        ResponseEntity<List<CzasNaTrasie>> response = czasNaTrasieService.deleteCzasNaTrasieByPojazdyUzytkownikaId(nrPojazdu,uzytkownikId);
        if(response != null){
            return response;
        }else{
            return new ResponseEntity(HttpStatus.EXPECTATION_FAILED);
        }
    }

    @RequestMapping(value = "/czas_na_trasie", method = RequestMethod.PUT)
    public ResponseEntity<CzasNaTrasie> updateCzasNaTrasie(@RequestBody CzasNaTrasie czasNaTrasie){
        ResponseEntity<CzasNaTrasie> response = czasNaTrasieService.updateCzasNaTrasie(czasNaTrasie);
        if(response != null){
            return response;
        }else{
            return new ResponseEntity(HttpStatus.EXPECTATION_FAILED);
        }
    }
}
