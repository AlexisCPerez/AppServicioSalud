
package com.cg.servicioSalud.entidades;

import com.cg.servicioSalud.enums.Horario;
import java.util.Date;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import lombok.Data;
import org.hibernate.annotations.GenericGenerator;
import org.springframework.data.annotation.Id;

@Entity
@Data
public class Disponibilidad {
    
    @Id
    @GeneratedValue(generator = "uuid")
    @GenericGenerator(name= "uuid", strategy = "uuid2")
    protected String id;
    
    private Date dia;
    
    private Horario horario;
    
    
}
