package com.backend.PortfolioRS.repository;


import com.backend.PortfolioRS.entity.Blandas;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BlandasRepository extends JpaRepository<Blandas, Long> {
    
}
