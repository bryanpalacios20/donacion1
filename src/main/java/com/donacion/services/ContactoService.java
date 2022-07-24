package com.donacion.services;

import com.donacion.models.Contacto;
import com.donacion.repositories.ContactoRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
public class ContactoService {

    private final ContactoRepository contactoRepository;

    public ContactoService(ContactoRepository contactoRepository){
        this.contactoRepository= contactoRepository;
    }

    public Contacto saveContacto(Contacto contacto) {
        return contactoRepository.save(contacto);
    }
    public Contacto getContacto(Long id) {
        return contactoRepository.findById(id).orElse(null);
    }
    public ArrayList<Contacto> getContactos() {
        return (ArrayList<Contacto>) contactoRepository.findAll();
    }

    public String removeContacto(Long id) {
        contactoRepository.deleteById(id);
        return "Eliminado Contacto";
    }
}
