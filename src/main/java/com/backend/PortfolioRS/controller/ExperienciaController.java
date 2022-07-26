package com.backend.PortfolioRS.controller;


import com.backend.PortfolioRS.interfaces.IExperiencia;
import com.backend.PortfolioRS.entity.Experiencia;
import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
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
//@CrossOrigin(origins="https://rsportfolio-front-a45ea.web.app")
@CrossOrigin(origins="http://localhost:4200")

public class ExperienciaController {
    
    List<Experiencia> listaExperiencia = new ArrayList();
    
    @Autowired
    private IExperiencia expServ;
    
    @PreAuthorize("hasRole('ADMIN')")
    @PostMapping("/experiencia/crear")
    public void crearExperiencia(@RequestBody Experiencia exp) {
        expServ.crearExperiencia(exp);
    }
    
    @GetMapping("/experiencia/ver")
    @ResponseBody
    public List<Experiencia> verExperiencia() {
        return expServ.verExperiencia();
    }
    
    @GetMapping("/experiencia/ver/{idExp}")
    @ResponseBody
    public Experiencia buscarExperiencia(@PathVariable("idExp") Long idExp) {
        return expServ.buscarExperiencia(idExp);
    }
    
    @PreAuthorize("hasRole('ADMIN')")
    @DeleteMapping("/experiencia/borrar/{idExp}")
    public void borrarExperiencia(@PathVariable Long idExp) {
        expServ.borrarExperiencia(idExp);
    }
    
    @PreAuthorize("hasRole('ADMIN')")
    @PutMapping("/experiencia/editar/{idExp}")
    public Experiencia editarExperiencia(@PathVariable Long idExp,
                                                @RequestParam("periodoExp") String nuevoPeriodo,
                                                @RequestParam("tituloExp") String nuevoTitulo,
                                                @RequestParam("institucionExp") String nuevaInstitucion) {
        Experiencia exp = expServ.buscarExperiencia(idExp);
        exp.setPeriodoExp(nuevoPeriodo);
        exp.setTituloExp(nuevoTitulo);
        exp.setInstitucionExp(nuevaInstitucion);
        
        expServ.crearExperiencia(exp);
        return exp;
}
    
}

