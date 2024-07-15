package com.voll.api.domain.direccion;


import lombok.Getter;


// Using lombok
@Getter

public class Direccion {

   private String calle;
   private String distrito;
   private String ciudad;
   private String numero;
   private String complemento;

   public Direccion() { }

   public Direccion(DatosDireccion direccion) {
      this.calle = direccion.calle();
      this.distrito = direccion.distrito();
      this.ciudad = direccion.ciudad();
      this.numero = direccion.numero();
      this.complemento = direccion.complemento();
   }

   public Direccion actualizarDatos(DatosDireccion direccion) {
      this.calle = direccion.calle();
      this.distrito = direccion.distrito();
      this.ciudad = direccion.ciudad();
      this.numero = direccion.numero();
      this.complemento = direccion.complemento();
      return this;
   }
}
