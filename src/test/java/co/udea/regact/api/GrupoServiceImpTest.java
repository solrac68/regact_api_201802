package co.udea.regact.api;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.*;
import static org.mockito.Mockito.when;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import co.udea.regact.api.domain.Docente;
import co.udea.regact.api.domain.Grupo;
import co.udea.regact.api.dto.GrupoDto;
import co.udea.regact.api.repository.DocenteRepository;
import co.udea.regact.api.repository.GrupoRepository;
import co.udea.regact.api.service.impl.GrupoServiceImp;
import co.udea.regact.api.util.Messages;

import java.util.Arrays;
import java.util.List;

public class GrupoServiceImpTest {
	
	private GrupoServiceImp grupoServiceImp;
	
	@Mock
	private GrupoRepository grupoRepository;
	
	@Mock
	private DocenteRepository docenteRepository;
	
	@Mock
	private Messages messages;
	
	@Mock
	private Grupo grupoMock;
	
	@Mock
	private Docente docenteMock;
	
	@Mock
	private Grupo grupo1Mock, grupo2Mock, grupo3Mock;
	
	private List<Grupo> gruposMock;
	
	@Before
    public void setupMock() {
		MockitoAnnotations.initMocks(this);
		
		gruposMock = Arrays.asList(grupo1Mock,grupo2Mock,grupo3Mock);
		
		grupoServiceImp = new GrupoServiceImp(docenteRepository,grupoRepository,messages);
		
	}
	
	

	@Test
	public void testGetGruposByDocente() {
		when(docenteRepository.findOne(71701882)).thenReturn(docenteMock);
		
		List<GrupoDto> grupos = grupoServiceImp.getGruposByDocente(71701882);
		
		assertThat(docenteMock.getGrupos().size(), is(equalTo(grupos.size())));
	}
	
	@Test
	public void testGetGruposActivosByDocente() {
		when(grupoRepository.findByEstadoActivo(71701882)).thenReturn(gruposMock);
		
		List<GrupoDto> gruposActivos = grupoServiceImp.getGruposActivosByDocente(71701882);
		
		assertThat(gruposMock.size(), is(equalTo(gruposActivos.size())));
	}
	
	



}
