package co.udea.regact.api.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import co.udea.regact.api.dto.GrupoDto;

import co.udea.regact.api.service.GrupoService;
import co.udea.regact.api.util.Messages;

@RestController
@RequestMapping("/grupos")
public class GrupoController {
	
	private static Logger log = LoggerFactory.getLogger(GrupoController.class);
	
	//@Autowired
    //private Messages messages;
	
	@Autowired
	private GrupoService grupoService;
	
	@GetMapping("getGruposByDocente/{id}")
	public List<GrupoDto> getGruposByDocente(@PathVariable(value = "id") Integer id){
		log.debug("Entro a consultar grupos para el docente con id: "+ id.toString());
		return grupoService.getGruposByDocente(id);
	}
	
	@GetMapping("getGruposActivosByDocente/{id}")
	public List<GrupoDto> getGruposActivosByDocente(@PathVariable(value = "id") Integer id){
		log.debug("Entro a consultar grupos activos para el docente con id: "+ id);
		return grupoService.getGruposActivosByDocente(id);
	}
	
	@GetMapping("get/{id}")
	public GrupoDto getGrupoById(@PathVariable(value = "id") Integer id){
		log.debug("Entro a consultar el grupo: "+ id);
		return grupoService.getGrupoById(id);
	}
	
	

}
