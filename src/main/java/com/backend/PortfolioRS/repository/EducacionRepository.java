package com.backend.PortfolioRS.repository;


import com.backend.PortfolioRS.entity.Educacion;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository

public interface EducacionRepository extends JpaRepository <Educacion, Long>{
    
}
