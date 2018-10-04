package co.udea.regact.api.test;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.*;
import static org.mockito.Mockito.spy;
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

import java.util.List;
import java.util.Optional;

public class GrupoServiceImpTest {
	
	private GrupoServiceImp grupoServiceImp;
	
	@Mock
	private GrupoRepository grupoRepository;
	
	@Mock
	private DocenteRepository docenteRepository; 
	
	@Mock
	private Grupo grupoMock;
	
	@Mock
	private Docente docenteMock;
	
	@Before
    public void setupMock() {
		MockitoAnnotations.initMocks(this);
		grupoServiceImp = new GrupoServiceImp(docenteRepository,grupoRepository);
	}
	
	

	@Test
	public void testGetGruposByDocente() {
		when(docenteRepository.findOne("andres@gmail.com")).thenReturn(docenteMock);
		
		List<GrupoDto> grupos = grupoServiceImp.getGruposByDocente("andres@gmail.com");
		
		assertThat(docenteMock.getGrupos().size(), is(equalTo(grupos.size())));
	}

//	@Test
//	public void testSaveGrupo() {
//		fail("Not yet implemented");
//	}

}
