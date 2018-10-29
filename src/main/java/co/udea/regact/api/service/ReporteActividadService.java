package co.udea.regact.api.service;

import java.util.List;

import co.udea.regact.api.dto.ReporteActividadDto;


public interface ReporteActividadService {
	ReporteActividadDto getReporteActividadById(Integer id);
	List<ReporteActividadDto> getReporteActividadesByGrupo(Integer id);
	Integer getSumHorasReporteActividadesByGrupo(Integer id);
	void deleteReporteActividad(Integer id);
	ReporteActividadDto updateReporteActividad(ReporteActividadDto reporteActividadDto);
	ReporteActividadDto insertReporteActividad(ReporteActividadDto reporteActividadDto);
}