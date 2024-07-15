package com.voll.api.domain.medico;

import com.voll.api.domain.direccion.Direccion;
import jakarta.persistence.*;
import lombok.EqualsAndHashCode;
import lombok.Getter;

@Entity(name = "Medico")
@Table(name = "medicos")

// Using lombok
@Getter

@EqualsAndHashCode(of = "id")
public class Medico {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Basic
    private String nombre;
    private String email;
    private String documento;
    private String telefono;
    private Boolean estado;

    @Enumerated(EnumType.STRING)
    private Especialidad especialidad;

    @Embedded
    private Direccion direccion;

    public Medico(){}

    public Medico(DatosRegistroMedico datosRegistroMedico) {
        this.nombre = datosRegistroMedico.nombre();
        this.email = datosRegistroMedico.email();
        this.documento = datosRegistroMedico.documento();
        this.telefono = datosRegistroMedico.telefono();
        this.especialidad = datosRegistroMedico.especialidad();
        this.direccion = new Direccion(datosRegistroMedico.direccion());
        this.estado = true;
    }


    public void actualizarDatos(DatosActualizarMedico datosActualizarMedico) {
        if (datosActualizarMedico.nombre() != null)
        {
            this.nombre = datosActualizarMedico.nombre();
        }
        if (datosActualizarMedico.documento() != null)
        {
            this.documento = datosActualizarMedico.documento();
        }
        if (datosActualizarMedico.direccion() != null)
        {
            this.direccion = direccion.actualizarDatos(datosActualizarMedico.direccion());
        }


    }

    public void desactivarMedico() {
        this.estado = false;
    }
}
