package co.udea.regact.api.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import co.udea.regact.api.domain.Curso;
import co.udea.regact.api.service.CursoService;
import co.udea.regact.api.util.Messages;

@RestController
@RequestMapping("/cursos")
public class CursoController {
	
private static Logger log = LoggerFactory.getLogger(GrupoController.class);
	
	@Autowired
    private Messages messages;
	
	@Autowired
	private CursoService cursoService;
	
	@GetMapping("/getCurso")
	public Curso getCursoById(String id){
		log.debug("Entro a consultar grupos para el docente con correo: "+ id.toString());
		return cursoService.getCurso(Integer.valueOf(id));
	}
	
	@PostMapping(path = "/setCurso")
	public void setCurso(@RequestBody Curso curso){
		log.debug("Entro a insertar curso : "+ curso.getNombre());
		cursoService.saveCurso(curso);
	}

}
