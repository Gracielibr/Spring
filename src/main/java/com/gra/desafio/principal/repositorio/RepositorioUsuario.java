package com.gra.desafio.principal.repositorio;

import com.gra.desafio.principal.modelo.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.List;
import java.util.Optional;

@Repository
public interface RepositorioUsuario extends JpaRepository<Usuario, Long> {

    Optional<Usuario> findByMatricula(Long matricula);

    Optional<Usuario> findByNome(String nome);

    List<Usuario> findByNomeContainingIgnoreCase(String nome);

    boolean existsByContaNumero(String numeroConta);

    default Usuario findTopByOrderByMatriculaDesc() {
        return null;
    }
}