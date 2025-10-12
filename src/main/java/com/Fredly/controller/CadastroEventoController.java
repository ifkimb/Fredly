package com.Fredly.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.Fredly.model.Evento;
import com.Fredly.repository.EventoRepository;

@Controller
public class CadastroEventoController {
    
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
    

}
