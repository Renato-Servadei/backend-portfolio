package com.backend.PortfolioRS.controller;


import com.backend.PortfolioRS.interfaces.IProyectos;
import com.backend.PortfolioRS.entity.Proyectos;
import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
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
public class ProyectosController {
    
    List<Proyectos> listaProyectos = new ArrayList();
    
    @Autowired
    private IProyectos proServ;
    
    @PreAuthorize("hasRole('ADMIN')")
    @PostMapping("/proyectos/crear")
    public void crearProyectos(@RequestBody Proyectos pro) {
        proServ.crearProyectos(pro);
    }
    
    @GetMapping("/proyectos/ver")
    @ResponseBody
    public List<Proyectos> verProyectos() {
        return proServ.verProyectos();
    }
    
    @GetMapping("/proyectos/ver/{idPro}")
    @ResponseBody
    public Proyectos buscarProyectos(@PathVariable("idPro") Long idPro) {
        return proServ.buscarProyectos(idPro);
    }
    
    @PreAuthorize("hasRole('ADMIN')")
    @DeleteMapping("/proyectos/borrar/{idPro}")
    public void borrarProyectos(@PathVariable Long idPro) {
        proServ.borrarProyectos(idPro);
    }
    
    @PreAuthorize("hasRole('ADMIN')")
    @PutMapping("/proyectos/editar")
    public ResponseEntity <Proyectos> editarProyectos(@RequestBody Proyectos pro) {
        Proyectos editarProyectos = proServ.editarProyectos(pro);
        return new ResponseEntity <> (editarProyectos, HttpStatus.OK);
}
    
}
