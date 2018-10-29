package co.udea.regact.api.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import co.udea.regact.api.domain.ReporteActividad;

public interface ReporteActividadRepository extends JpaRepository<ReporteActividad, Integer> {
	
	public Optional<ReporteActividad> findById(Integer id);
	
	@Query("select u from ReporteActividad u inner join u.grupo g where g.id = :idGrupo order by u.fecha")
	public List<ReporteActividad> findByIdGrupo(@Param("idGrupo") Integer idGrupo);
	
	public void delete(Integer id);
	
	
	@SuppressWarnings("unchecked")
	public ReporteActividad saveAndFlush(ReporteActividad r);
	
	@Query("select SUM(u.horas) from ReporteActividad u inner join u.grupo g where g.id = :idGrupo")
	public Integer SumHoras(@Param("idGrupo") Integer idGrupo);
	
}
