
package com.backend.PortfolioRS.service;

import com.backend.PortfolioRS.interfaces.IDuras;
import com.backend.PortfolioRS.entity.Duras;
import com.backend.PortfolioRS.repository.DurasRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DurasService implements IDuras{

    @Autowired
    public DurasRepository durasRepo;
    
    @Override
    public List<Duras> verDuras() {
    return durasRepo.findAll();
    }

    @Override
    public void crearDuras(Duras duras) {
       durasRepo.save(duras);
    }

    @Override
    public void borrarDuras(Long idDuras) {
        durasRepo.deleteById(idDuras);
    }

    @Override
    public Duras buscarDuras(Long idDuras) {
        return durasRepo.findById(idDuras).orElse(null);
    }

    @Override
    public Duras editarDuras(Duras duras) {
        return durasRepo.save(duras);
    }
    
    
}
