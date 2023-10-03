
package com.cg.servicioSalud.entidades;

import com.cg.servicioSalud.enums.Modalidad;
import java.util.List;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import lombok.Data;
import org.hibernate.annotations.GenericGenerator;

@Entity
@Data
public class Profesional extends Usuario {
    
    @Id
    @GeneratedValue(generator = "uuid")
    @GenericGenerator(name= "uuid", strategy = "uuid2")
    private String id;
    
    private Double reputacion;
    
    private Double tarifa;
    
    @Enumerated(EnumType.STRING)
    private Modalidad modalidad;
    
    private String ubicacion;
    
    @ElementCollection
    private List<String> obrasSociales;
    
    private String especialidad;
    
    private Boolean activo; // true = alta; false = baja
}
