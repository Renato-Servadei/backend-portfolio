package com.backend.PortfolioRS.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository

public interface Educacion extends JpaRepository <Educacion, Long>{
    
}