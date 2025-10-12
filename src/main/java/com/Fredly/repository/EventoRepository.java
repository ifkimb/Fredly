package com.Fredly.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.Fredly.model.Evento;

public interface EventoRepository extends CrudRepository<Evento, Long> {

    static List<Evento> listarTodos() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'listarTodos'");
    }

}
