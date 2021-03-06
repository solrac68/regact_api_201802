package co.udea.regact.api.repository;

import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;

import co.udea.regact.api.domain.Docente;

public interface DocenteRepository extends JpaRepository<Docente, Integer>{
	public Optional<Docente> findById(Integer id);
	@SuppressWarnings("unchecked")
	public Docente saveAndFlush(Docente grupo);
	
}