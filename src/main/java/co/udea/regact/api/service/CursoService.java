package co.udea.regact.api.service;

import co.udea.regact.api.domain.Curso;

public interface CursoService {
	public Curso getCurso(Integer id);
	public Curso saveCurso(Curso curso);
}
