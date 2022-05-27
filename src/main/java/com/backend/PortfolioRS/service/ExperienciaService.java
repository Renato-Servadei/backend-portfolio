package com.backend.PortfolioRS.service;

import com.backend.PortfolioRS.interfaces.IExperiencia;
import com.backend.PortfolioRS.model.Experiencia;
import com.backend.PortfolioRS.repository.ExperienciaRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;



@Service
public class ExperienciaService implements IExperiencia {
    
    @Autowired
    public ExperienciaRepository expRepo;

    @Override
    public List<Experiencia> verExperiencia() {
        return expRepo.findAll();
    }

    @Override
    public void crearExperiencia(Experiencia exp) {
        expRepo.save(exp);
    }

    @Override
    public void borrarExperiencia(Long idExp) {
        expRepo.deleteById(idExp);
    }

    @Override
    public Experiencia buscarExperiencia(Long idExp) {
        return expRepo.findById(idExp).orElse(null);
    }

    @Override
    public Experiencia editarExperiencia(Experiencia exp) {
        return expRepo.save(exp);
    }
    
}
