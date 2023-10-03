
package com.cg.servicioSalud.entidades;

import com.cg.servicioSalud.enums.Rol;
import java.util.Date;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.MappedSuperclass;
import javax.persistence.OneToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import lombok.Data;

@MappedSuperclass
@Data
public abstract class Usuario {
    
    protected String nombreCompleto;
    
    protected String email;
    protected String clave;
    protected Long telefono;
    
    @Enumerated(EnumType.STRING)
    protected Rol rol;
    
    @Temporal(TemporalType.DATE)
    protected Date fechaAlta;
    
    @OneToOne
    protected Imagen imagen;
}
