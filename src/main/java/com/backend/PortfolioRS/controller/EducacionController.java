package com.backend.PortfolioRS.controller;


import com.backend.PortfolioRS.interfaces.IEducacion;
import com.backend.PortfolioRS.model.Educacion;
import java.util.ArrayList;
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

public class EducacionController {
    
    List<Educacion> listaEducacion = new ArrayList();
    
    @Autowired
    private IEducacion eduServ;
    
    @PostMapping("/educacion/crear")
    public void crearEducacion(@RequestBody Educacion edu) {
        eduServ.crearEducacion(edu);
    }
    
    @GetMapping("/educacion/ver")
    @ResponseBody
    public List<Educacion> verEducacion() {
        return eduServ.verEducacion();
    }
    
    @GetMapping("/educacion/ver/{idEdu}")
    @ResponseBody
    public Educacion buscarEducacion(@PathVariable("idEdu") Long idEdu) {
        return eduServ.buscarEducacion(idEdu);
    }
    
    @DeleteMapping("/educacion/borrar/{idEdu}")
    public void borrarEducacion(@PathVariable Long idEdu) {
        eduServ.borrarEducacion(idEdu);
    }
    
    @PutMapping("/educacion/editar/{idEdu}")
    public Educacion editarEducacion(@PathVariable Long idEdu,
                                                @RequestParam("periodoEdu") String nuevoPeriodo,
                                                @RequestParam("tituloEdu") String nuevoTitulo,
                                                @RequestParam("institucionEdu") String nuevaInstitucion) {
        Educacion edu = eduServ.buscarEducacion(idEdu);
        edu.setPeriodoEdu(nuevoPeriodo);
        edu.setTituloEdu(nuevoTitulo);
        edu.setInstitucionEdu(nuevaInstitucion);
        
        eduServ.crearEducacion(edu);
        return edu;
}
    
}
