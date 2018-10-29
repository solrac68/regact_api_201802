package co.udea.regact.api.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import co.udea.regact.api.domain.Actividad;

public interface ActividadRepository extends JpaRepository<Actividad, Integer> {
	Optional<Actividad> findById(Integer id);
}
