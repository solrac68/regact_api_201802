package co.udea.regact.api.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.ResponseBody;

import co.udea.regact.api.domain.Usuario;
import co.udea.regact.api.repository.UsuarioRepository;
import co.udea.regact.api.service.UsuarioService;

@Service
@Qualifier("UsuarioServiceImpl")
public class UsuarioServiceImpl implements UsuarioService {
	
	private UsuarioRepository usuarioRepository;
	
	public UsuarioServiceImpl(UsuarioRepository usuarioRepository)
	{
		this.usuarioRepository = usuarioRepository;
	}

	@Override
	public List<Usuario> getUsuarios() {
		return usuarioRepository.findAll();
	}

	@Override
	public Optional<Usuario> getUsuarioId(Integer id) {
		return usuarioRepository.findByid(id);
	}

	@Override
	public Optional<Usuario> getUsuario(String nombre) {
		return usuarioRepository.findBynombre(nombre);
	}

}
