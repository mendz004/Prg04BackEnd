package br.com.ifba.prg04backend.controller;

import br.com.ifba.prg04backend.service.UsuarioService;
import br.com.ifba.prg04backend.model.Usuario;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController // Define esta classe como um Controller REST
@RequestMapping("/usuarios") // Define a rota base da API
public class UsuarioController {

    private final UsuarioService usuarioService;

    public UsuarioController(UsuarioService usuarioService) {
        this.usuarioService = usuarioService;

    }

    @PostMapping // Endpoint para criar usuário
    public ResponseEntity<Usuario> criar(@RequestBody Usuario usuario) {

        Usuario usuarioSave = usuarioService.criar(usuario);
        return ResponseEntity.status(HttpStatus.CREATED).body(usuarioSave);

    }

    @GetMapping// Endpoint para listar usuarios
    public ResponseEntity<List<Usuario>> ListarTodos(){

        return ResponseEntity.ok(usuarioService.ListarTodos());
    }

    @GetMapping("/{id}") // Endpoint para buscar por id
    public ResponseEntity<Usuario> BuscarPorID(@PathVariable Long id){

        Optional<Usuario> usuario = usuarioService.BuscarPorID(id);

        return usuario.map(ResponseEntity::ok).orElse(ResponseEntity.notFound().build());

    }

    @GetMapping("/{id}") //Deletar por id
    public ResponseEntity<Void> Deletar(@PathVariable Long id) {

        usuarioService.Deletar(id);

        return ResponseEntity.noContent().build();

    }

    @PutMapping("/{id}") //Altualizar por id
    public ResponseEntity<Usuario> Altualizar(@PathVariable Long id, @RequestBody Usuario usuario) {

        return usuarioService.Altualizar(id, usuario)
                .map(ResponseEntity::ok).orElse(ResponseEntity.notFound().build());


    }
}
