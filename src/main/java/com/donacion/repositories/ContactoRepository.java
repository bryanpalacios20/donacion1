package com.donacion.repositories;

import com.donacion.models.Contacto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ContactoRepository  extends JpaRepository<Contacto, Long> {
}
