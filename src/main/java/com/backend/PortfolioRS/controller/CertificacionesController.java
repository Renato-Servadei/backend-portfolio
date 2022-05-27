package com.backend.PortfolioRS.controller;

import com.backend.PortfolioRS.interfaces.ICertificaciones;
import com.backend.PortfolioRS.model.Certificaciones;
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
public class CertificacionesController {
    List<Certificaciones> listaCertificaciones = new ArrayList();
    
    @Autowired
    private ICertificaciones certServ;
    
    @PostMapping("/certificacion/crear")
    public void crearCertificacion(@RequestBody Certificaciones cert) {
        certServ.crearCertificacion(cert);
    }
    
    @GetMapping("/certificaciones/ver")
    @ResponseBody
    public List<Certificaciones> verCertificaciones() {
        return certServ.verCertificaciones();
    }
    
    @GetMapping("/certificacion/ver/{idCer}")
    @ResponseBody
    public Certificaciones buscarCertificacion(@PathVariable("idCer") Long idCer) {
        return certServ.buscarCertificacion(idCer);
    }
    
    @DeleteMapping("/certificacion/borrar/{idCer}")
    public void borrarCertificacion(@PathVariable Long idCer) {
        certServ.borrarCertificacion(idCer);
    }
    
    @PutMapping("/editar/certificacion/editar/{idCer}")
    public Certificaciones editarCertificacion(@PathVariable Long idCer,
                                                @RequestParam("nombreCer") String nuevoNombre,
                                                @RequestParam("linkCer") String nuevoLink,
                                                @RequestParam("iconoCer") String nuevoIcono) {
        Certificaciones cert = certServ.buscarCertificacion(idCer);
        cert.setNombreCer(nuevoNombre);
        cert.setLinkCer(nuevoLink);
        cert.setIconoCer(nuevoIcono);
        
        certServ.crearCertificacion(cert);
        return cert;
}
}
