package com.example.guaraniapi2.repository;

import com.example.guaraniapi2.model.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Repositório responsável por realizar operações de banco de dados relacionadas à entidade Usuario.
 * A interface JpaRepository já traz métodos prontos como save(), findAll(), findById(), etc.
 */
public interface UsuarioRepository extends JpaRepository<Usuario, Long> {
    // Métodos customizados podem ser adicionados aqui se necessário
}
