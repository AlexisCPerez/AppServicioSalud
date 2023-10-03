
package com.cg.servicioSalud.controladores;

import com.cg.servicioSalud.entidades.Imagen;
import com.cg.servicioSalud.enums.Dia;
import com.cg.servicioSalud.enums.Horario;
import com.cg.servicioSalud.enums.Modalidad;
import com.cg.servicioSalud.enums.Rol;
import com.cg.servicioSalud.excepciones.MiException;
import com.cg.servicioSalud.servicios.PacienteServicio;
import java.util.List;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

@Controller
@RequestMapping("/Paciente")
public class PacienteControlador {
    
    @Autowired
    private PacienteServicio pacienteServicio;
    
    @GetMapping("/registrar")
    public String registrar(){
        return "paciente_form.html";
    }
    
    @PostMapping("/registro")
    public String registro(@RequestParam String nombreCompleto,@RequestParam String email, 
                           @RequestParam String clave,@RequestParam Long telefono,@RequestParam Rol rol, 
                           @RequestParam MultipartFile archivo,
                           @RequestParam(required = false) String obraSocial) throws MiException{
        
        pacienteServicio.crearPaciente(nombreCompleto, email, clave, telefono, rol, archivo, obraSocial);
        
        return "index.html";
    }
}
