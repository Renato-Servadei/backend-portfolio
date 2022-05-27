package com.backend.PortfolioRS.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import lombok.Getter;
import lombok.Setter;

@Getter @Setter
@Entity
public class Persona {
    
@Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long idPer;
    private String nombrePer;
    private String ciudadPer;

    public Persona() {
    }

    public Persona(Long idPer, String nombrePer, String ciudadPer) {
        this.idPer = idPer;
        this.nombrePer = nombrePer;
        this.ciudadPer = ciudadPer;
    }
    
    
}

