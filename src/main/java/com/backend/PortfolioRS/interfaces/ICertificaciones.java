package com.backend.PortfolioRS.interfaces;

import com.backend.PortfolioRS.model.Certificaciones;
import java.util.List;



public interface ICertificaciones {
    
    public List<Certificaciones> verCertificaciones();
    public void crearCertificacion(Certificaciones cert);
    public void borrarCertificacion(Long idCer);
    public Certificaciones buscarCertificacion(Long idCer);
    public Certificaciones editarCertificacion(Certificaciones cert);

}