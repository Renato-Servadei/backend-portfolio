package com.backend.PortfolioRS.interfaces;

import com.backend.PortfolioRS.model.Persona;
import java.util.List;



public interface IPersona {
    
    public List<Persona> verPersona();
    public void crearPersona(Persona per);
    public void borrarPersona(Long idPer);
    public Persona buscarPersona(Long idPer);
    public Persona editarPersona(Persona per);
}
    

