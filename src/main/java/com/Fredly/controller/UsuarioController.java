package com.Fredly.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.Fredly.model.Usuario;
import com.Fredly.repository.UsuarioRepository;

import jakarta.servlet.http.HttpServletResponse;

import org.springframework.web.bind.annotation.PostMapping;



@Controller
public class UsuarioController {

    @Autowired
    private UsuarioRepository ur;

    @GetMapping("/cadastrarUsuario")
    public String cadastro() {
        return "cadastro";
    }

    @RequestMapping(value = "/cadastrarUsuario", method=RequestMethod.POST)
    public String cadastrarUsuario(@Validated Usuario usuario, BindingResult result) {
        if (result.hasErrors()) {
            return "cadastro";
        }
        ur.save(usuario);
        return "redirect:/loginUsuario";
    }
    
    @GetMapping("/loginUsuario")
    public String login() {
        return "login";
    }

    @PostMapping("logarUsuario")
    public String logarUsuario(Usuario usuario, Model model, HttpServletResponse response) {
        Usuario usuarioLogado = ur.login(usuario.getEmail(), usuario.getSenha());
        if (usuarioLogado != null) {
           return "redirect:/inicio";
        }
        model.addAttribute("erro", "Email ou senha inválidos");
            return "login";    
        
    }
    }


