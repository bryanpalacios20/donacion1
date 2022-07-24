package com.donacion.services;

import com.donacion.details.CustomUserDetails;
import com.donacion.models.Usuario;
import com.donacion.repositories.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class CustomUserDetailsService implements UserDetailsService {
    private final UsuarioRepository repository;
    @Autowired
    public CustomUserDetailsService(UsuarioRepository repository) {
        this.repository = repository;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Usuario usuario=repository.findByUsername(username);
        if (usuario==null)
            throw new UsernameNotFoundException("El usuario no es valida");
        return new CustomUserDetails(usuario);
    }
}
