package pl.edu.wat.wcy.tim.Racer.api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import pl.edu.wat.wcy.tim.Racer.core.UzytkownikService;
import pl.edu.wat.wcy.tim.Racer.domain.Uzytkownik;

import java.util.List;

@RestController
public class UzytkownikRestController {
    private UzytkownikService uzytkownikService;

    @Autowired
    public UzytkownikRestController(UzytkownikService uzytkownikService){
        this.uzytkownikService = uzytkownikService;
    }

    @RequestMapping(value="/uzytkownik")
    public List<Uzytkownik> findAll(){
        return uzytkownikService.findAll();
    }

    @RequestMapping(value="uzytkownik/add")
    public Uzytkownik addUzytkownik(@RequestParam("nazwa") String nazwa,@RequestParam("haslo") String haslo){
        Uzytkownik uzytkownik = new Uzytkownik(nazwa,haslo);
        uzytkownikService.addUzytkownik(uzytkownik);
        return uzytkownik;
    }

    @RequestMapping(value="/uzytkownik/{nazwa}")
    public List<Uzytkownik> findByNazwa(@PathVariable String nazwa){
        return uzytkownikService.findByNazwa(nazwa);
    }

    @RequestMapping(value="/uzytkownik/delete/{id}")
    public void delete(@PathVariable Long id){
        uzytkownikService.delete(id);
    }
}
