package com.backend.PortfolioRS.interfaces;


import com.backend.PortfolioRS.entity.Experiencia;
import java.util.List;

public interface IExperiencia {


    public List<Experiencia> verExperiencia();
    public void crearExperiencia(Experiencia exp);
    public void borrarExperiencia(Long idExp);
    public Experiencia buscarExperiencia(Long idExp);    
    public Experiencia editarExperiencia(Experiencia exp);
}
