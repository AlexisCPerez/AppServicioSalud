
package com.cg.servicioSalud.repositorios;

import com.cg.servicioSalud.entidades.Paciente;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface PacienteRepositorio extends JpaRepository<Paciente, String> {
    
    @Query("SELECT p FROM Paciente p WHERE p.especialidad = :especialidad AND p.activo = true)")
    public List <Paciente> buscarPorEspecialidad(@Param("especialidad") String especialidad);
}
