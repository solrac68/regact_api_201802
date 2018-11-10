package co.udea.regact.api.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import co.udea.regact.api.domain.Actividad;
import co.udea.regact.api.dto.ActividadDTO;
import co.udea.regact.api.repository.ActividadRepository;
import co.udea.regact.api.service.ActividadService;
import co.udea.regact.api.util.Mapper;

@Service
@Qualifier("ActividadServiceImp")
public class ActividadServiceImp implements ActividadService {
	
	private ActividadRepository actividadRepository;
	
	public ActividadServiceImp(ActividadRepository actividadRepository) {
		super();
		this.actividadRepository = actividadRepository;
	}


	
	
	

	@Override
	public List<ActividadDTO> getAll() {
		
		List<Actividad> actividades = actividadRepository.findAll();
		
		return Mapper.MapActividades(actividades);
		
	}

}
