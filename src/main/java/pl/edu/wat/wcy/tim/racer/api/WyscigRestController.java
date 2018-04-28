package pl.edu.wat.wcy.tim.racer.api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pl.edu.wat.wcy.tim.racer.core.WyscigService;
import pl.edu.wat.wcy.tim.racer.domain.Wyscig;

import java.util.Date;
import java.util.List;

@RestController
public class WyscigRestController {
    private WyscigService wyscigService;

    @Autowired
    public WyscigRestController(WyscigService wyscigService){
        this.wyscigService = wyscigService;
    }

    @RequestMapping(value = "/wyscig", method = RequestMethod.GET)
    public ResponseEntity<List<Wyscig>> getWyscig(){
        ResponseEntity<List<Wyscig>> response = wyscigService.getWyscig();
        if(response != null){
            return response;
        }else{
            return new ResponseEntity(HttpStatus.EXPECTATION_FAILED);
        }
    }

    @RequestMapping(value = "/wyscig", method = RequestMethod.POST)
    public ResponseEntity<Wyscig> addWyscig(@RequestParam("uzytkownikId") Long uzytkownikId, @RequestParam("trasaId") Long trasaId, @RequestParam("nazwa") String nazwa, @RequestParam("opis") String opis, @RequestParam("typ") String typ, @RequestParam("data") Long data) {
        ResponseEntity<Wyscig> response = wyscigService.addWyscig(uzytkownikId,trasaId,nazwa,opis,typ,data);
        if(response != null){
            return response;
        }else{
            return new ResponseEntity(HttpStatus.EXPECTATION_FAILED);
        }
    }

    @RequestMapping(value = "/wyscig/id", method = RequestMethod.GET)
    public ResponseEntity<List<Wyscig>> getWyscigById(@RequestParam("id") Long id) {
        ResponseEntity<List<Wyscig>> response = wyscigService.getWyscigById(id);
        if(response != null){
            return response;
        }else{
            return new ResponseEntity(HttpStatus.EXPECTATION_FAILED);
        }
    }

    @RequestMapping(value = "/wyscig/nazwa", method = RequestMethod.GET)
    public ResponseEntity<List<Wyscig>> getWyscigByNazwa(@RequestParam("nazwa") String nazwa) {
        ResponseEntity<List<Wyscig>> response = wyscigService.getWyscigByNazwa(nazwa);
        if(response != null){
            return response;
        }else{
            return new ResponseEntity(HttpStatus.EXPECTATION_FAILED);
        }
    }

    @RequestMapping(value = "/wyscig/typ", method = RequestMethod.GET)
    public ResponseEntity<List<Wyscig>> getWyscigByTyp(@RequestParam("typ") String typ) {
        ResponseEntity<List<Wyscig>> response = wyscigService.getWyscigByTyp(typ);
        if(response != null){
            return response;
        }else{
            return new ResponseEntity(HttpStatus.EXPECTATION_FAILED);
        }
    }

    @RequestMapping(value = "/wyscig/uzytkownikId", method = RequestMethod.GET)
    public ResponseEntity<List<Wyscig>> getWyscigByUzytkownikId(@RequestParam("uzytkownikId") Long uzytkownikId) {
        ResponseEntity<List<Wyscig>> response = wyscigService.getWyscigByUzytkownikId(uzytkownikId);
        if(response != null){
            return response;
        }else{
            return new ResponseEntity(HttpStatus.EXPECTATION_FAILED);
        }
    }

    @RequestMapping(value = "/wyscig/trasaId", method = RequestMethod.GET)
    public ResponseEntity<List<Wyscig>> getWyscigByTrasaId(@RequestParam("trasaId") Long trasaId) {
        ResponseEntity<List<Wyscig>> response = wyscigService.getWyscigByTrasaId(trasaId);
        if(response != null){
            return response;
        }else{
            return new ResponseEntity(HttpStatus.EXPECTATION_FAILED);
        }
    }

    @RequestMapping(value = "/wyscig/data", method = RequestMethod.GET)
    public ResponseEntity<List<Wyscig>> getWyscigByDataBetween(@RequestParam("min") Date min,@RequestParam("max") Date max) {
        ResponseEntity<List<Wyscig>> response = wyscigService.getWyscigByDataBetween(min,max);
        if(response != null){
            return response;
        }else{
            return new ResponseEntity(HttpStatus.EXPECTATION_FAILED);
        }
    }

    @RequestMapping(value = "/wyscig/nazwa_like", method = RequestMethod.GET)
    public ResponseEntity<List<Wyscig>> getWyscigByNazwaLike(@RequestParam("nazwa") String nazwa) {
        ResponseEntity<List<Wyscig>> response = wyscigService.getWyscigByNazwaLike(nazwa);
        if(response != null){
            return response;
        }else{
            return new ResponseEntity(HttpStatus.EXPECTATION_FAILED);
        }
    }

    @RequestMapping(value = "/wyscig", method = RequestMethod.DELETE)
    public ResponseEntity<Wyscig> deleteTrasa(@RequestParam("id") Long id) {
        ResponseEntity<Wyscig> response = wyscigService.deleteWyscig(id);
        if(response != null){
            return response;
        }else{
            return new ResponseEntity(HttpStatus.EXPECTATION_FAILED);
        }
    }

    @RequestMapping(value = "/wyscig/trasaId", method = RequestMethod.DELETE)
    public ResponseEntity<List<Wyscig>> deleteTrasaByTrasaId(@RequestParam("trasaId") Long trasaId) {
        ResponseEntity<List<Wyscig>> response = wyscigService.deleteWyscigByTrasaId(trasaId);
        if(response != null){
            return response;
        }else{
            return new ResponseEntity(HttpStatus.EXPECTATION_FAILED);
        }
    }

    @RequestMapping(value = "/wyscig", method = RequestMethod.PUT)
    public ResponseEntity<Wyscig> updateWyscig(@RequestBody Wyscig wyscig){
        ResponseEntity<Wyscig> response = wyscigService.updateWyscig(wyscig);
        if(response != null){
            return response;
        }else{
            return new ResponseEntity(HttpStatus.EXPECTATION_FAILED);
        }
    }
}
