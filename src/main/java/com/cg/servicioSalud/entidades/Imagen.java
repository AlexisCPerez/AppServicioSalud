
package com.cg.servicioSalud.entidades;

import javax.persistence.Basic;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Lob;
import org.hibernate.annotations.GenericGenerator;
import org.springframework.data.annotation.Id;

public class Imagen {
    
    @Id
    @GeneratedValue(generator = "uuid")
    @GenericGenerator(name = "uuid", strategy = "uuid2")
    private String Id;

    private String mime;

    private String nombre;

    @Lob @Basic(fetch = FetchType.LAZY)
    private byte[] contenido;
}
