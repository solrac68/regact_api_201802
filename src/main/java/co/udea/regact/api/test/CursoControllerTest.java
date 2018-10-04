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
import org.springframework.boot.test.context.SpringBootTest;
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
import co.udea.regact.api.controller.CursoController;
import static org.assertj.core.api.Assertions.assertThat;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.hamcrest.Matchers.containsString;
import org.springframework.web.context.WebApplicationContext;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;


//@WebMvcTest(CursoController.class)
//@ContextConfiguration(classes = {Curso.class,CursoRepository.class,CursoService.class})
//@SpringBootTest
//@RunWith(SpringRunner.class)
//@WebMvcTest(CursoController.class)
@RunWith(SpringRunner.class)
@SpringBootTest(
        classes = CursoControllerTest.class
)
public class CursoControllerTest {
	
	@Autowired
    private WebApplicationContext wac;
	
	private MockMvc mockMvc;
	
//	@Autowired
//	private CursoController controller;
	

//	
//	@Autowired
//	private MockMvc mockMvc;
//	
//	@MockBean
//	private CursoServiceImp service;
	
//	
//	@Mock
//	private Curso cursoMock;
//	
//	@Mock
//	private CursoRepository cursoRepository;
//	
//	@Autowired
//    ObjectMapper objectMapper;
	
	@Before
    public void setupMock() {
//		MockitoAnnotations.initMocks(this);
//		cursoServiceMock = new CursoServiceImp(cursoRepository);
		
		this.mockMvc = MockMvcBuilders.webAppContextSetup(wac).build();
	}
	
	
	@Test
    public void contexLoads() throws Exception {
		//when(service.getCurso(1)).thenReturn(new Curso("Matematicas Discretas 1", 98, true));
        this.mockMvc.perform(get("getCurso?id=1")).andDo(print()).andExpect(status().isOk())
                .andExpect(content().string(containsString("Matematicas Discretas 1")));
    }

//	@Test
//	public void testCreateCursoExitosamente() throws Exception
//	{
//		
//		when(cursoServiceMock.saveCurso(cursoMock)).thenReturn(cursoMock);
//		
//		mockMvc.perform(post("/setCurso")
//				.contentType(MediaType.APPLICATION_JSON)
//				.content(objectMapper.writeValueAsBytes(cursoServiceMock)))
//				.andExpect(status().isCreated());
//		
//	}

}
