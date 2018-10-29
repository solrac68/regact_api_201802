package co.udea.regact.api.service.impl;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.options;

import java.util.List;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import co.udea.regact.api.domain.Actividad;
import co.udea.regact.api.domain.Grupo;
import co.udea.regact.api.domain.ReporteActividad;
import co.udea.regact.api.dto.ReporteActividadDto;
import co.udea.regact.api.service.ReporteActividadService;
import co.udea.regact.api.util.Mapper;
import co.udea.regact.api.repository.ActividadRepository;
import co.udea.regact.api.repository.GrupoRepository;
import co.udea.regact.api.repository.ReporteActividadRepository;
import co.udea.regact.api.util.Messages;
import co.udea.regact.api.exception.DataNotFoundException;

@Service
@Qualifier("ReporteActividadImp")
public class ReporteActividadImp implements ReporteActividadService {
	
	private final Logger log = LoggerFactory.getLogger(ReporteActividadImp.class);
	
	ReporteActividadRepository reporteActividadRepository;
	GrupoRepository grupoRepository; 
	ActividadRepository actividadRepository;
	private Messages messages;
	
	public ReporteActividadImp(
			ReporteActividadRepository reporteActividadRepository, 
			ActividadRepository actividadRepository,
			GrupoRepository grupoRepository,
			Messages messages) {
		this.reporteActividadRepository = reporteActividadRepository;
		this.actividadRepository = actividadRepository;
		this.grupoRepository = grupoRepository;
		this.messages = messages;
	}

	@Override
	public List<ReporteActividadDto> getReporteActividadesByGrupo(Integer id) {
		List<ReporteActividadDto> actividadesDTO = null;
		List<ReporteActividad> actividades = this.reporteActividadRepository.findByIdGrupo(id);
		
		if(actividades != null) {
			actividadesDTO = Mapper.MapReporteActividades(actividades);
		}
		
		log.debug("Fin getReporteActividadesByGrupo: actividadesDTO = {}", actividadesDTO);
		
		return actividadesDTO;
	}

	@Override
	public ReporteActividadDto getReporteActividadById(Integer id) {
		ReporteActividadDto actividadDto = null;
		
		Optional<ReporteActividad> actividad = reporteActividadRepository.findById(id);
		
		if(!actividad.isPresent()) {
			throw new DataNotFoundException(messages.get("exception.data_not_found.actividad"));
		}
		
		actividadDto = Mapper.MapReporteActividad(actividad.get());
		
		log.debug("Fin updateActividad: reporteActividadDto = {}", actividadDto);
		
		return actividadDto;
		
	}

	@Override
	public Integer getSumHorasReporteActividadesByGrupo(Integer id) {
		// TODO Auto-generated method stub
		return reporteActividadRepository.SumHoras(id);
	}

	@Override
	public void deleteReporteActividad(Integer id) {
		reporteActividadRepository.delete(id);
		log.debug("Fin deleteActividad");
	}

	@Override
	public ReporteActividadDto updateReporteActividad(ReporteActividadDto reporteActividadDto) {
		
		ReporteActividad reporteActividad = reporteActividadRepository.findById(reporteActividadDto.getId())
				.orElseThrow(() -> new DataNotFoundException(messages.get("exception.data_not_found.ReporteActividad")));

		return save(reporteActividadDto,reporteActividad);
		
	}

	@Override
	public ReporteActividadDto insertReporteActividad(ReporteActividadDto reporteActividadDto) {
		
		ReporteActividad reporteActividad = new ReporteActividad();
		
		return save(reporteActividadDto,reporteActividad);
	}
	
	private ReporteActividadDto save(ReporteActividadDto reporteActividadDto, ReporteActividad reporteActividad) {
		
		Grupo grupo =   this.grupoRepository.findById(reporteActividadDto.getIdGrupo())
				.orElseThrow(() -> new DataNotFoundException(messages.get("exception.data_not_found.Grupo")));
		
		Actividad actividad = actividadRepository.findById(reporteActividadDto.getIdActividad())
				.orElseThrow(() -> new DataNotFoundException(messages.get("exception.data_not_found.Actividad")));
		
		
		reporteActividad.setActividad(actividad);
		reporteActividad.setGrupo(grupo);
		reporteActividad.setFecha(reporteActividadDto.getFecha());
		reporteActividad.setHoras(reporteActividadDto.getHoras());
		reporteActividad.setObservaciones(reporteActividadDto.getObservaciones());
		
		reporteActividad = reporteActividadRepository.saveAndFlush(reporteActividad);
		
		
		return Mapper.MapReporteActividad(reporteActividad);
		
	}

}
