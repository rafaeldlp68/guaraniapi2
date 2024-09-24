package com.example.guaraniapi2.service;

import com.example.guaraniapi2.model.TrabalhoAcademico;
import com.example.guaraniapi2.model.TipoTrabalho;
import com.example.guaraniapi2.repository.TrabalhoAcademicoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@Service
public class TrabalhoAcademicoService {

    @Autowired
    private TrabalhoAcademicoRepository trabalhoAcademicoRepository;

    // Método para cadastrar um novo trabalho acadêmico
    public TrabalhoAcademico cadastrarTrabalho(TrabalhoAcademico trabalhoAcademico) {
        return trabalhoAcademicoRepository.save(trabalhoAcademico);  // Salva o trabalho no banco de dados
    }

    // Método para listar todos os trabalhos cadastrados
    public List<TrabalhoAcademico> listarTodos() {
        return trabalhoAcademicoRepository.findAll();  // Retorna todos os trabalhos
    }

    // Método para buscar um trabalho por ID
    public Optional<TrabalhoAcademico> buscarPorId(Long id) {
        return trabalhoAcademicoRepository.findById(id);  // Retorna um trabalho específico se encontrado
    }

    // Método para buscar trabalhos por tipo (Tese, Dissertação, Monografia, etc.)
    public List<TrabalhoAcademico> buscarPorTipo(TipoTrabalho tipoTrabalho) {
        return trabalhoAcademicoRepository.findByTipoTrabalho(tipoTrabalho);  // Busca por tipo de trabalho
    }

    // Método para buscar trabalhos que contenham o nome do autor
    public List<TrabalhoAcademico> buscarPorAutor(String autor) {
        return trabalhoAcademicoRepository.findByAutoresContaining(autor);  // Busca trabalhos onde o autor está presente
    }

    // Método para buscar trabalhos com palavras-chave específicas
    public List<TrabalhoAcademico> buscarPorPalavraChave(String palavraChave) {
        return trabalhoAcademicoRepository.findByPalavrasChaveContaining(palavraChave);  // Busca por palavras-chave
    }

    // Método para buscar trabalhos acadêmicos dentro de um intervalo de datas de submissão
    public List<TrabalhoAcademico> buscarPorDataPublicacao(LocalDate dataInicio, LocalDate dataFim) {
        return trabalhoAcademicoRepository.findByDataSubmissaoBetween(dataInicio, dataFim);  
        // Retorna os trabalhos cuja data de submissão está entre 'dataInicio' e 'dataFim'
    }
}
