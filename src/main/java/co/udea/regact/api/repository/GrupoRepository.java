package co.udea.regact.api.repository;

import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import co.udea.regact.api.domain.Grupo;

public interface GrupoRepository extends JpaRepository<Grupo, Integer> {
	public Optional<Grupo> findById(Integer id);

}
