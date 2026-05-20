package br.com.ifba.prg04backend.service;

import br.com.ifba.prg04backend.model.Usuario;
import org.springframework.stereotype.Service;
import br.com.ifba.prg04backend.repository.UsuarioRepository;
import javax.swing.*;

@Service
public class UsuarioService {

    private final UsuarioRepository usuarioRepository;

    public UsuarioService(UsuarioRepository usuarioRepository) {
        this.usuarioRepository = usuarioRepository;
    }

    public Usuario criar(Usuario usuario) {

        try {
            if (usuario.getName() == null) {
                throw new RuntimeException("Nome de Usuario é Obrigátorio");
            }

            else if(usuario.getEmail() == null) {
                throw new RuntimeException("Email Obrigátorio");
            }

            else if (usuario.getPassword().length() < 6){
                throw new RuntimeException("Senha muito Curta");

            }
            return usuarioRepository.save(usuario);

        } catch (Exception e) {

            throw new RuntimeException(
                    "Erro ao criar usuário: " + e.getMessage());
        }

    }
}
