package com.gra.desafio.servico.imp;

import com.gra.desafio.principal.modelo.Usuario;
import com.gra.desafio.principal.repositorio.RepositorioUsuario;
import com.gra.desafio.servico.ServicoUsuario;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.NoSuchElementException;

@Service
public class ServicoUsuarioImp implements ServicoUsuario {

    private final RepositorioUsuario repositorioUsuario;

    public ServicoUsuarioImp(RepositorioUsuario repositorioUsuario) {
        this.repositorioUsuario = repositorioUsuario;
    }

    @Override
    public Usuario buscarPorId(Long id) { // findById → buscarPorId
        return repositorioUsuario.findById(id).orElseThrow(NoSuchElementException::new);
    }

    @Override
    public Usuario criar(Usuario usuarioParaCriar) {
        if (repositorioUsuario.existsByContaNumero(usuarioParaCriar.getConta().getNumero())) {
            throw new IllegalArgumentException("Este número de conta já existe."); // Mensagem traduzida
        }
        return repositorioUsuario.save(usuarioParaCriar);
    }

    @Override
    public Usuario buscarPorMatricula(Long matricula) {
        return repositorioUsuario.findByMatricula(matricula)
                .orElseThrow(() -> new NoSuchElementException("Matrícula não encontrada"));
    }

    @Override
    public Usuario buscarPorNomeExato(String nome) {
        return repositorioUsuario.findByNome(nome)
                .orElseThrow(() -> new NoSuchElementException("Usuário não encontrado"));
    }

    @Override
    public List<Usuario> buscarPorNomeParcial(String nome) {
        return repositorioUsuario.findByNomeContainingIgnoreCase(nome);
    }
}