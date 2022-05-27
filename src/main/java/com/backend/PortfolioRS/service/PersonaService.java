package com.backend.PortfolioRS.service;

import com.backend.PortfolioRS.interfaces.IPersona;
import com.backend.PortfolioRS.model.Persona;
import com.backend.PortfolioRS.repository.PersonaRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class PersonaService implements IPersona{

    @Autowired
    public PersonaRepository persRepo;
    
    @Override
    public List<Persona> verPersona() {
        return persRepo.findAll();
    }

    @Override
    public void crearPersona(Persona per) {
        persRepo.save(per);
    }

    @Override
    public void borrarPersona(Long idPer) {
        persRepo.deleteById(idPer);
    }

    @Override
    public Persona buscarPersona(Long idPer) {
        return persRepo.findById(idPer).orElse(null);
    }

    @Override
    public Persona editarPersona(Persona per) {
        return persRepo.save(per);
    }
    
}
