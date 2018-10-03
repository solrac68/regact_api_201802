package co.udea.regact.api.test;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.*;
import static org.mockito.Mockito.when;

import org.junit.Test;


import co.udea.regact.api.domain.Curso;
import co.udea.regact.api.repository.CursoRepository;
import co.udea.regact.api.service.impl.CursoServiceImp;
import org.mockito.Mock;
import org.junit.Before;
import org.mockito.MockitoAnnotations;
public class CursoServiceImpTest {
	
	private CursoServiceImp cursoServiceImp;
	
	@Mock
	private CursoRepository cursoRepository;
	
	@Mock
	private Curso cursoMock;
	
	@Before
    public void setupMock() {
		MockitoAnnotations.initMocks(this);
		cursoServiceImp = new CursoServiceImp(cursoRepository);
	}

	@Test
	public void testGetCurso() throws Exception {
			
		when(cursoRepository.findOne(1)).thenReturn(cursoMock);
		
		Curso curso = cursoServiceImp.getCurso(1);
		
		assertThat(curso, is(equalTo(cursoMock)));
	}

	@Test
	public void testSaveCurso()  throws Exception {
		//cursoMock = new Curso();
		when(cursoRepository.saveAndFlush(cursoMock)).thenReturn(cursoMock);
		
		Curso curso = cursoServiceImp.saveCurso(cursoMock);
		
		assertThat(curso, is(equalTo(cursoMock)));
	}

}
