package com.example.guaraniapi2.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.*;
import lombok.Data;

/**
 * Entidade que representa o usuário no sistema. Utilizamos a anotação @Data do Lombok para
 * gerar automaticamente os getters, setters, equals, hashcode e toString.
 */
@Entity
@Data // Lombok gera automaticamente getters, setters, equals, hashCode, e toString
public class Usuario {

    /**
     * Identificador único do usuário, gerado automaticamente pelo banco de dados.
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) // Gera automaticamente o ID
    private Long id;

    /**
     * Nome do usuário. O campo é obrigatório e não pode estar em branco.
     */
    @NotBlank(message = "O nome é obrigatório") // Valida se o campo não está vazio ou em branco
    private String nome;

    /**
     * RA ou matrícula do usuário. Campo obrigatório.
     */
    @NotBlank(message = "O RA ou matrícula é obrigatório") // Valida se o RA/matrícula não está vazio
    private String ra;

    /**
     * Instituição de ensino ou trabalho do usuário. Campo obrigatório.
     */
    @NotBlank(message = "A instituição é obrigatória") // Valida se a instituição foi preenchida
    private String instituicao;

    /**
     * Email do usuário. O campo é obrigatório e deve estar em formato válido.
     */
    @NotBlank(message = "O email é obrigatório") // Valida se o email foi preenchido
    @Email(message = "O email deve ser válido") // Valida se o email tem um formato válido
    private String email;

    /**
     * Senha do usuário. O campo é obrigatório.
     */
    @NotBlank(message = "A senha é obrigatória") // Valida se a senha foi preenchida
    private String senha;

    /**
     * Tipo de usuário, que pode ser aluno ou professor. O campo é obrigatório.
     */
    @NotBlank(message = "O tipo de usuário é obrigatório") // Valida se o tipo de usuário foi especificado
    private String tipoUsuario;
}
