package br.com.ifba.prg04backend.controller;

import br.com.ifba.prg04backend.service.UsuarioService;
import br.com.ifba.prg04backend.model.Usuario;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController // Define esta classe como um Controller REST
@RequestMapping("/usuarios") // Define a rota base da API
public class UsuarioController {

    private final UsuarioService usuarioService;

    public UsuarioController(UsuarioService usuarioService) {
        this.usuarioService = usuarioService;

    }

    @PostMapping // Endpoint para criar usuário
    public ResponseEntity<Usuario> criar(Usuario usuario) {

        Usuario usuarioSave = usuarioService.criar(usuario);
        return ResponseEntity.status(HttpStatus.CREATED).body(usuarioSave);

    }
}
