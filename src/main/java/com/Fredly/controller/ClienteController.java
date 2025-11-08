package com.Fredly.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.Fredly.model.Cliente;
import com.Fredly.model.Evento;
import com.Fredly.repository.ClienteRepository;

@Controller
public class ClienteController {
    
    @Autowired
    private ClienteRepository cr;

    @GetMapping("/cadastrarCliente")
    public String formCliente() {
        return "formCliente";
    }


    @PostMapping("/cadastrarCliente")
    public String salvarCliente(Cliente cliente) {
        cr.save(cliente);
        return "redirect:/listaClientes";
    }


     @GetMapping("/listaClientes")
    public String inicio(Model model) {
        List<Cliente> clientes = (List<Cliente>) cr.findAll();
        model.addAttribute("clientes", clientes);
        return "listaClientes"; 
    }

     @PostMapping("/deletarCliente/{id_cliente}")
    public String deletarCliente(@PathVariable Long id_cliente) {
        cr.deleteById(id_cliente);
        return "redirect:/listaClientes";
    }

    @GetMapping("/editarCliente/{id_cliente}")
    public String editarCliente(@PathVariable Long id_cliente, Model model) {
        Cliente cliente = cr.findById(id_cliente)
                .orElseThrow(() -> new IllegalArgumentException("Cliente inválido: " + id_cliente));
        model.addAttribute("cliente", cliente);
        return "editarCliente";
    }

    @PostMapping("/editarCliente/{id_cliente}")
    public String atualizarCliente(@PathVariable Long id_cliente, @ModelAttribute Cliente clienteAtualizado) {
        Cliente cliente = cr.findById(id_cliente)
                .orElseThrow(() -> new IllegalArgumentException("Cliente inválido: " + id_cliente));

        cliente.setNomecliente(clienteAtualizado.getNomecliente());
        cliente.setEmail(clienteAtualizado.getEmail());
        cliente.setTelefone(clienteAtualizado.getTelefone());
        cliente.setStatus(clienteAtualizado.getStatus());
        cliente.setObservacoes(clienteAtualizado.getObservacoes());

        

        cr.save(cliente);
        return "redirect:/listaClientes";
    }
    
}

