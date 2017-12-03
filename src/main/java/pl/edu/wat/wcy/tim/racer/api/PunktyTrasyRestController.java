package pl.edu.wat.wcy.tim.racer.api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pl.edu.wat.wcy.tim.racer.core.PunktyTrasyService;
import pl.edu.wat.wcy.tim.racer.domain.PunktyTrasy;

import java.util.List;

@RestController
public class PunktyTrasyRestController {
    private PunktyTrasyService punktyTrasyService;

    @Autowired
    public PunktyTrasyRestController(PunktyTrasyService punktyTrasyService) {
        this.punktyTrasyService = punktyTrasyService;
    }

    @RequestMapping(value = "/punkty_trasy", method = RequestMethod.GET)
    public ResponseEntity<List<PunktyTrasy>> getPunktyTrasy(){
        ResponseEntity<List<PunktyTrasy>> response = punktyTrasyService.getPunktyTrasy();
        if(response != null){
            return response;
        }else{
            return new ResponseEntity(HttpStatus.EXPECTATION_FAILED);
        }
    }

    @RequestMapping(value = "/punkty_trasy", method = RequestMethod.POST)
    public ResponseEntity<PunktyTrasy> addPunktyTrasy(@RequestParam("trasaId") Long trasaId, @RequestParam("szer") double szer, @RequestParam("dlug") double dlug) {
        ResponseEntity<PunktyTrasy> response = punktyTrasyService.addPunktyTrasy(trasaId,szer,dlug);
        if(response != null){
            return response;
        }else{
            return new ResponseEntity(HttpStatus.EXPECTATION_FAILED);
        }
    }

    @RequestMapping(value = "/punkty_trasy/all", method = RequestMethod.POST)
    public ResponseEntity<List<PunktyTrasy>> addPunktyTrasyAll(@RequestBody List<PunktyTrasy> punkty) {
        ResponseEntity response = punktyTrasyService.addPunktyTrasy(punkty);
        if(response != null){
            return response;
        }else{
            return new ResponseEntity(HttpStatus.EXPECTATION_FAILED);
        }
    }

    @RequestMapping(value = "/punkty_trasy/id", method = RequestMethod.GET)
    public ResponseEntity<List<PunktyTrasy>> getPunktyTrasyById(@RequestParam("nr") int nr,@RequestParam("trasaId") Long trasaId) {
        ResponseEntity<List<PunktyTrasy>> response = punktyTrasyService.getPunktyTrasyById(nr,trasaId);
        if(response != null){
            return response;
        }else{
            return new ResponseEntity(HttpStatus.EXPECTATION_FAILED);
        }
    }

    @RequestMapping(value = "/punkty_trasy/trasaId", method = RequestMethod.GET)
    public ResponseEntity<List<PunktyTrasy>> getPunktyTrasyByTrasaId(@RequestParam("trasaId") Long trasaId) {
        ResponseEntity<List<PunktyTrasy>> response = punktyTrasyService.getPunktyTrasyByTrasaId(trasaId);
        if(response != null){
            return response;
        }else{
            return new ResponseEntity(HttpStatus.EXPECTATION_FAILED);
        }
    }

    @RequestMapping(value = "/punkty_trasy", method = RequestMethod.DELETE)
    public ResponseEntity<PunktyTrasy> deletePunktyTrasy(@RequestParam("nr") int nr,@RequestParam("trasaId") Long trasaId) {
        ResponseEntity<PunktyTrasy> response = punktyTrasyService.deletePunktyTrasy(nr,trasaId);
        if(response != null){
            return response;
        }else{
            return new ResponseEntity(HttpStatus.EXPECTATION_FAILED);
        }
    }

    @RequestMapping(value = "/punkty_trasy/trasaId", method = RequestMethod.DELETE)
    public ResponseEntity<List<PunktyTrasy>> deletePunktyTrasy(@RequestParam("trasaId") Long trasaId) {
        ResponseEntity<List<PunktyTrasy>> response = punktyTrasyService.deletePunktyTrasyByTrasaId(trasaId);
        if(response != null){
            return response;
        }else{
            return new ResponseEntity(HttpStatus.EXPECTATION_FAILED);
        }
    }

    @RequestMapping(value = "/punkty_trasy", method = RequestMethod.PUT)
    public ResponseEntity<PunktyTrasy> updatePunktyTrasy(@RequestBody PunktyTrasy punktyTrasy){
        ResponseEntity<PunktyTrasy> response = punktyTrasyService.updatePunktyTrasy(punktyTrasy);
        if(response != null){
            return response;
        }else{
            return new ResponseEntity(HttpStatus.EXPECTATION_FAILED);
        }
    }
}
