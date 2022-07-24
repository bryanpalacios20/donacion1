package com.donacion.controller;

import com.donacion.models.Articulo;
import com.donacion.services.ArticuloService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

@RestController
@RequestMapping("/articulos")
public class ArticuloController {

    private final ArticuloService articuloService;

    @Autowired
    public ArticuloController (ArticuloService articuloService) {
        this.articuloService = articuloService;
    }
    @PostMapping("/guardar")
    public Articulo addArticulo(@RequestBody Articulo articulo) {
        System.out.println(articulo.toString());
        return articuloService.saveArticulo(articulo);
    }
    @GetMapping("/listar")
    public ArrayList<Articulo> getArticulos(){
        return articuloService.getArticulos();
    }


    @DeleteMapping("/eliminar/{id}")
    public String removeUsuario(@PathVariable Long id){
        System.out.println("id: "+id);
        return articuloService.removeArticulo(id);
    }
}
