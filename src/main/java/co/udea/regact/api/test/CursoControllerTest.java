package co.udea.regact.api.test;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;

import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;

import com.fasterxml.jackson.databind.ObjectMapper;

import co.udea.regact.api.controller.CursoController;
import co.udea.regact.api.domain.Curso;
import co.udea.regact.api.repository.CursoRepository;
import co.udea.regact.api.service.CursoService;
import co.udea.regact.api.service.impl.CursoServiceImp;

import org.junit.Before;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import static org.mockito.Mockito.*;

@RunWith(SpringRunner.class)
@WebMvcTest(CursoController.class)
@ContextConfiguration(classes = {Curso.class,CursoRepository.class,CursoService.class,CursoServiceImp.class})
public class CursoControllerTest {
	
	private CursoServiceImp cursoServiceMock;
	
	@Autowired
	private MockMvc mockMvc;
	
	@Mock
	private Curso cursoMock;
	
	@Mock
	private CursoRepository cursoRepository;
	
	@Autowired
    ObjectMapper objectMapper;
	
	@Before
    public void setupMock() {
		MockitoAnnotations.initMocks(this);
		cursoServiceMock = new CursoServiceImp(cursoRepository);
	}
	

	@Test
	public void testCreateCursoExitosamente() throws Exception
	{
		
		when(cursoServiceMock.saveCurso(cursoMock)).thenReturn(cursoMock);
		
		mockMvc.perform(post("/setCurso")
				.contentType(MediaType.APPLICATION_JSON)
				.content(objectMapper.writeValueAsBytes(cursoServiceMock)))
				.andExpect(status().isCreated());
		
	}

}
