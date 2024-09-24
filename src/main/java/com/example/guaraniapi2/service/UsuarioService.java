package com.example.guaraniapi2.service;

import com.example.guaraniapi2.model.Usuario;
import com.example.guaraniapi2.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

/**
 * Classe de serviço responsável por conter a lógica de negócio relacionada ao cadastro e gerenciamento de usuários.
 */
@Service
public class UsuarioService {

    @Autowired
    private UsuarioRepository usuarioRepository;

    /**
     * Método responsável por cadastrar um novo usuário no sistema.
     * @param usuario Objeto Usuario a ser cadastrado
     * @return Usuario cadastrado
     */
    public Usuario cadastrarUsuario(Usuario usuario) {
        // Aqui você pode adicionar lógica de negócio, como criptografia de senha
        return usuarioRepository.save(usuario); // Salva o usuário no banco de dados
    }

    /**
     * Método responsável por listar todos os usuários cadastrados.
     * @return Lista de usuários
     */
    public List<Usuario> listarUsuarios() {
        return usuarioRepository.findAll(); // Busca todos os usuários no banco
    }

    /**
     * Método responsável por buscar um usuário específico pelo ID.
     * @param id ID do usuário
     * @return Optional contendo o usuário encontrado, ou vazio caso não exista
     */
    public Optional<Usuario> buscarUsuarioPorId(Long id) {
        return usuarioRepository.findById(id); // Busca o usuário pelo ID
    }
}
