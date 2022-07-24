package com.donacion.controller;

import com.donacion.models.Contacto;
import com.donacion.services.ContactoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

@RestController
@RequestMapping("/contacto")
public class ContactoController {

    private final ContactoService contactoService;

    @Autowired
    public ContactoController(ContactoService contactoService){
        this.contactoService=contactoService;
    }
    @PostMapping("/guardar")
    public Contacto addContacto(@RequestBody Contacto contacto) {
        System.out.println(contacto.toString());
        return contactoService.saveContacto(contacto);
    }
    @GetMapping("/listar")
    public ArrayList<Contacto> getContactos(){
        return contactoService.getContactos();
    }


    @DeleteMapping("/eliminar/{id}")
    public String removeContacto(@PathVariable Long id){
        System.out.println("id: "+id);
        return contactoService.removeContacto(id);
    }
}
