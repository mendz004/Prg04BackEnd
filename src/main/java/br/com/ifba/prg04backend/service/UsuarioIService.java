package br.com.ifba.prg04backend.service;

import br.com.ifba.prg04backend.model.Usuario;

import java.util.List;
import java.util.Optional;

public interface UsuarioIService {

     Usuario criar(Usuario usuario);

     List<Usuario> ListarTodos();

     Optional<Usuario> BuscarPorID(Long id);

     void Deletar(long id);

     Optional<Usuario> Altualizar(Long id, Usuario usuario);

}
