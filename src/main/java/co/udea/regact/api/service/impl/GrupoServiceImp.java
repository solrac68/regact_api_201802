package co.udea.regact.api.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import co.udea.regact.api.domain.Docente;
import co.udea.regact.api.domain.Grupo;
import co.udea.regact.api.dto.GrupoDto;
import co.udea.regact.api.exception.DataNotFoundException;
import co.udea.regact.api.repository.DocenteRepository;
import co.udea.regact.api.repository.GrupoRepository;
import co.udea.regact.api.repository.ReporteActividadRepository;
import co.udea.regact.api.service.GrupoService;
import co.udea.regact.api.util.Mapper;
import co.udea.regact.api.util.Messages;

@Service
@Qualifier("GrupoServiceImpl")
public class GrupoServiceImp implements GrupoService {
	
	private DocenteRepository docenteRepository;
	private GrupoRepository grupoRepository;
	//private ReporteActividadRepository reporteActividadRepository;
	private Messages messages;
	
	
	public GrupoServiceImp(
			DocenteRepository docenteRepository,
			GrupoRepository grupoRepository,
			//ReporteActividadRepository reporteActividadRepository,
			Messages messages) {
		this.docenteRepository = docenteRepository;
		this.grupoRepository = grupoRepository;
		this.messages = messages;
		//this.reporteActividadRepository = reporteActividadRepository;
	}

	@Override
	public List<GrupoDto> getGruposByDocente(Integer id) {
		List<GrupoDto> gruposDto = null;
		//Optional<Docente> docente  = this.docenteRepository.findByEmail(emailDocente);
		Docente docente = this.docenteRepository.findOne(id);
		
		if(docente != null) {
			List<Grupo> grupos = new ArrayList<Grupo>();
			grupos.addAll(docente.getGrupos());
			gruposDto = Mapper.MapGrupos(grupos);
		}
		
		return gruposDto;	
		
	}

	@Override
	public Grupo saveGrupo(Grupo grupo) {
		// TODO Auto-generated method stub
		return grupoRepository.saveAndFlush(grupo);
	}

	@Override
	public List<GrupoDto> getGruposActivosByDocente(Integer id) {
		List<GrupoDto> gruposDto = null;
		
		List<Grupo> grupos2 = grupoRepository.findByEstadoActivo(id);
		
		if(grupos2 != null) {
			gruposDto = Mapper.MapGrupos(grupos2);
		}
		
		return gruposDto;
	}

	@Override
	public GrupoDto getGrupoById(Integer id) {
		GrupoDto grupoDto = null;
		
		Grupo grupo = grupoRepository.findById(id)
				.orElseThrow(() -> new DataNotFoundException(messages.get("exception.data_not_found.Grupo")));
		grupoDto = Mapper.MapGrupo(grupo);
		
		return grupoDto;
	}

}
