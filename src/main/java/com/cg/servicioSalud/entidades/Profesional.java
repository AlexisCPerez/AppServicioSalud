
package com.cg.servicioSalud.entidades;

import com.cg.servicioSalud.enums.Modalidad;
import java.util.List;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.OneToMany;
import lombok.Data;
import org.hibernate.annotations.GenericGenerator;
import org.springframework.data.annotation.Id;

@Entity
@Data
public class Profesional extends Usuario {
    
    @Id
    @GeneratedValue(generator = "uuid")
    @GenericGenerator(name= "uuid", strategy = "uuid2")
    protected String id;
    
    private Double reputacion;
    
    private Integer tarifa;
    
    @OneToMany
    private List<Disponibilidad> disponibilidad;
    
    @Enumerated(EnumType.STRING)
    private Modalidad modalidad;
    
    private String ubicacion;
    
    @OneToMany
    private List<String> obrasSociales;
    
    private String especialidad;
    
    private Boolean estado; // true = alta; false = baja
}
