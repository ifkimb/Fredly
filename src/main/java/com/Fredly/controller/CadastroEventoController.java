package com.Fredly.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class CadastroEventoController {
    
    @RequestMapping("/cadastrarEvento")
    public String form(){
        return "formEvento";
    }

}
