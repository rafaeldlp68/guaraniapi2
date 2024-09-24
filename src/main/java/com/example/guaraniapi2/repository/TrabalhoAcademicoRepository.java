package com.example.guaraniapi2.repository;

import com.example.guaraniapi2.model.TrabalhoAcademico;
import com.example.guaraniapi2.model.TipoTrabalho;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;

@Repository
public interface TrabalhoAcademicoRepository extends JpaRepository<TrabalhoAcademico, Long> {

    // Método para buscar trabalhos pelo tipo (Tese, Monografia, etc.)
    List<TrabalhoAcademico> findByTipoTrabalho(TipoTrabalho tipoTrabalho);

    // Método para buscar trabalhos contendo o autor
    List<TrabalhoAcademico> findByAutoresContaining(String autor);

    // Método para buscar trabalhos contendo uma palavra-chave
    List<TrabalhoAcademico> findByPalavrasChaveContaining(String palavraChave);

    // Método para buscar trabalhos dentro de um intervalo de datas de submissão
    List<TrabalhoAcademico> findByDataSubmissaoBetween(LocalDate dataInicio, LocalDate dataFim);
    // O 'dataInicio' marca o começo do intervalo e 'dataFim' o final.
}
