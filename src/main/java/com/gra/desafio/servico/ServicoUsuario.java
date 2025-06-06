package com.gra.desafio.servico;

import com.gra.desafio.principal.modelo.Usuario;

import java.util.List;

public interface ServicoUsuario {

    Usuario buscarPorId(Long id);

    Usuario criar(Usuario usuarioParaCriar);

    Usuario buscarPorMatricula(Long matricula);

    Usuario buscarPorNomeExato(String nome);

    List<Usuario> buscarPorNomeParcial(String nome);
}