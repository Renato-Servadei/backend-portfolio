package com.backend.PortfolioRS.controller;

import com.backend.PortfolioRS.interfaces.ICertificaciones;
import com.backend.PortfolioRS.model.Certificaciones;
import java.util.ArrayList;
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

public class CertificacionesController {
    List<Certificaciones> listaCertificaciones = new ArrayList();
    
    @Autowired
    private ICertificaciones certServ;
    
    @PostMapping("/certificaciones/crear")
    public void crearCertificacion(@RequestBody Certificaciones cert) {
        certServ.crearCertificacion(cert);
    }
    
    @GetMapping("/certificaciones/ver")
    @ResponseBody
    public List<Certificaciones> verCertificaciones() {
        return certServ.verCertificaciones();
    }
    
    @GetMapping("/certificaciones/ver/{idCer}")
    @ResponseBody
    public Certificaciones buscarCertificacion(@PathVariable("idCer") Long idCer) {
        return certServ.buscarCertificacion(idCer);
    }
    
    @DeleteMapping("/certificaciones/borrar/{idCer}")
    public void borrarCertificacion(@PathVariable Long idCer) {
        certServ.borrarCertificacion(idCer);
    }
    
    @PutMapping("/editar/certificaciones/editar")
    public ResponseEntity <Certificaciones> editarCertificacion(@RequestBody Certificaciones cert) {
        Certificaciones editarCertificacion = certServ.editarCertificacion(cert);
        return new ResponseEntity <> (editarCertificacion, HttpStatus.OK);
                    
}
}
