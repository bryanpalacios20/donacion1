package com.donacion.controller;

import com.donacion.models.Envio;
import com.donacion.services.EnvioService;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class EnvioController {
    private final EnvioService envioService;

    public  EnvioController(EnvioService envioService){
        this.envioService= envioService;
    }
    @PostMapping("/envio")
    public Envio saveSolicitud(@RequestBody Envio envio) {
        return envioService.saveEnvio(envio);
    }
    @DeleteMapping("/envio/{id}")
    public void removeSolicitud(@PathVariable long id){
        envioService.removeEnvio(id);
    }

    @GetMapping("/envio/{id}")
    public Optional<Envio> getSolicitud(@PathVariable long id){
        return envioService.getEnvio(id);
    }
    @GetMapping("/envios")
    public List<Envio> getSolicitudes(){
        return envioService.getEnvios();
    }

}
