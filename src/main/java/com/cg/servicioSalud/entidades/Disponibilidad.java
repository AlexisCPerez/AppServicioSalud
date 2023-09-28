
package com.cg.servicioSalud.entidades;

import com.cg.servicioSalud.enums.Dia;
import com.cg.servicioSalud.enums.Horario;
import java.util.Map;
import javax.persistence.CollectionTable;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.GeneratedValue;
import javax.persistence.JoinColumn;
import javax.persistence.MapKeyEnumerated;
import lombok.Data;
import org.hibernate.annotations.GenericGenerator;
import org.springframework.data.annotation.Id;

@Entity
@Data
public class Disponibilidad {
    
    @Id
    @GeneratedValue(generator = "uuid")
    @GenericGenerator(name= "uuid", strategy = "uuid2")
    private String id;
    
    @ElementCollection
    @CollectionTable(name = "disponibilidad_jornada", joinColumns = @JoinColumn(name = "disponibilidad_id"))
    @MapKeyEnumerated(EnumType.STRING) // Specify the EnumType if Dia is an enum
    
    Map <Dia, Horario> Jornada; //Posible cambio
    
}
