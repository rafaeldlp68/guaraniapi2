package com.example.guaraniapi2.controller;

import com.example.guaraniapi2.model.Usuario;
import com.example.guaraniapi2.service.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import jakarta.validation.Valid;
import java.util.List;

/**
 * Controlador REST responsável por expor os endpoints da API relacionados ao gerenciamento de usuários.
 */
@RestController
@RequestMapping("/api/v1/usuarios")
public class UsuarioController {

    @Autowired
    private UsuarioService usuarioService;

    /**
     * Endpoint para cadastrar um novo usuário.
     * O corpo da requisição deve conter os dados do usuário e deve passar pela validação antes de ser processado.
     * @param usuario Objeto Usuario com os dados a serem cadastrados
     * @return ResponseEntity contendo o usuário cadastrado e o status HTTP 201 (Created)
     */
    @PostMapping("/cadastrar")
    public ResponseEntity<Usuario> cadastrarUsuario(@Valid @RequestBody Usuario usuario) {
        Usuario usuarioSalvo = usuarioService.cadastrarUsuario(usuario); // Chama o serviço para salvar o usuário
        return new ResponseEntity<>(usuarioSalvo, HttpStatus.CREATED); // Retorna o usuário salvo e o status 201 (Created)
    }

    /**
     * Endpoint para listar todos os usuários cadastrados no sistema.
     * @return ResponseEntity contendo a lista de usuários e o status HTTP 200 (OK)
     */
    @GetMapping("/listar")
    public ResponseEntity<List<Usuario>> listarUsuarios() {
        List<Usuario> usuarios = usuarioService.listarUsuarios(); // Chama o serviço para listar os usuários
        return new ResponseEntity<>(usuarios, HttpStatus.OK); // Retorna a lista de usuários e o status 200 (OK)
    }

    /**
     * Endpoint para buscar um usuário pelo ID.
     * @param id ID do usuário a ser buscado
     * @return ResponseEntity contendo o usuário encontrado e o status HTTP 200 (OK) ou 404 (Not Found) se não encontrado
     */
    @GetMapping("/{id}")
    public ResponseEntity<Usuario> buscarUsuarioPorId(@PathVariable Long id) {
        return usuarioService.buscarUsuarioPorId(id) // Chama o serviço para buscar o usuário pelo ID
            .map(usuario -> new ResponseEntity<>(usuario, HttpStatus.OK)) // Retorna o usuário encontrado e o status 200 (OK)
            .orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND)); // Retorna 404 se o usuário não for encontrado
    }
}
