package com.voll.api.controller;

import com.voll.api.domain.usuarios.DatosAutenticacionUsuario;
import com.voll.api.domain.usuarios.Usuario;
import com.voll.api.infra.security.DatosJWTToken;
import com.voll.api.infra.security.TokenService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/login")
public class AutenticacionController {
   @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
   private TokenService tokenService;

   @PostMapping
    public ResponseEntity autenticarUsuario(@RequestBody @Valid DatosAutenticacionUsuario datosAutenticacionUsuario)
    {
        Authentication authenticationtoken = new UsernamePasswordAuthenticationToken(datosAutenticacionUsuario.login(),
                                                                                    datosAutenticacionUsuario.clave());
        var usuarioAutenticado = authenticationManager.authenticate(authenticationtoken);
        var jwtToken = tokenService.generarToken((Usuario) usuarioAutenticado.getPrincipal());
        return ResponseEntity.ok(new DatosJWTToken(jwtToken));
    }
}
