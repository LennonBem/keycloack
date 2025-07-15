package com.example.authkeycloackapi.Controller;

import jakarta.annotation.security.PermitAll;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.oauth2.jwt.Jwt;
import org.springframework.security.oauth2.jwt.JwtDecoder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;
import java.util.stream.Collectors;


@RestController
@RequestMapping("/api/resources")
public class Teste {



    @GetMapping("/public")
    String testeAcessoRecursoPublico(){
        Map<String,String> retornoBancodeDados = new HashMap<>();
        retornoBancodeDados.put("id","1");
        retornoBancodeDados.put("nome","Banco 1");
        return "Olá Matheus! " + retornoBancodeDados;
    }

    @GetMapping("/private")
    String testeAcessoRecursoPrivado(@AuthenticationPrincipal Jwt jwt){
        return "Endpoint privado acessado com sucesso!";
    }

    @GetMapping("/private/admin")
    @PreAuthorize("hasAuthority('ROLES_admin')")
    String testeAcessoRecursoPrivadoComAutorizacaoAdm(Authentication authentication){

        return "Endpoint privado com acessado com sucesso! ";
    }

    @GetMapping("/private/user")
    @PreAuthorize("hasAuthority('ROLES_user')")
    String testeAcessoRecursoPrivadoComAutorizacaoUser(Authentication authentication){

        return "Endpoint privado com acessado com sucesso!";
    }
}
