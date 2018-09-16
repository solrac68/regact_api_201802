package co.udea.regact.api.controller;

import java.util.List;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import co.udea.regact.api.domain.Usuario;
import co.udea.regact.api.exception.DataNotFoundException;
import co.udea.regact.api.service.UsuarioService;
import co.udea.regact.api.util.Messages;

@RestController
@RequestMapping("/usuarios")
public class UsuarioController {
	
	private static Logger log = LoggerFactory.getLogger(CursoController.class);

	@Autowired
    private Messages messages;	
	
	@Autowired
	private UsuarioService usuarioService;
	
	@RequestMapping("listar")
	public @ResponseBody List<Usuario> geUsuarios(){
		return usuarioService.getUsuarios();		
	}
	

	@RequestMapping("consultarPorId")
	public Usuario getUsuario(Integer id) throws DataNotFoundException{
		log.debug("Entro a consultar");
		Optional<Usuario> usuario = usuarioService.getUsuarioId(id);
		if(!usuario.isPresent()) {
			throw new DataNotFoundException(messages.get("exception.data_not_found.usuario"));
		}
		return usuario.get();
	}
	
	@RequestMapping("consultarPorNombre")
	public Usuario getUsuario(String nombre) throws DataNotFoundException{
		log.debug("Entro a consultar");
		Optional<Usuario> usuario = usuarioService.getUsuario(nombre);
		if(!usuario.isPresent()) {
			throw new DataNotFoundException(messages.get("exception.data_not_found.usuario by name"));
		}
		return usuario.get();
	}

}
