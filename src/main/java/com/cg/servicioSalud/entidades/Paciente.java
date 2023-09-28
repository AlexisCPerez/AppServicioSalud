
package com.cg.servicioSalud.entidades;

import java.io.Serializable;
import java.util.List;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.OneToMany;
import lombok.Data;
import lombok.EqualsAndHashCode;
import org.hibernate.annotations.GenericGenerator;
import org.springframework.data.annotation.Id;

@Entity
@Data
@EqualsAndHashCode(callSuper = false)
public class Paciente extends Usuario implements Serializable {
        
    @Id
    @GeneratedValue(generator = "uuid")
    @GenericGenerator(name= "uuid", strategy = "uuid2")
    @javax.persistence.Id
    private String id;
    
    private String obraSocial;
    
    @OneToMany
    private List<HistorialClinico> historial;
    
    
}
