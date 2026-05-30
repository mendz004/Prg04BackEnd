package br.com.ifba.prg04backend.controller;

import br.com.ifba.prg04backend.dto.UsuarioGetResponseDto;
import br.com.ifba.prg04backend.dto.UsuarioPostRequestDto;
import br.com.ifba.prg04backend.infrastructure.mapper.ObjectMapperUtil;
import br.com.ifba.prg04backend.service.UsuarioService;
import br.com.ifba.prg04backend.model.Usuario;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController // Define esta classe como um Controller REST
@RequestMapping("/usuarios") // Define a rota base da API
public class UsuarioController {

    private final UsuarioService usuarioService;
    private final ObjectMapperUtil objectMapperUtil;


    public UsuarioController(UsuarioService usuarioService, ObjectMapperUtil objectMapperUtil) {
        this.usuarioService = usuarioService;
        this.objectMapperUtil = objectMapperUtil;
    }

    @PostMapping("/save") // Endpoint para criar usuário
    public ResponseEntity<UsuarioGetResponseDto> save(@RequestBody @Valid UsuarioPostRequestDto usuarioPostRequestDto) {

        Usuario usuarioSave = usuarioService.save(objectMapperUtil
                .map(usuarioPostRequestDto, Usuario.class));


        return ResponseEntity.status(HttpStatus.CREATED)
                .body(objectMapperUtil.map(usuarioSave, UsuarioGetResponseDto.class));

    }

    @GetMapping// Endpoint para listar usuarios
    public ResponseEntity<List<UsuarioGetResponseDto>> findAll() {

        return ResponseEntity.status(HttpStatus.OK).body(objectMapperUtil.mapAll
                (this.usuarioService.findAll(),
                        UsuarioGetResponseDto.class));

    }

    @GetMapping("/{id}") // Endpoint para buscar por id
    public ResponseEntity<UsuarioGetResponseDto> findById(@PathVariable Long id) {

        return ResponseEntity.status(HttpStatus.OK).body(objectMapperUtil.map
                (this.usuarioService.findById(id), UsuarioGetResponseDto.class));
    }

    @DeleteMapping("/{id}") //Deletar por id
    public ResponseEntity<Void> delete(@PathVariable Long id) {

        usuarioService.delete(id);

        return ResponseEntity.noContent().build();

    }

    @PutMapping("/{id}") //Altualizar por id
    public ResponseEntity<Usuario> update(@PathVariable Long id, @RequestBody Usuario usuario) {

        return usuarioService.update(id, usuario)
                .map(ResponseEntity::ok).orElse(ResponseEntity.notFound().build());


    }
}
