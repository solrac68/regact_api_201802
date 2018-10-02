package co.udea.regact.api.service.impl;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.Optional;

import co.udea.regact.api.domain.Curso;
import co.udea.regact.api.repository.CursoRepository;
import co.udea.regact.api.service.CursoService;

@Service
@Qualifier("CursoServiceImpl")
public class CursoServiceImp implements CursoService {
	
	private CursoRepository cursoRepository;
	
	public CursoServiceImp(CursoRepository cursoRepository) {
		this.cursoRepository = cursoRepository;
	}

	@Override
	public Curso getCurso(Integer id) {
		Curso curso = null;
		Optional<Curso> cursoO = this.cursoRepository.findByid(id);
		if(cursoO.isPresent()) {
			curso = cursoO.get();
		}
		return curso;
	}

	@Override
	public Curso saveCurso(Curso curso) {
		return this.cursoRepository.saveAndFlush(curso);
	}

}
