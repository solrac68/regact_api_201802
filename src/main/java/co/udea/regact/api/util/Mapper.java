package co.udea.regact.api.util;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import co.udea.regact.api.domain.Actividad;
import co.udea.regact.api.domain.Curso;
import co.udea.regact.api.domain.Grupo;
import co.udea.regact.api.domain.ReporteActividad;
import co.udea.regact.api.domain.Semestre;
import co.udea.regact.api.dto.ActividadDTO;
import co.udea.regact.api.dto.GrupoDto;
import co.udea.regact.api.dto.ReporteActividadDto;

public class Mapper {
	public static List<GrupoDto> MapGrupos(List<Grupo> grupos){
		List<GrupoDto> gruposDto = new ArrayList<>();
		for(Grupo grupo : grupos) {
			gruposDto.add(MapGrupo(grupo));
		}
		
		return gruposDto;
	}
	
	public static GrupoDto MapGrupo(Grupo grupo) {
		GrupoDto grupoDto = new GrupoDto();
		Semestre semestre = grupo.getSemestre();
		Curso curso = grupo.getCurso();
		
		grupoDto.setCorreoDocente(grupo.getDocente() != null ? grupo.getDocente().getEmail():"");
		grupoDto.setSemestre(semestre != null ? semestre.getSemestre():false);
		grupoDto.setEstadoSemestre(semestre != null ? semestre.getEstado():false);
		grupoDto.setAnoSemestre(semestre != null ? semestre.getAno():0);
		grupoDto.setNombreCurso(curso != null ? curso.getNombre():"");
		grupoDto.setEstadoGrupo(grupo.getEstado());
		grupoDto.setFechaFin(grupo.getFechaFin());
		grupoDto.setFechaInicio(grupo.getFechaInicio());
		grupoDto.setHorainiclase(grupo.getHorainiclase());
		grupoDto.setHorafinclase(grupo.getHorafinclase());
		grupoDto.setDiaclase(grupo.getDiaclase());
		grupoDto.setCantidadestudiantes(grupo.getCantidadestudiantes());
		grupoDto.setNombre(grupo.getNombre());
		grupoDto.setId(grupo.getId());
		grupoDto.setIdDocente(grupo.getDocente() != null ? grupo.getDocente().getId():0);
		
		return grupoDto;
		
	}
	
	public static List<ReporteActividadDto> MapReporteActividades(List<ReporteActividad> actividades){
		List<ReporteActividadDto> actividadesDto = new ArrayList<>();
		
		for(ReporteActividad act: actividades) {
			
			actividadesDto.add(MapReporteActividad(act));
		}
		
		return actividadesDto;
	}
	
	public static ReporteActividadDto MapReporteActividad (ReporteActividad act) {
		ReporteActividadDto reporteActividadDto = null;
		
		if(act != null) {
			reporteActividadDto = new ReporteActividadDto();
			reporteActividadDto.setTipoActividad(act.getActividad().getDescripcion());
			reporteActividadDto.setFecha(act.getFecha());
			reporteActividadDto.setId(act.getId());
			reporteActividadDto.setIdActividad(act.getActividad().getId());
			reporteActividadDto.setHoras(act.getHoras());
			reporteActividadDto.setIdGrupo(act.getGrupo().getId());	
			reporteActividadDto.setObservaciones(act.getObservaciones());
		}
		
		return reporteActividadDto;	
	}
	
	public static ActividadDTO MapActividad(Actividad actividad) {
		ActividadDTO actividadDTO = new ActividadDTO();
		
		if(actividad != null) {
			actividadDTO.setId(actividad.getId());
			actividadDTO.setDescripcion(actividad.getDescripcion());
		}
		
		return actividadDTO;
		
	}
	
	public static List<ActividadDTO> MapActividades(List<Actividad> actividades){
		List<ActividadDTO> actividadesDTO = new ArrayList<>();
		
		for (Actividad act : actividades) {		
			actividadesDTO.add(MapActividad(act));
		}
		
		return actividadesDTO;
		
	}
	
	
	
}
