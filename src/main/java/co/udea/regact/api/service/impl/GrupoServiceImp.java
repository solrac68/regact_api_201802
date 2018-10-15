package co.udea.regact.api.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import co.udea.regact.api.domain.Docente;
import co.udea.regact.api.domain.Grupo;
import co.udea.regact.api.dto.GrupoDto;
import co.udea.regact.api.repository.DocenteRepository;
import co.udea.regact.api.repository.GrupoRepository;
import co.udea.regact.api.service.GrupoService;
import co.udea.regact.api.util.Mapper;

@Service
@Qualifier("GrupoServiceImpl")
public class GrupoServiceImp implements GrupoService {
	
	private DocenteRepository docenteRepository;
	private GrupoRepository grupoRepository;
	
	
	public GrupoServiceImp(DocenteRepository docenteRepository,GrupoRepository grupoRepository) {
		this.docenteRepository = docenteRepository;
		this.grupoRepository = grupoRepository;
	}

	@Override
	public List<GrupoDto> getGruposByDocente(Integer id) {
		List<GrupoDto> gruposDto = null;
		//Optional<Docente> docente  = this.docenteRepository.findByEmail(emailDocente);
		Docente docente = this.docenteRepository.findOne(id);
		
		if(docente != null) {
			List<Grupo> grupos = new ArrayList<Grupo>();
			grupos.addAll(docente.getGrupos());
			gruposDto = Mapper.Map(grupos);
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
			gruposDto = Mapper.Map(grupos2);
		}
		
		return gruposDto;
	}

}
