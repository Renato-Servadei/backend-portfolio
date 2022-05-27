package com.backend.PortfolioRS.service;

import com.backend.PortfolioRS.interfaces.ICertificaciones;
import com.backend.PortfolioRS.model.Certificaciones;
import com.backend.PortfolioRS.repository.CertificacionesRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CertificacionesService implements ICertificaciones {
 
    
    @Autowired
    public CertificacionesRepository certRepo;

    @Override
    public List<Certificaciones> verCertificaciones() {
        return certRepo.findAll();
    }

    @Override
    public void crearCertificacion(Certificaciones cert) {
        certRepo.save(cert);
    }

    @Override
    public void borrarCertificacion(Long idCer) {
        certRepo.deleteById(idCer);
    }

    @Override
    public Certificaciones buscarCertificacion(Long idCer) {
        return certRepo.findById(idCer).orElse(null);
    }

    @Override
    public Certificaciones editarCertificacion(Certificaciones cert) {
        return certRepo.save(cert);
    }
    
}
