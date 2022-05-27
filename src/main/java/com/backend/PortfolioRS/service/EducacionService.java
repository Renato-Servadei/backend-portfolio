package com.backend.PortfolioRS.service;

import com.backend.PortfolioRS.interfaces.IEducacion;
import com.backend.PortfolioRS.model.Educacion;
import com.backend.PortfolioRS.repository.EducacionRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class EducacionService implements IEducacion {
    
    @Autowired
    public EducacionRepository eduRepo;

    @Override
    public List<Educacion> verEducacion() {
        return eduRepo.findAll();
    }

    @Override
    public void crearEducacion(Educacion edu) {
        eduRepo.save(edu);
    }

    @Override
    public void borrarEducacion(Long idEdu) {
        eduRepo.deleteById(idEdu);
    }

    @Override
    public Educacion buscarEducacion(Long idEdu) {
        return eduRepo.findById(idEdu).orElse(null);
    }

    @Override
    public Educacion editarEducacion(Educacion edu) {
        return eduRepo.save(edu);
    }
    
}
