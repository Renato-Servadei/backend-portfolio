package com.backend.PortfolioRS.controller;

import com.backend.PortfolioRS.interfaces.IPersona;
import com.backend.PortfolioRS.model.Persona;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;



@RestController
@CrossOrigin(origins="http://localhost:4200")
public class PersonaController {
    
    @Autowired
    public IPersona personaServ;
    
    @PostMapping("/persona/crear")
    public void crearPersona(@RequestBody Persona per) {
        personaServ.crearPersona(per);
    }
    
    @GetMapping("/persona/ver")
    @ResponseBody
    public List<Persona> verPersona() {
        return personaServ.verPersona();
    }
    
    @GetMapping("/persona/ver/{idPer}")
    @ResponseBody
    public Persona buscarPersona(@PathVariable("idPer") Long idPer) {
        return personaServ.buscarPersona(idPer);
    }
    
    @DeleteMapping("/persona/borrar/{idPer}")
    public void borrarPersona(@PathVariable Long idPer) {
        personaServ.borrarPersona(idPer);
    }
    
    @PutMapping("/persona/editar")
    public ResponseEntity <Persona> editarPersona(@RequestBody Persona per) {
        Persona editarPersona = personaServ.editarPersona(per);
        return new ResponseEntity<>(editarPersona, HttpStatus.OK);
}
    }
            

