package co.udea.regact.api.repository;

import java.util.List;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import co.udea.regact.api.domain.Grupo;

public interface GrupoRepository extends JpaRepository<Grupo, Integer> {
	public Optional<Grupo> findById(Integer id);
	@SuppressWarnings("unchecked")
	public Grupo saveAndFlush(Grupo grupo);
	
	@Query("select u from Grupo u inner join u.docente d where d.id = :idDocente and u.estado = true")
	public List<Grupo> findByEstadoActivo(@Param("idDocente") Integer idDocente);
}
