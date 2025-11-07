package com.Fredly.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.Fredly.model.Evento;

public interface EventoRepository extends JpaRepository<Evento, Long> {

    static List<Evento> listarTodos() {
        throw new UnsupportedOperationException("Unimplemented method 'listarTodos'");
    }

}
