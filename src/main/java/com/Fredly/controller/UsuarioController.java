package com.Fredly.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class UsuarioController {

    @GetMapping("/cadastrarUsuario")
    public String cadastro() {
        return "cadastro";
    }

    @GetMapping("/loginUsuario")
    public String login() {
        return "login";
    }

}
