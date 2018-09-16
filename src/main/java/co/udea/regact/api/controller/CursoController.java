package co.udea.regact.api.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.Set;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import co.udea.regact.api.domain.Curso;
import co.udea.regact.api.domain.Usuario;
import co.udea.regact.api.exception.DataNotFoundException;
import co.udea.regact.api.service.UsuarioService;
import co.udea.regact.api.util.Messages;

import java.util.function.Predicate;

@RestController
@RequestMapping("/cursos")
public class CursoController {
	
	private static Logger log = LoggerFactory.getLogger(CursoController.class);
	
	@Autowired
    private Messages messages;

	@Autowired
	private UsuarioService usuarioService;


	@GetMapping("/consultarCursosActivosPorNombreUsu")
	public List<Curso> getCursosPorUsuario(String nombre) throws DataNotFoundException{
		log.debug("Entro a consultar curso del usuario: "+ nombre);
		Optional<Usuario> usuario = usuarioService.getUsuario(nombre);
		if(!usuario.isPresent()) {
			throw new DataNotFoundException(messages.get("exception.data_not_found.usuario"));
		}
		
		//Predicado que pregunta por los cursos no activos
		Predicate<Curso> cursoP = p -> p.getEstado() == false;
		Set<Curso> cursos = usuario.get().getCursos();
		
		// Elimina todos los cursos no son activos 
		cursos.removeIf(cursoP);
		
		List<Curso> cursosActivos = new ArrayList<Curso>(cursos);
		
		return cursosActivos;
	}
	
	@GetMapping("/consultarCursosActivosPorIdUsu")
	public List<Curso> getCursosPorUsuario(Integer id) throws DataNotFoundException{
		log.debug("Entro a consultar curso del usuario: "+ id);
		Optional<Usuario> usuario = usuarioService.getUsuarioId(id);
		if(!usuario.isPresent()) {
			throw new DataNotFoundException(messages.get("exception.data_not_found.usuario"));
		}
		
		//Predicado que pregunta por los cursos no activos
		Predicate<Curso> cursoP = p -> p.getEstado() == false;
		Set<Curso> cursos = usuario.get().getCursos();
		
		// Elimina todos los cursos que no son activos 
		cursos.removeIf(cursoP);
		
		List<Curso> cursosActivos = new ArrayList<Curso>(cursos);
		
		return cursosActivos;
	}
	
	
	
}
