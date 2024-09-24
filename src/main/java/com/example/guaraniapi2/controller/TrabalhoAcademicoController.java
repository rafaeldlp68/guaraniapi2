package com.example.guaraniapi2.controller;

import com.example.guaraniapi2.model.TrabalhoAcademico;
import com.example.guaraniapi2.model.TipoTrabalho;
import com.example.guaraniapi2.service.TrabalhoAcademicoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/v1/trabalhos-academicos")
@Validated
public class TrabalhoAcademicoController {

    @Autowired
    private TrabalhoAcademicoService trabalhoAcademicoService;

    @PostMapping("/cadastrar")
    public ResponseEntity<TrabalhoAcademico> cadastrarTrabalho(@RequestBody TrabalhoAcademico trabalhoAcademico) {
        TrabalhoAcademico trabalhoSalvo = trabalhoAcademicoService.cadastrarTrabalho(trabalhoAcademico);
        return new ResponseEntity<>(trabalhoSalvo, HttpStatus.CREATED);
    }

    @GetMapping("/listar")
    public ResponseEntity<List<TrabalhoAcademico>> listarTrabalhos() {
        List<TrabalhoAcademico> trabalhos = trabalhoAcademicoService.listarTodos();
        return new ResponseEntity<>(trabalhos, HttpStatus.OK);
    }

    // Pesquisa por Tipo de Trabalho (Categoria)
    @GetMapping("/pesquisa/categoria/{tipo}")
    public ResponseEntity<List<TrabalhoAcademico>> buscarPorCategoria(@PathVariable TipoTrabalho tipo) {
        List<TrabalhoAcademico> trabalhos = trabalhoAcademicoService.buscarPorTipo(tipo);
        return new ResponseEntity<>(trabalhos, HttpStatus.OK);
    }

    // Pesquisa por Autor
    @GetMapping("/pesquisa/autor/{autor}")
    public ResponseEntity<List<TrabalhoAcademico>> buscarPorAutor(@PathVariable String autor) {
        List<TrabalhoAcademico> trabalhos = trabalhoAcademicoService.buscarPorAutor(autor);
        return new ResponseEntity<>(trabalhos, HttpStatus.OK);
    }

    // Pesquisa por Palavras-chave
    @GetMapping("/pesquisa/palavras-chave/{palavraChave}")
    public ResponseEntity<List<TrabalhoAcademico>> buscarPorPalavraChave(@PathVariable String palavraChave) {
        List<TrabalhoAcademico> trabalhos = trabalhoAcademicoService.buscarPorPalavraChave(palavraChave);
        return new ResponseEntity<>(trabalhos, HttpStatus.OK);
    }

    // Pesquisa por Data de Publicação (início e fim)
    @GetMapping("/pesquisa/data-publicacao")
    public ResponseEntity<List<TrabalhoAcademico>> buscarPorDataPublicacao(
            @RequestParam("inicio") String dataInicio,
            @RequestParam("fim") String dataFim) {
        LocalDate inicio = LocalDate.parse(dataInicio);
        LocalDate fim = LocalDate.parse(dataFim);
        List<TrabalhoAcademico> trabalhos = trabalhoAcademicoService.buscarPorDataPublicacao(inicio, fim);
        return new ResponseEntity<>(trabalhos, HttpStatus.OK);
    }
}
