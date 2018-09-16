package co.udea.regact.api;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import javax.inject.Inject;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.TestExecutionListeners;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.context.support.DependencyInjectionTestExecutionListener;
import org.springframework.test.context.transaction.TransactionalTestExecutionListener;

import com.github.springtestdbunit.DbUnitTestExecutionListener;
import com.github.springtestdbunit.annotation.DatabaseOperation;
import com.github.springtestdbunit.annotation.DatabaseSetup;
import com.github.springtestdbunit.annotation.DatabaseTearDown;

import co.udea.regact.api.domain.Curso;
import co.udea.regact.api.exception.DataNotFoundException;
import co.udea.regact.api.service.CursoService;


@RunWith(SpringRunner.class)
@SpringBootTest(classes = RegistroActividadesApiApplication.class)
@ActiveProfiles(profiles = { "test" })
@DatabaseSetup(value = "/datasets/base-cursos.xml")
@DatabaseTearDown(value = "/datasets/base-cursos.xml", type = DatabaseOperation.DELETE)
@TestExecutionListeners({DependencyInjectionTestExecutionListener.class,
    TransactionalTestExecutionListener.class,
    DbUnitTestExecutionListener.class})
public class CursoServiceImpTest {
	
	@Inject
	private CursoService cursoService;
	
	@Before
	public void init() {
		
	}
	
	@After
	public void destroy() {
		 
	}

	@Test
	public void debeRetornoUnCursoPorSuCodigoExistosamente() {
		Curso curso = cursoService.getCurso(1);
		assertThat(curso).isNotNull();
		assertThat(curso.getNombre()).isEqualTo("Matematicas");
	}
	
	@Test
	public void debeRetornErrorSiElCursoNoExiste() {
		
		assertThatThrownBy(() -> {
			 cursoService.getCurso(3);
		}).isInstanceOf(DataNotFoundException.class);
	}

	
}
