package com.backend.PortfolioRS.service;

import com.backend.PortfolioRS.interfaces.IProyectos;
import com.backend.PortfolioRS.model.Proyectos;
import com.backend.PortfolioRS.repository.ProyectosRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class ProyectosService implements IProyectos {

    @Autowired
    public ProyectosRepository proRepo;
    
    @Override
    public List<Proyectos> verProyectos() {
        return proRepo.findAll();
    }

    @Override
    public void crearProyectos(Proyectos pro) {
        proRepo.save(pro);
        
    }

    @Override
    public void borrarProyectos(Long idPro) {
        proRepo.deleteById(idPro);
    }

    @Override
    public Proyectos buscarProyectos(Long idPro) {
        return proRepo.findById(idPro).orElse(null);
    }

    @Override
    public Proyectos editarProyectos(Proyectos pro) {
        return proRepo.save(pro);
    }
    
}
