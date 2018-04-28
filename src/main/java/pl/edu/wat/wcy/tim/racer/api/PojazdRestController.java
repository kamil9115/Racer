package pl.edu.wat.wcy.tim.racer.api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.Query;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pl.edu.wat.wcy.tim.racer.core.PojazdService;
import pl.edu.wat.wcy.tim.racer.domain.Pojazd;

import java.util.List;

@RestController
public class PojazdRestController {
    private PojazdService pojazdService;

    @Autowired
    public PojazdRestController(PojazdService pojazdService){
        this.pojazdService = pojazdService;
    }

    @RequestMapping(value = "/pojazd", method = RequestMethod.GET)
    public ResponseEntity<List<Pojazd>> getPojazd(){
        ResponseEntity<List<Pojazd>> response = pojazdService.getPojazd();
        if(response != null){
            return response;
        }else{
            return new ResponseEntity(HttpStatus.EXPECTATION_FAILED);
        }
    }

    @RequestMapping(value = "/pojazd", method = RequestMethod.POST)
    public ResponseEntity<Pojazd> addPojazd(@RequestParam("marka") String marka, @RequestParam("model") String model,@RequestParam("typ") String typ,@RequestParam("pojemnosc") int pojemnosc,@RequestParam("moc") float moc) {
        ResponseEntity<Pojazd> response = pojazdService.addPojazd(marka,model,typ,pojemnosc,moc);
        if(response != null){
            return response;
        }else{
            return new ResponseEntity(HttpStatus.EXPECTATION_FAILED);
        }
    }

    @RequestMapping(value = "/pojazd/id", method = RequestMethod.GET)
    public ResponseEntity<List<Pojazd>> getPojazdById(@RequestParam("id") Long id) {
        ResponseEntity<List<Pojazd>> response = pojazdService.getPojazdById(id);
        if(response != null){
            return response;
        }else{
            return new ResponseEntity(HttpStatus.EXPECTATION_FAILED);
        }
    }

    @RequestMapping(value = "/pojazd/marka", method = RequestMethod.GET)
    public ResponseEntity<List<Pojazd>> getPojazdByMarka(@RequestParam("marka") String marka) {
        ResponseEntity<List<Pojazd>> response = pojazdService.getPojazdByMarka(marka);
        if(response != null){
            return response;
        }else{
            return new ResponseEntity(HttpStatus.EXPECTATION_FAILED);
        }
    }

    @RequestMapping(value = "/pojazd/model", method = RequestMethod.GET)
    public ResponseEntity<List<Pojazd>> getPojazdByModel(@RequestParam("model") String model) {
        ResponseEntity<List<Pojazd>> response = pojazdService.getPojazdByModel(model);
        if(response != null){
            return response;
        }else{
            return new ResponseEntity(HttpStatus.EXPECTATION_FAILED);
        }
    }

    @RequestMapping(value = "/pojazd/typ", method = RequestMethod.GET)
    public ResponseEntity<List<Pojazd>> getPojazdByTyp(@RequestParam("typ") String typ) {
        ResponseEntity<List<Pojazd>> response = pojazdService.getPojazdByTyp(typ);
        if(response != null){
            return response;
        }else{
            return new ResponseEntity(HttpStatus.EXPECTATION_FAILED);
        }
    }

    @RequestMapping(value = "/pojazd/pojemnosc", method = RequestMethod.GET)
    public ResponseEntity<List<Pojazd>> getPojazdByPojemnoscBetween(@RequestParam("min") int min,@RequestParam("max") int max) {
        ResponseEntity<List<Pojazd>> response = pojazdService.getPojazdByPojemnoscBetween(min,max);
        if(response != null){
            return response;
        }else{
            return new ResponseEntity(HttpStatus.EXPECTATION_FAILED);
        }
    }

    @RequestMapping(value = "/pojazd/moc", method = RequestMethod.GET)
    public ResponseEntity<List<Pojazd>> getPojazdByMocBetween(@RequestParam("min") float min,@RequestParam("max") float max) {
        ResponseEntity<List<Pojazd>> response = pojazdService.getPojazdByMocBetween(min,max);
        if(response != null){
            return response;
        }else{
            return new ResponseEntity(HttpStatus.EXPECTATION_FAILED);
        }
    }

    @RequestMapping(value = "/pojazd/marka_model", method = RequestMethod.GET)
    public ResponseEntity<List<Pojazd>> getPojazdByMarkaAndModel(@RequestParam("marka") String marka,@RequestParam("model") String model) {
        ResponseEntity<List<Pojazd>> response = pojazdService.getPojazdByMarkaAndModel(marka,model);
        if(response != null){
            return response;
        }else{
            return new ResponseEntity(HttpStatus.EXPECTATION_FAILED);
        }
    }

    @RequestMapping(value = "/pojazd/marka_typ", method = RequestMethod.GET)
    public ResponseEntity<List<Pojazd>> getPojazdByMarkaAndTyp(@RequestParam("marka") String marka,@RequestParam("typ") String typ) {
        ResponseEntity<List<Pojazd>> response = pojazdService.getPojazdByMarkaAndTyp(marka,typ);
        if(response != null){
            return response;
        }else{
            return new ResponseEntity(HttpStatus.EXPECTATION_FAILED);
        }
    }

    @RequestMapping(value = "/pojazd/marka_model_like", method = RequestMethod.GET)
    public ResponseEntity<List<Pojazd>> getPojazdByMarkaAndModelLike(@RequestParam("marka") String marka,@RequestParam("model") String model) {
        ResponseEntity<List<Pojazd>> response = pojazdService.getPojazdByMarkaAndModelLike(marka,model);
        if(response != null){
            return response;
        }else{
            return new ResponseEntity(HttpStatus.EXPECTATION_FAILED);
        }
    }

    @RequestMapping(value = "/pojazd/model_like", method = RequestMethod.GET)
    public ResponseEntity<List<Pojazd>> getPojazdByModelLike(@RequestParam("model") String model) {
        ResponseEntity<List<Pojazd>> response = pojazdService.getPojazdByModelLike(model);
        if(response != null){
            return response;
        }else{
            return new ResponseEntity(HttpStatus.EXPECTATION_FAILED);
        }
    }

    @RequestMapping(value = "/pojazd", method = RequestMethod.DELETE)
    public ResponseEntity<Pojazd> deletePojazd(@RequestParam("id") Long id) {
        ResponseEntity<Pojazd> response = pojazdService.deletePojazd(id);
        if(response != null){
            return response;
        }else{
            return new ResponseEntity(HttpStatus.EXPECTATION_FAILED);
        }
    }

    @RequestMapping(value = "/pojazd/getMarka",method = RequestMethod.GET)
    public ResponseEntity<List<String>> getMarka(){
        ResponseEntity<List<String>> response = pojazdService.getMarka();
        if(response != null){
            return response;
        }else{
            return new ResponseEntity(HttpStatus.EXPECTATION_FAILED);
        }
    }

    @RequestMapping(value = "/pojazd/getMarkaByTyp",method = RequestMethod.GET)
    public ResponseEntity<List<String>> getMarkaByTyp(@RequestParam("typ") String typ){
        ResponseEntity<List<String>> response = pojazdService.getMarkaByTyp(typ);
        if(response != null){
            return response;
        }else{
            return new ResponseEntity(HttpStatus.EXPECTATION_FAILED);
        }
    }

    @RequestMapping(value = "/pojazd/getModel",method = RequestMethod.GET)
    public ResponseEntity<List<String>> getModelByMarka(@RequestParam("marka") String marka){
        ResponseEntity<List<String>> response = pojazdService.getModelByMarka(marka);
        if(response != null){
            return response;
        }else{
            return new ResponseEntity(HttpStatus.EXPECTATION_FAILED);
        }
    }

    @RequestMapping(value = "/pojazd", method = RequestMethod.PUT)
    public ResponseEntity<Pojazd> updatePojazd(@RequestBody Pojazd pojazd){
        ResponseEntity<Pojazd> response = pojazdService.updatePojazd(pojazd);
        if(response != null){
            return response;
        }else{
            return new ResponseEntity(HttpStatus.EXPECTATION_FAILED);
        }
    }
}