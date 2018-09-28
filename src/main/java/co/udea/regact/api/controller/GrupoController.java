package co.udea.regact.api.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import co.udea.regact.api.dto.GrupoDto;

import co.udea.regact.api.service.GrupoService;
import co.udea.regact.api.util.Messages;

@RestController
@RequestMapping("/grupos")
public class GrupoController {
	
	private static Logger log = LoggerFactory.getLogger(CursoController.class);
	
	@Autowired
    private Messages messages;
	
	@Autowired
	private GrupoService grupoService;
	
	@GetMapping("/getGruposByDocente")
	public List<GrupoDto> getGruposByDocente(String email){
		log.debug("Entro a consultar grupos para el docente con correo: "+ email);
		return grupoService.getGruposByDocente(email);
	}

}
