package com.Fredly.repository;
 

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import com.Fredly.model.Usuario;

public interface UsuarioRepository extends CrudRepository<Usuario, String> {
    Usuario findByEmail(String email);

   @Query("SELECT u FROM Usuario u WHERE u.email = :email AND u.senha = :senha")
    Usuario login(@Param("email") String email, @Param("senha") String senha);
}