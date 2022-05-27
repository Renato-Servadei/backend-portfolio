package com.backend.PortfolioRS.repository;


import com.backend.PortfolioRS.model.Duras;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DurasRepository extends JpaRepository <Duras, Long> {
    
}
