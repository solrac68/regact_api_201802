package co.udea.regact.api.repository;

import java.util.List;
import java.util.Optional;

import org.assertj.core.util.VisibleForTesting;
import org.springframework.data.jpa.repository.JpaRepository;
import co.udea.regact.api.domain.Curso;

public interface CursoRepository extends JpaRepository<Curso, Integer>{
	@VisibleForTesting
	public Optional<Curso> findByid(Integer id);
	@SuppressWarnings("unchecked")
	public Curso saveAndFlush(Curso curso);
	public List<Curso> findBynombre(String nombre);
}
