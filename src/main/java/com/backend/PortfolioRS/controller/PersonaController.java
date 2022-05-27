package com.backend.PortfolioRS.controller;

import com.backend.PortfolioRS.interfaces.IPersona;
import com.backend.PortfolioRS.model.Persona;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
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
    
    @PutMapping("/persona/editar/{idPer}")
    public Persona editarPersona(@PathVariable Long idPer,
                                                @RequestParam("nombrePer") String nuevoNombre,
                                                @RequestParam("ciudadPer") String nuevaCiudad) {
        Persona per = personaServ.buscarPersona(idPer);
        per.setNombrePer(nuevoNombre);
        per.setCiudadPer(nuevaCiudad);
        
        
        personaServ.crearPersona(per);
        return per;
}
    }
            

