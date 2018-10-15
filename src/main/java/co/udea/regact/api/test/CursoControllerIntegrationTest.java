package co.udea.regact.api.test;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.junit.Assert.*;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.context.support.AnnotationConfigContextLoader;
import org.springframework.web.client.RestTemplate;

import co.udea.regact.api.domain.Curso;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@ContextConfiguration
public class CursoControllerIntegrationTest {

	@Autowired
    private TestRestTemplate restTemplate;
	
	@Test
	public void test() {
		ResponseEntity<Curso> responseEntity = 
				restTemplate.postForEntity("/cursos/setCurso/", new Curso("Matematicas Discretas",98,true), Curso.class);
		Curso curso = responseEntity.getBody();
		
		assertEquals(HttpStatus.OK, responseEntity.getStatusCode());
		
		assertEquals("Matematicas Discretas", curso.getNombre());
		//assertNull(curso);
	}
	
	@Test
	public void test2() {
		RestTemplate restTemplate = new RestTemplate();
		String fooResourceUrl
		  = "http://localhost:8080/regactapi/cursos/getCurso?id=1";
		
		ResponseEntity<String> response
		  = restTemplate.getForEntity(fooResourceUrl, String.class);
		assertThat(response.getStatusCode(), equalTo(HttpStatus.OK));
		
	}

}
