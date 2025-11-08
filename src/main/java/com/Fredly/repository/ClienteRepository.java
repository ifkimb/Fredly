package com.Fredly.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.Fredly.model.Cliente;

public interface ClienteRepository extends JpaRepository<Cliente, Long> {

    static List<Cliente> listarTodos() {
        throw new UnsupportedOperationException("Unimplemented method 'listarTodos'");
    }

}
