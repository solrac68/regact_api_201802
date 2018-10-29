package co.udea.regact.api.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


import co.udea.regact.api.dto.ReporteActividadDto;
import co.udea.regact.api.service.ReporteActividadService;

@RestController
@RequestMapping("/reporteactividad")
public class ReporteActividadController {
	
	@Autowired
	private ReporteActividadService reporteControllerService;
	
	@GetMapping("byGrupo/{id}")
	public List<ReporteActividadDto> getReporteActividadesByGrupo(@PathVariable(value = "id") Integer id){
		return reporteControllerService.getReporteActividadesByGrupo(id);
	}
	
	@GetMapping("get/{id}")
	public ReporteActividadDto getReporteActividad(@PathVariable(value = "id") Integer id){
		return reporteControllerService.getReporteActividadById(id);
	}
	
	@GetMapping("sumHorasByGrupo/{id}")
	public Integer getSumHorasReporteActividadesByGrupo(@PathVariable(value = "id") Integer id){
		return reporteControllerService.getSumHorasReporteActividadesByGrupo(id);
	}
	
	@DeleteMapping("/delete/{id}")
	public ResponseEntity<?> deleteReporteActividad(@PathVariable(value = "id") int id) {
		
		reporteControllerService.deleteReporteActividad(id);
		
		return ResponseEntity.ok().build();
	}
	
	@PutMapping("/update")
	public ReporteActividadDto updateReporteActividad(@Valid @RequestBody ReporteActividadDto reporteActividadDto) {
		
		ReporteActividadDto reporteActividadDto2 = 
				reporteControllerService.updateReporteActividad(reporteActividadDto);
		
		return reporteActividadDto2;
	}
	
	@PostMapping("/create")
	public ReporteActividadDto insertReporteActividad(@Valid @RequestBody ReporteActividadDto reporteActividadDto) {
		
		ReporteActividadDto reporteActividadDto2 = 
				reporteControllerService.insertReporteActividad(reporteActividadDto);
		
		return reporteActividadDto2;
	}
	

}
