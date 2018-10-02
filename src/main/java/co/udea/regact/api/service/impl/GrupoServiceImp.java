package co.udea.regact.api.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import java.util.Optional;
import java.util.Set;

import co.udea.regact.api.domain.Curso;
import co.udea.regact.api.domain.Docente;
import co.udea.regact.api.domain.Grupo;
import co.udea.regact.api.domain.Semestre;
import co.udea.regact.api.dto.GrupoDto;
import co.udea.regact.api.repository.DocenteRepository;
import co.udea.regact.api.service.GrupoService;

@Service
@Qualifier("GrupoServiceImpl")
public class GrupoServiceImp implements GrupoService {
	
	private DocenteRepository docenteRepository;
	
	public GrupoServiceImp(DocenteRepository docenteRepository) {
		this.docenteRepository = docenteRepository;
	}

	@Override
	public List<GrupoDto> getGruposByDocente(String emailDocente) {
		GrupoDto grupoDto;
		Semestre semestre;
		Curso curso;
		List<GrupoDto> gruposDto = new ArrayList<>();
		Optional<Docente> docente  = this.docenteRepository.findByEmail(emailDocente);
		if(docente.isPresent()) {
			Set<Grupo> grupos =  docente.get().getGrupos();
			for(Grupo grupo : grupos) {
				semestre = grupo.getSemestre();
				curso = grupo.getCurso();
				grupoDto = new GrupoDto();
				
				grupoDto.setCorreoDocente(emailDocente);
				grupoDto.setSemestre(semestre.getSemestre());
				grupoDto.setEstadoSemestre(semestre.getEstado());
				grupoDto.setAnoSemestre(semestre.getAno());
				grupoDto.setNombreCurso(curso.getNombre());
				grupoDto.setEstadoCurso(curso.getEstado());
				grupoDto.setFechaFin(grupo.getFechaFin());
				grupoDto.setFechaInicio(grupo.getFechaInicio());
				grupoDto.setHorainiclase(grupo.getHorainiclase());
				grupoDto.setHorafinclase(grupo.getHorafinclase());
				grupoDto.setDiaclase(grupo.getDiaclase());
				grupoDto.setCantidadestudiantes(grupo.getCantidadestudiantes());
				grupoDto.setNombre(grupo.getNombre());
				grupoDto.setId(grupo.getId());
				
				gruposDto.add(grupoDto);

			}
		}
		
		return gruposDto;	
		
	}

	@Override
	public Grupo saveGrupo(Grupo grupo) {
		// TODO Auto-generated method stub
		return null;
	}

}
