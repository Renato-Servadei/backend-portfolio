package com.backend.PortfolioRS.repository;

import com.backend.PortfolioRS.entity.Proyectos;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProyectosRepository extends JpaRepository<Proyectos, Long> {
    
}
