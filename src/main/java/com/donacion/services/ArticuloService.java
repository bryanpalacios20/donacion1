package com.donacion.services;

import com.donacion.models.Articulo;
import com.donacion.repositories.ArticuloRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
@Service
public class ArticuloService {
    private final ArticuloRepository articuloRepository;

    @Autowired
    public ArticuloService(ArticuloRepository articuloRepository) {
        this.articuloRepository = articuloRepository;
    }
    public Articulo saveArticulo(Articulo articulo) {
        return articuloRepository.save(articulo);
    }
    public Articulo getArticulo(Long id) {
        return articuloRepository.findById(id).orElse(null);
    }
    public ArrayList<Articulo> getArticulos() {
        return (ArrayList<Articulo>) articuloRepository.findAll();
    }

    public String removeArticulo(Long id) {
        articuloRepository.deleteById(id);
        return "Eliminado articulo";
    }
}
