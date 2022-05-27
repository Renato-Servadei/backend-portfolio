package com.backend.PortfolioRS.controller;


import com.backend.PortfolioRS.interfaces.IDuras;
import com.backend.PortfolioRS.model.Duras;
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
public class DurasController {
    
    List<Duras> listaDuras = new ArrayList();
    
    @Autowired
    private IDuras durasServ;
    
    @PostMapping("/duras/crear")
    public void crearDuras(@RequestBody Duras duras) {
        durasServ.crearDuras(duras);
    }
    
    @GetMapping("/duras/ver")
    @ResponseBody
    public List<Duras> verDuras() {
        return durasServ.verDuras();
    }
    
    @GetMapping("/duras/ver/{idDuras}")
    @ResponseBody
    public Duras buscarDuras(@PathVariable("idDuras") Long idDuras) {
        return durasServ.buscarDuras(idDuras);
    }
    
    @DeleteMapping("/duras/borrar/{idDuras}")
    public void borrarDuras(@PathVariable Long idDuras) {
        durasServ.borrarDuras(idDuras);
    }
    
    @PutMapping("/duras/editar/{idDuras}")
    public Duras editarDuras(@PathVariable Long idDuras,
                                                @RequestParam("nombreDuras") String nuevoNombre,
                                                @RequestParam("iconoDuras") String nuevoIcono) {
        Duras duras = durasServ.buscarDuras(idDuras);
        duras.setNombreDuras(nuevoNombre);
        duras.setIconoDuras(nuevoIcono);
        
        durasServ.crearDuras(duras);
        return duras;
}
    
}
