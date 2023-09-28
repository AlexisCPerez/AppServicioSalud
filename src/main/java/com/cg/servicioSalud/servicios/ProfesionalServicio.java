
package com.cg.servicioSalud.servicios;

import com.cg.servicioSalud.entidades.Disponibilidad;
import com.cg.servicioSalud.entidades.Imagen;
import com.cg.servicioSalud.entidades.Profesional;
import com.cg.servicioSalud.enums.Dia;
import com.cg.servicioSalud.enums.Horario;
import com.cg.servicioSalud.enums.Modalidad;
import com.cg.servicioSalud.enums.Rol;
import com.cg.servicioSalud.repositorios.DisponibilidadRepositorio;
import com.cg.servicioSalud.repositorios.ProfesionalRepositorio;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import javax.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProfesionalServicio {
    
    @Autowired
    private ProfesionalRepositorio profesionalRepositorio;
    
    @Autowired
    private DisponibilidadRepositorio disponibilidadRepositorio;
    
    @Transactional
    public void crearProfesional(String nombreCompleto, String email, 
                                String clave, Long telefono, Rol rol, 
                                Imagen imagen,  String idDisponibilidad,
                                Map<Dia,Horario> jornada,
                                List<String> obraSocial, Modalidad modalidad, 
                                String ubicacion, String especialidad, Double tarifa){
        
        //validar
        
        Profesional profesional = new Profesional();
        
        profesional.setNombreCompleto(nombreCompleto);
        profesional.setEspecialidad(especialidad);
        profesional.getDisponibilidad().setJornada(jornada);
        profesional.setActivo(Boolean.FALSE);
        profesional.setUbicacion(ubicacion);
        profesional.setModalidad(modalidad);
        profesional.setRol(rol);
        profesional.setReputacion(0d);
        profesional.setTelefono(telefono);
        profesional.setTarifa(0.0);
        profesional.setClave(clave);
        profesional.setObrasSociales(obraSocial);
        profesional.setFechaAlta(new Date());
        profesional.setEmail(email);
        profesional.setImagen(imagen);
        
        profesionalRepositorio.save(profesional);
    }
    
    @Transactional
    public void modificarProfesional(String id, String nombreCompleto, String email, 
                                String clave, Long telefono, Rol rol, 
                                Imagen imagen, List<String> obraSocial, 
                                Modalidad modalidad, String idDisponibilidad,
                                Map<Dia,Horario> jornada,
                                String ubicacion, String especialidad, Double tarifa, 
                                Boolean activo){
        
        //validar
        
        Optional <Profesional> respuesta = profesionalRepositorio.findById(id);
        Optional <Disponibilidad> respuestaDisponibilidad = disponibilidadRepositorio.findById(idDisponibilidad);
        
        Disponibilidad disponibilidad = new Disponibilidad();
        
        if(respuestaDisponibilidad.isPresent()){
            disponibilidad = respuestaDisponibilidad.get();
        }
        
        if (respuesta.isPresent()){
            
            Profesional profesional = respuesta.get();
            profesional.setNombreCompleto(nombreCompleto);
            profesional.setEspecialidad(especialidad);
            profesional.getDisponibilidad().setJornada(jornada);
            profesional.setActivo(Boolean.FALSE);
            profesional.setUbicacion(ubicacion);
            profesional.setModalidad(modalidad);
            profesional.setRol(rol);
            profesional.setReputacion(0d);
            profesional.setTelefono(telefono);
            profesional.setTarifa(0.0);
            profesional.setClave(clave);
            profesional.setObrasSociales(obraSocial);
            profesional.setFechaAlta(new Date());
            profesional.setEmail(email);
            profesional.setImagen(imagen);

            profesionalRepositorio.save(profesional);
        }
    }
    
    //funcion validar
}
