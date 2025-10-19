package com.Fredly.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.Fredly.model.Evento;
import com.Fredly.repository.EventoRepository;

@Controller
public class EventoController {
    
    @Autowired
    private EventoRepository er;

    @GetMapping("/cadastrarEvento")
    public String form() {
        return "formEvento";
    }

     @PostMapping("/cadastrarEvento")
    public String salvarEvento(Evento evento) {
        er.save(evento);
        return "redirect:/inicio";
    }


     @GetMapping("/inicio")
    public String inicio(Model model) {
        List<Evento> eventos = (List<Evento>) er.findAll();
        model.addAttribute("eventos", eventos);
        return "inicio"; 
    }
    
    @GetMapping("/detalhesEvento/{codigo}")
    public String detalhesEvento(@PathVariable Long codigo, Model model) {
        Evento evento = er.findById(codigo).orElse(null);
        model.addAttribute("evento", evento);
        return "detalhesEvento";
    }
    
}
