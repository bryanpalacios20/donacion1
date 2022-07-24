package com.donacion.controller;


import com.donacion.models.Login;
import com.donacion.models.Usuario;
import com.donacion.services.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

@RestController
@RequestMapping("/usuarios")
public class UsuarioController{
    private final UsuarioService usuarioService;

    @Autowired
    public UsuarioController(UsuarioService usuarioService) {
        this.usuarioService = usuarioService;
    }

    @PostMapping("/guardar")
    public Usuario addUsuario(@RequestBody Usuario usuario) {
        System.out.println(usuario.toString());
        // add check for username exists in a DB
        if(usuarioService.existsByUsername(usuario.getUsername())){
            return null;
        }

        System.out.println(usuario);
        usuario.setPassword(passwordEncoder.encode(usuario.getPassword()));
        return usuarioService.saveUser(usuario);
    }
    @GetMapping("/listar")
    public ArrayList<Usuario> getUsuarios(){
        return usuarioService.getUsuarios();
    }
    @GetMapping("/buscar/{id}")
    public Usuario showUsuario(@PathVariable Long id){
        return usuarioService.getUsuario(id);
    }

    @DeleteMapping("/eliminar/{id}")
    public String removeUsuario(@PathVariable Long id){
        System.out.println("id: "+id);
        return usuarioService.removeUsuario(id);
    }

    @PutMapping("/actualizar/{id}")
    public Usuario updateEstudiante(@RequestBody Usuario usuario, @PathVariable Long id){
        Usuario usuarioActual = usuarioService.getUsuario(id);
        usuarioActual.setDni(usuario.getDni());
        usuarioActual.setUsername(usuario.getUsername());
        usuarioActual.setPassword(usuario.getPassword());
        usuarioActual.setEmail(usuario.getEmail());
        usuarioActual.setApellidos(usuario.getApellidos());
        usuarioActual.setDireccion(usuario.getDireccion());

        return usuarioService.saveUser(usuarioActual);
    }
    /*LOGIN*/
    private PasswordEncoder passwordEncoder;

    @Autowired
    private AuthenticationManager authenticationManager;

    @Bean
    public static PasswordEncoder passwordencoder() {
        return new BCryptPasswordEncoder();
    }
    @Autowired
    public void setPasswordEncoder(PasswordEncoder passwordEncoder) {
        this.passwordEncoder = passwordEncoder;
    }

    @PostMapping("/login")
    public Usuario login(@RequestBody Login loginDto){
        // add check for username exists in a DB
        System.out.println(loginDto);
        Authentication authentication = authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(
                loginDto.getUsername(), loginDto.getPassword()));
        SecurityContextHolder.getContext().setAuthentication(authentication);
        System.out.println("Login success");
        System.out.println("USERNAME: "+loginDto.getUsername());
        return usuarioService.getUsername(loginDto.getUsername());
    }

}
