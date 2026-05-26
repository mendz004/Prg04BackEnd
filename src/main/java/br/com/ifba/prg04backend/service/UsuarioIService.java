package br.com.ifba.prg04backend.service;

import br.com.ifba.prg04backend.model.Usuario;

import java.util.List;
import java.util.Optional;

public interface UsuarioIService {

     Usuario save(Usuario usuario);

     List<Usuario> findAll();

     Optional<Usuario> findById(Long id);

     void delete(long id);

     Optional<Usuario> update(Long id, Usuario usuario);

}
