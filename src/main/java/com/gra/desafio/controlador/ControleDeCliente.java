package com.gra.desafio.controlador;

import com.gra.desafio.principal.modelo.Usuario;
import com.gra.desafio.servico.ServicoUsuario;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/usuarios")
@Tag(name = "Controle de Clientes")
public class ControleDeCliente {

    private final ServicoUsuario servicoUsuario;

    public ControleDeCliente(ServicoUsuario servicoUsuario) {
        this.servicoUsuario = servicoUsuario;
    }


    @PostMapping
    public ResponseEntity<Usuario> criar(@RequestBody Usuario usuarioParaCriar) {
        // Remove a matrícula se foi enviada no request
        usuarioParaCriar.setMatricula(null);

        Usuario usuarioCriado = servicoUsuario.criar(usuarioParaCriar);

        return ResponseEntity.status(HttpStatus.CREATED)
                .body(usuarioCriado); // Retorna o objeto com a matrícula gerada
    }

    @GetMapping("matricula")
    public ResponseEntity<Usuario> buscarPorMatricula(@PathVariable Long matricula) {
        var usuario = servicoUsuario.buscarPorMatricula(matricula);
        return ResponseEntity.ok(usuario);
    }


    @GetMapping("nome")
    public ResponseEntity<List<Usuario>> buscarPorNomeParcial(@PathVariable String nome) {
        var usuarios = servicoUsuario.buscarPorNomeParcial(nome);
        return ResponseEntity.ok(usuarios);
    }


}