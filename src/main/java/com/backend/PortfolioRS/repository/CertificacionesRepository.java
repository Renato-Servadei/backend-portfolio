package com.backend.PortfolioRS.repository;

import com.backend.PortfolioRS.model.Certificaciones;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CertificacionesRepository extends JpaRepository<Certificaciones, Long>{
    
}
