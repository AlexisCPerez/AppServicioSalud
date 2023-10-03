
package com.cg.servicioSalud.controladores;

import com.cg.servicioSalud.entidades.Imagen;
import com.cg.servicioSalud.enums.Dia;
import com.cg.servicioSalud.enums.Horario;
import com.cg.servicioSalud.enums.Modalidad;
import com.cg.servicioSalud.enums.Rol;
import com.cg.servicioSalud.servicios.ProfesionalServicio;
import java.util.List;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/profesional")
public class ProfesionalControlador {
    
    @Autowired
    private ProfesionalServicio profesionalServicio;
    
    @GetMapping("/registrar")
    public String registrar(){
        return "profesional_form.html";
    }
    
    @PostMapping("/registro")
    public String registro(@RequestParam String nombreCompleto,@RequestParam String email, 
                           @RequestParam String clave,@RequestParam Long telefono,@RequestParam Rol rol, 
                           @RequestParam Imagen imagen,@RequestParam String idDisponibilidad,
                           @RequestParam Map<Dia,Horario> jornada,
                           @RequestParam List<String> obraSocial,@RequestParam Modalidad modalidad, 
                           @RequestParam String ubicacion,@RequestParam String especialidad,
                           @RequestParam Double tarifa){
        
        profesionalServicio.crearProfesional(nombreCompleto, email, clave, telefono, rol, imagen, idDisponibilidad, jornada, obraSocial, modalidad, ubicacion, especialidad, tarifa);
        
        return "index.html";
    }
}
