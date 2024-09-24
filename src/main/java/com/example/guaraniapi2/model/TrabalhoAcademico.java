package com.example.guaraniapi2.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.*;
import lombok.Data;
import org.hibernate.validator.constraints.URL;


import java.time.LocalDate;
import java.util.List;

@Entity
@Data
public class TrabalhoAcademico {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Enumerated(EnumType.STRING)
    @NotNull(message = "O tipo de trabalho é obrigatório")
    private TipoTrabalho tipoTrabalho;

    @NotBlank(message = "O título é obrigatório")
    private String titulo;

    private String subtitulo;

    @NotNull(message = "Os autores são obrigatórios")
    @ElementCollection
    private List<String> autores;

    @NotNull(message = "As palavras-chave são obrigatórias")
    @ElementCollection
    private List<String> palavrasChave;

    @NotNull(message = "A data de submissão é obrigatória")
    private LocalDate dataSubmissao;

    @NotBlank(message = "O resumo é obrigatório")
    @Column(length = 1000)
    private String resumo;

    @NotBlank(message = "O link de publicação é obrigatório")
    @URL(message = "O link deve ser um URL válido")
    private String linkPublicacao;

    @ManyToOne
    private Usuario usuario;
}
