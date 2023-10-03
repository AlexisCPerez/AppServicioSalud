
package com.cg.servicioSalud.servicios;

import com.cg.servicioSalud.entidades.Imagen;
import com.cg.servicioSalud.entidades.Paciente;
import com.cg.servicioSalud.enums.Rol;
import com.cg.servicioSalud.excepciones.MiException;
import com.cg.servicioSalud.repositorios.PacienteRepositorio;
import javax.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

@Service
public class PacienteServicio {
    
    @Autowired
    private PacienteRepositorio pacienteRepositorio;
    
    @Autowired
    private ImagenServicio imagenServicio;
    
    @Transactional
    public void crearPaciente(String nombreCompleto, String email, 
                                String clave, Long telefono, Rol rol, 
                                MultipartFile archivo, 
                                String obraSocial) throws MiException{
        
        Paciente paciente = new Paciente();
        
        paciente.setNombreCompleto(nombreCompleto);
        paciente.setRol(rol);
        paciente.setTelefono(telefono);
        paciente.setClave(clave);
        paciente.setObraSocial(obraSocial);
        paciente.setEmail(email);
        
        Imagen imagen = imagenServicio.guardar(archivo);
        paciente.setImagen(imagen);
        
        pacienteRepositorio.save(paciente);
        
        
    }
    
    
}
