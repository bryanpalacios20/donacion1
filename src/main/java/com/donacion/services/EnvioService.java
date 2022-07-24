package com.donacion.services;

import com.donacion.models.Envio;
import com.donacion.repositories.EnvioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Optional;
@Service
public class EnvioService {
    private final EnvioRepository envioRepository;

    @Autowired
    public EnvioService(EnvioRepository envioRepository){
        this.envioRepository=envioRepository;
    }

    public Envio saveEnvio(Envio envio){
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        System.out.println("dd/MM/yyyy-> "+dtf.format(LocalDateTime.now()));
        envio.setFecha(dtf.format(LocalDateTime.now()));
        return envioRepository.save(envio);
    }
    public List<Envio> getEnvios() {

        return envioRepository.findAll();
    }
    public Optional<Envio> getEnvio(long id){
        return envioRepository.findById(id);
    }

    public void removeEnvio(long id) {
        envioRepository.deleteById(id);
    }
}
