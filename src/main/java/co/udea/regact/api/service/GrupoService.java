package co.udea.regact.api.service;

import java.util.List;
import co.udea.regact.api.domain.Grupo;
import co.udea.regact.api.dto.GrupoDto;

public interface GrupoService {
	public List<GrupoDto> getGruposByDocente(Integer id);
	public Grupo saveGrupo(Grupo grupo);
	public List<GrupoDto> getGruposActivosByDocente(Integer id);
}
