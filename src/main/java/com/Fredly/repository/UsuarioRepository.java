package com.Fredly.repository;
 
import java.util.Optional;
 
import org.springframework.data.jpa.repository.JpaRepository;
 
import com.Fredly.model.Usuario;
 
public interface UsuarioRepository extends JpaRepository<Usuario, String> {
    Optional<Usuario> findByEmail(String email);
}