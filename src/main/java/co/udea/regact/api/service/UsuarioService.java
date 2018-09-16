package co.udea.regact.api.service;

import java.util.List;
import java.util.Optional;

import co.udea.regact.api.domain.Usuario;

public interface UsuarioService {
	public List<Usuario> getUsuarios();
	public Optional<Usuario> getUsuarioId(Integer id);
	public Optional<Usuario> getUsuario(String nombre);
}
