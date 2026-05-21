package br.com.ifba.prg04backend.service;

import br.com.ifba.prg04backend.model.Usuario;
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
    public Usuario criar(Usuario usuario) {

        try {
            if (usuario.getName() == null) {
                throw new RuntimeException("Nome de Usuario é Obrigátorio");
            } else if (usuario.getEmail() == null) {
                throw new RuntimeException("Email Obrigátorio");
            } else if (usuario.getPassword().length() < 6) {
                throw new RuntimeException("Senha muito Curta");

            }
            return usuarioRepository.save(usuario);

        } catch (Exception e) {

            throw new RuntimeException(
                    "Erro ao criar usuário: " + e.getMessage());
        }

    }

    //Metodo Listar
    public List<Usuario> ListarTodos() {

        return usuarioRepository.findAll();
    }

    public Optional<Usuario> BuscarPorID(Long id) {

        return usuarioRepository.findById(id);

    }

    //Metodo Deletar
    public void Deletar(long id) {


        try {
            if (usuarioRepository.existsById(id)) {
                throw new RuntimeException("Usuario não encontrado");
            }

            usuarioRepository.deleteById(id);


        } catch (Exception e) {
            throw new RuntimeException("Erro ao deletar usuário. " + e.getMessage());

        }


    }

    //metodo Altualizar
    public Optional<Usuario> Altualizar(Long id, Usuario usuario) {

        return usuarioRepository.findById(id).map(usuarioExistente -> {
            usuarioExistente.setName(usuario.getName());
            usuarioExistente.setEmail(usuario.getEmail());
            usuarioExistente.setPassword(usuario.getPassword());

            return usuarioRepository.save(usuarioExistente);
        });
    }
}