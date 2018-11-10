package co.udea.regact.api.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import co.udea.regact.api.dto.ActividadDTO;
import co.udea.regact.api.service.ActividadService;

@RestController
@RequestMapping("/actividad")
public class ActividadController {
	
	@Autowired
	private ActividadService actividadService;
	
	@GetMapping("getAll")
	public List<ActividadDTO> getAll(){
		return actividadService.getAll();
	}

}
