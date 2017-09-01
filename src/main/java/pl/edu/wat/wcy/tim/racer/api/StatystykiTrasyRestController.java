package pl.edu.wat.wcy.tim.racer.api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import pl.edu.wat.wcy.tim.racer.core.StatystykiTrasyService;
import pl.edu.wat.wcy.tim.racer.domain.StatystykiTrasy;

import java.sql.Time;
import java.util.List;

@RestController
public class StatystykiTrasyRestController {
    private StatystykiTrasyService statystykiTrasyService;

    @Autowired
    public StatystykiTrasyRestController(StatystykiTrasyService statystykiTrasyService) {
        this.statystykiTrasyService = statystykiTrasyService;
    }

    @RequestMapping(value = "/statystyki_trasy", method = RequestMethod.GET)
    public ResponseEntity<List<StatystykiTrasy>> getStatystykiTrasy(){
        ResponseEntity<List<StatystykiTrasy>> response = statystykiTrasyService.getStatystykiTrasy();
        if(response != null){
            return response;
        }else{
            return new ResponseEntity(HttpStatus.EXPECTATION_FAILED);
        }
    }

    @RequestMapping(value = "/statystyki_trasy", method = RequestMethod.POST)
    public ResponseEntity addStatystykiTrasy(@RequestParam("nrPojazdu") int nrPojazdu, @RequestParam("uzytkownikId") Long uzytkownikId, @RequestParam("trasaId") Long trasaId, @RequestParam("czas")Time czas,@RequestParam("vMax")int vMax,@RequestParam("vAvg")int vAvg,@RequestParam("czas_0_100")Time czas_0_100,@RequestParam("czas_0_vmax")Time czas_0_vmax,@RequestParam("ocena")int ocena) {
        ResponseEntity response = statystykiTrasyService.addStatystykiTrasy(nrPojazdu,uzytkownikId,trasaId,czas,vMax,vAvg,czas_0_100,czas_0_vmax,ocena);
        if(response != null){
            return response;
        }else{
            return new ResponseEntity(HttpStatus.EXPECTATION_FAILED);
        }
    }

    @RequestMapping(value = "/statystyki_trasy/id", method = RequestMethod.GET)
    public ResponseEntity<List<StatystykiTrasy>> getStatystykiTrasyById(@RequestParam("nrPojazdu") int nrPojazdu, @RequestParam("uzytkownikId") Long uzytkownikId, @RequestParam("trasaId") Long trasaId) {
        ResponseEntity<List<StatystykiTrasy>> response = statystykiTrasyService.getStatystykiTrasyById(trasaId,nrPojazdu,uzytkownikId);
        if(response != null){
            return response;
        }else{
            return new ResponseEntity(HttpStatus.EXPECTATION_FAILED);
        }
    }

    @RequestMapping(value = "/statystyki_trasy/trasaId", method = RequestMethod.GET)
    public ResponseEntity<List<StatystykiTrasy>> getStatystykiTrasyByTrasaId(@RequestParam("trasaId") Long trasaId) {
        ResponseEntity<List<StatystykiTrasy>> response = statystykiTrasyService.getStatystykiTrasyByTrasaId(trasaId);
        if(response != null){
            return response;
        }else{
            return new ResponseEntity(HttpStatus.EXPECTATION_FAILED);
        }
    }

    @RequestMapping(value = "/statystyki_trasy/pojazdyUzytkownikaId", method = RequestMethod.GET)
    public ResponseEntity<List<StatystykiTrasy>> getStatystykiTrasyByPojazdyUzytkownikaId(@RequestParam("nrPojazdu") int nrPojazdu, @RequestParam("uzytkownikId") Long uzytkownikId) {
        ResponseEntity<List<StatystykiTrasy>> response = statystykiTrasyService.getStatystykiTrasyByPojazdyUzytkownikaId(nrPojazdu,uzytkownikId);
        if(response != null){
            return response;
        }else{
            return new ResponseEntity(HttpStatus.EXPECTATION_FAILED);
        }
    }

    @RequestMapping(value = "/statystyki_trasy/ocena", method = RequestMethod.GET)
    public ResponseEntity<List<StatystykiTrasy>> getStatystykiTrasyByOcena(@RequestParam("min") int min, @RequestParam("max") int max) {
        ResponseEntity<List<StatystykiTrasy>> response = statystykiTrasyService.getStatystykiTrasyByOcenaBetween(min,max);
        if(response != null){
            return response;
        }else{
            return new ResponseEntity(HttpStatus.EXPECTATION_FAILED);
        }
    }

    @RequestMapping(value = "/statystyki_trasy", method = RequestMethod.DELETE)
    public ResponseEntity deleteStatystykiTrasy(@RequestParam("nrPojazdu") int nrPojazdu,@RequestParam("uzytkownikId") Long uzytkownikId,@RequestParam("trasaId") Long trasaId) {
        ResponseEntity response = statystykiTrasyService.deleteStatystykiTrasy(trasaId,nrPojazdu,uzytkownikId);
        if(response != null){
            return response;
        }else{
            return new ResponseEntity(HttpStatus.EXPECTATION_FAILED);
        }
    }

    @RequestMapping(value = "/statystyki_trasy/trasaId", method = RequestMethod.DELETE)
    public ResponseEntity deleteStatystykiTrasy(@RequestParam("trasaId") Long trasaId) {
        ResponseEntity response = statystykiTrasyService.deleteStatystykiTrasyByTrasaId(trasaId);
        if(response != null){
            return response;
        }else{
            return new ResponseEntity(HttpStatus.EXPECTATION_FAILED);
        }
    }
}
