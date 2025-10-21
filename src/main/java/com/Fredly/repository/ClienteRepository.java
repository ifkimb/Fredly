package com.Fredly.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.Fredly.model.Cliente;

public interface ClienteRepository extends CrudRepository<Cliente, Long> {

    static List<Cliente> listarTodos() {
        throw new UnsupportedOperationException("Unimplemented method 'listarTodos'");
    }

}
