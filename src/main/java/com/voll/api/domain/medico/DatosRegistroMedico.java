package com.voll.api.domain.medico;

import com.voll.api.domain.direccion.DatosDireccion;
import jakarta.validation.Valid;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;

public record DatosRegistroMedico(
    @NotBlank(message = "Nombre es un campo obligatorio")
        String nombre,

    @NotBlank(message = "Email es obligatorio")
    @Email(message = "Formato de email es inválido")
        String email,

    @NotBlank(message = "CRM es obligatorio")
    @Pattern(regexp = "\\d{4,6}", message = "Formato do CRM es inválido")
        String documento,

    @NotNull(message = "Especialidad es obligatorio")
        Especialidad especialidad,

    @NotBlank(message = "Teléfono es obligatorio")
        String telefono,

    @NotNull(message = "Datos de dirección son obligatorios")
    @Valid
        DatosDireccion direccion
) { }
