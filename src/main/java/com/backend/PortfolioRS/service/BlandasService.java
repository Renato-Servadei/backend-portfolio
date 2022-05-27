package com.backend.PortfolioRS.service;

import com.backend.PortfolioRS.interfaces.IBlandas;
import com.backend.PortfolioRS.model.Blandas;
import com.backend.PortfolioRS.repository.BlandasRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BlandasService implements IBlandas {
    
    @Autowired
    public BlandasRepository blandasRepo;

   @Override
    public List<Blandas> verBlandas() {
    return blandasRepo.findAll();
    }

    @Override
    public void crearBlandas(Blandas blandas) {
       blandasRepo.save(blandas);
    }

    @Override
    public void borrarBlandas(Long idBlandas) {
        blandasRepo.deleteById(idBlandas);
    }

    @Override
    public Blandas buscarBlandas(Long idBlandas) {
        return blandasRepo.findById(idBlandas).orElse(null);
    }

    @Override
    public Blandas editarBlandas(Blandas blandas) {
        return blandasRepo.save(blandas);
    }
    
    
}
