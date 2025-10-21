package com.Fredly.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import com.Fredly.model.Cliente;
import com.Fredly.repository.ClienteRepository;

@Controller
public class ClienteController {
    
    @Autowired
    private ClienteRepository er;

    @GetMapping("/cadastrarCliente")
    public String formCliente() {
        return "formCliente";
    }


    @PostMapping("/cadastrarCliente")
    public String salvarCliente(Cliente cliente) {
        er.save(cliente);
        return "redirect:/listaClientes";
    }


     @GetMapping("/listaClientes")
    public String inicio(Model model) {
        List<Cliente> clientes = (List<Cliente>) er.findAll();
        model.addAttribute("clientes", clientes);
        return "listaClientes"; 
    }
    
}

