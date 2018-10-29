package co.udea.regact.api.util;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import co.udea.regact.api.domain.Actividad;
import co.udea.regact.api.domain.Curso;
import co.udea.regact.api.domain.Grupo;
import co.udea.regact.api.domain.ReporteActividad;
import co.udea.regact.api.domain.Semestre;
import co.udea.regact.api.dto.GrupoDto;
import co.udea.regact.api.dto.ReporteActividadDto;

public class Mapper {
	public static List<GrupoDto> MapGrupos(List<Grupo> grupos){
		List<GrupoDto> gruposDto = new ArrayList<>();
		GrupoDto grupoDto;
		Semestre semestre;
		Curso curso;
		
		for(Grupo grupo : grupos) {
			semestre = grupo.getSemestre();
			curso = grupo.getCurso();
			grupoDto = new GrupoDto();
			
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
			gruposDto.add(grupoDto);

		}
		
		return gruposDto;
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
	
}
