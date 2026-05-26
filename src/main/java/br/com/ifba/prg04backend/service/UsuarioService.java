package br.com.ifba.prg04backend.service;

import br.com.ifba.prg04backend.infrastructure.exception.BusinessException;
import br.com.ifba.prg04backend.model.Usuario;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import br.com.ifba.prg04backend.repository.UsuarioRepository;

import javax.swing.*;
import java.util.List;
import java.util.Optional;

@Service
public class UsuarioService implements UsuarioIService {

    private final UsuarioRepository usuarioRepository;

    public UsuarioService(UsuarioRepository usuarioRepository) {
        this.usuarioRepository = usuarioRepository;
    }

    //Metodo Listar
    public Usuario save(Usuario usuario) {

        return usuarioRepository.save(usuario);

    }

    //Metodo Listar
    public List<Usuario> findAll() {

        return usuarioRepository.findAll();
    }

    public Optional<Usuario> findById(Long id) {

        return usuarioRepository.findById(id);

    }

    //Metodo Deletar
    public void delete(long id) {


        usuarioRepository.deleteById(id);


    }

    //metodo Altualizar
    public Optional<Usuario> update(Long id, Usuario usuario) {

        return usuarioRepository.findById(id).map(usuarioExistente -> {
            usuarioExistente.setName(usuario.getName());
            usuarioExistente.setEmail(usuario.getEmail());
            usuarioExistente.setPassword(usuario.getPassword());

            return usuarioRepository.save(usuarioExistente);
        });
    }
}