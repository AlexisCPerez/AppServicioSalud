
package com.cg.servicioSalud.repositorios;

import com.cg.servicioSalud.entidades.Disponibilidad;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DisponibilidadRepositorio extends JpaRepository<Disponibilidad, String> {
    
}
