package com.Fredly.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.Fredly.model.Evento;
import com.Fredly.repository.EventoRepository;

@Controller
public class CadastroEventoController {
    
    @Autowired
    private EventoRepository er;

    @RequestMapping(value = "/cadastrarEvento", method = RequestMethod.GET)
    public String form(){
        return "formEvento";
    }

     @RequestMapping(value = "/cadastrarEvento", method = RequestMethod.POST)
    public String form(Evento evento){

        er.save(evento);

        return "redirect:/cadastrarEvento";
    }

}
