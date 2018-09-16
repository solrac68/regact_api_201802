package co.udea.regact.api.repository;

import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import co.udea.regact.api.domain.Usuario;

public interface UsuarioRepository extends JpaRepository<Usuario, Integer>{
	public Optional<Usuario> findByid(Integer id);
	public Optional<Usuario> findBynombre(String name);
}
