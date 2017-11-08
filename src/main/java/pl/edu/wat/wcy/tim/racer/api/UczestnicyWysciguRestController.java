package pl.edu.wat.wcy.tim.racer.api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pl.edu.wat.wcy.tim.racer.core.UczestnicyWysciguService;
import pl.edu.wat.wcy.tim.racer.domain.UczestnicyWyscigu;

import java.util.List;

@RestController
public class UczestnicyWysciguRestController {
    private UczestnicyWysciguService uczestnicyWysciguService;

    @Autowired
    public UczestnicyWysciguRestController(UczestnicyWysciguService uczestnicyWysciguService) {
        this.uczestnicyWysciguService = uczestnicyWysciguService;
    }

    @RequestMapping(value = "/uczestnicy_wyscigu", method = RequestMethod.GET)
    public ResponseEntity<List<UczestnicyWyscigu>> getUczestnicyWyscigu(){
        ResponseEntity<List<UczestnicyWyscigu>> response = uczestnicyWysciguService.getUczestnicyWyscigu();
        if(response != null){
            return response;
        }else{
            return new ResponseEntity(HttpStatus.EXPECTATION_FAILED);
        }
    }

    @RequestMapping(value = "/uczestnicy_wyscigu", method = RequestMethod.POST)
    public ResponseEntity<UczestnicyWyscigu> addUczestnicyWyscigu(@RequestParam("uzytkownikId") Long uzytkownikId, @RequestParam("wyscigId") Long wyscigId) {
        ResponseEntity<UczestnicyWyscigu> response = uczestnicyWysciguService.addUczestnicyWyscigu(uzytkownikId,wyscigId);
        if(response != null){
            return response;
        }else{
            return new ResponseEntity(HttpStatus.EXPECTATION_FAILED);
        }
    }

    @RequestMapping(value = "/uczestnicy_wyscigu/id", method = RequestMethod.GET)
    public ResponseEntity<List<UczestnicyWyscigu>> getUczestnicyWysciguById(@RequestParam("nr") int nr,@RequestParam("wyscigId") Long wyscigId) {
        ResponseEntity<List<UczestnicyWyscigu>> response = uczestnicyWysciguService.getUczestnicyWysciguById(nr,wyscigId);
        if(response != null){
            return response;
        }else{
            return new ResponseEntity(HttpStatus.EXPECTATION_FAILED);
        }
    }

    @RequestMapping(value = "/uczestnicy_wyscigu/wyscigId_uzytkownikId", method = RequestMethod.GET)
    public ResponseEntity<List<UczestnicyWyscigu>> getUczestnicyWysciguByWyscigIdAndUzytkownikId(@RequestParam("wyscigId") Long wyscigId,@RequestParam("uzytkownikId") Long uzytkownikId) {
        ResponseEntity<List<UczestnicyWyscigu>> response = uczestnicyWysciguService.getUczestnicyWysciguByWyscigIdAndUzytkownikId(wyscigId,uzytkownikId);
        if(response != null){
            return response;
        }else{
            return new ResponseEntity(HttpStatus.EXPECTATION_FAILED);
        }
    }

    @RequestMapping(value = "/uczestnicy_wyscigu/wyscigId", method = RequestMethod.GET)
    public ResponseEntity<List<UczestnicyWyscigu>> getUczestnicyWysciguByWyscigId(@RequestParam("wyscigId") Long wyscigId) {
        ResponseEntity<List<UczestnicyWyscigu>> response = uczestnicyWysciguService.getUczestnicyWysciguByWyscigId(wyscigId);
        if(response != null){
            return response;
        }else{
            return new ResponseEntity(HttpStatus.EXPECTATION_FAILED);
        }
    }

    @RequestMapping(value = "/uczestnicy_wyscigu/uzytkownikId", method = RequestMethod.GET)
    public ResponseEntity<List<UczestnicyWyscigu>> getUczestnicyWysciguByUzytkownikId(@RequestParam("uzytkownikId") Long uzytkownikId) {
        ResponseEntity<List<UczestnicyWyscigu>> response = uczestnicyWysciguService.getUczestnicyWysciguByUzytkownikId(uzytkownikId);
        if(response != null){
            return response;
        }else{
            return new ResponseEntity(HttpStatus.EXPECTATION_FAILED);
        }
    }

    @RequestMapping(value = "/uczestnicy_wyscigu/wyscigId_miejsce", method = RequestMethod.GET)
    public ResponseEntity<List<UczestnicyWyscigu>> getUczestnicyWysciguByWyscigIdAndMiejsce(@RequestParam("wyscigId") Long wyscigId,@RequestParam("miejsce") int miejsce) {
        ResponseEntity<List<UczestnicyWyscigu>> response = uczestnicyWysciguService.getUczestnicyWysciguByWyscigIdAndMiejsce(wyscigId,miejsce);
        if(response != null){
            return response;
        }else{
            return new ResponseEntity(HttpStatus.EXPECTATION_FAILED);
        }
    }

    @RequestMapping(value = "/uczestnicy_wyscigu", method = RequestMethod.DELETE)
    public ResponseEntity<UczestnicyWyscigu> deleteUczestnicyWyscigu(@RequestParam("nr") int nr,@RequestParam("wyscigId") Long wyscigId) {
        ResponseEntity<UczestnicyWyscigu> response = uczestnicyWysciguService.deleteUczestnicyWyscigu(nr,wyscigId);
        if(response != null){
            return response;
        }else{
            return new ResponseEntity(HttpStatus.EXPECTATION_FAILED);
        }
    }

    @RequestMapping(value = "/uczestnicy_wyscigu/wyscigId", method = RequestMethod.DELETE)
    public ResponseEntity<UczestnicyWyscigu> deleteUczestnicyWyscigu(@RequestParam("wyscigId") Long wyscigId) {
        ResponseEntity<UczestnicyWyscigu> response = uczestnicyWysciguService.deleteUczestnicyWysciguByWyscigId(wyscigId);
        if(response != null){
            return response;
        }else{
            return new ResponseEntity(HttpStatus.EXPECTATION_FAILED);
        }
    }

    @RequestMapping(value = "/uczestnicy_wyscigu", method = RequestMethod.PUT)
    public ResponseEntity<UczestnicyWyscigu> updateUczestnicyWyscigu(@RequestBody UczestnicyWyscigu uczestnicyWyscigu){
        ResponseEntity<UczestnicyWyscigu> response = uczestnicyWysciguService.updateUczestnicyWyscigu(uczestnicyWyscigu);
        if(response != null){
            return response;
        }else{
            return new ResponseEntity(HttpStatus.EXPECTATION_FAILED);
        }
    }
}
