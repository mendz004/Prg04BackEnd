package br.com.ifba.prg04backend.service;

import br.com.ifba.prg04backend.infrastructure.exception.BusinessException;
import br.com.ifba.prg04backend.model.Usuario;
import jakarta.transaction.Transactional;
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
    @Transactional
    public Usuario save(Usuario usuario) {

        boolean emailExistente = usuarioRepository.existsByEmail(usuario.getEmail());

        if (emailExistente) {
            throw new BusinessException("Email já Cadastrado");
        } else
            return usuarioRepository.save(usuario);

    }

    //Metodo Listar
    public List<Usuario> findAll() {

        return usuarioRepository.findAll();
    }

    public Usuario findById(Long id) {

        return usuarioRepository.findById(id).orElseThrow(() -> new BusinessException("Usuario não encontrado"));

    }

    //Metodo Deletar
    public void delete(long id) {

        if (!usuarioRepository.existsById(id)) {
            throw new BusinessException(
                    "Usuário não encontrado!");
        }

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