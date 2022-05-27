package com.backend.PortfolioRS.interfaces;

import com.backend.PortfolioRS.model.Proyectos;
import java.util.List;


public interface IProyectos {


    public List<Proyectos> verProyectos();
    public void crearProyectos(Proyectos pro);
    public void borrarProyectos(Long idPro);
    public Proyectos buscarProyectos(Long idPro); 
    public Proyectos editarProyectos(Proyectos pro);
}
