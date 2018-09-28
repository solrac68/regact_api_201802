package co.udea.regact.api.service;

import java.util.List;

import co.udea.regact.api.dto.GrupoDto;

public interface GrupoService {
	public List<GrupoDto> getGruposByDocente(String emailDocente);
}
