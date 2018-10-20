package co.udea.regact.api;


import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.verifyNoMoreInteractions;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import java.util.Arrays;
import java.util.Date;
import java.util.List;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import co.udea.regact.api.controller.GrupoController;
import co.udea.regact.api.dto.GrupoDto;
import co.udea.regact.api.service.GrupoService;
import static org.hamcrest.Matchers.*;


@RunWith(SpringRunner.class)
@WebMvcTest(GrupoController.class)
public class WebMockTestGrupos {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private GrupoService service;

    @Test
    public void getGruposByDocente() throws Exception {
    	GrupoDto grupoDto1 = 
    			new GrupoDto(1, "Grupo 1", 20, "Ma-Ju", new Date(), new Date(), new Date(), new Date(), true, "Matematicas Discretas 1", 2018, true, false, "andres@gmail.com",71701882);
    	GrupoDto grupoDto2 = 
    			new GrupoDto(2, "Grupo 2", 20, "Lu-Mie", new Date(), new Date(), new Date(), new Date(), true, "Matematicas Discretas 2", 2018, false, true, "andres@gmail.com",71701882);
    	List<GrupoDto> grupos = Arrays.asList(
    			grupoDto1,
    			grupoDto2);
        when(service.getGruposByDocente(71701882)).thenReturn(grupos);
        this.mockMvc.perform(get("/grupos/getGruposByDocente/{id}",71701882))
        		.andDo(print())
        		.andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON_UTF8_VALUE))
                .andExpect(jsonPath("$", hasSize(2)))
                .andExpect(jsonPath("$[0].id", is(1)))
        		.andExpect(jsonPath("$[1].id", is(2)))
        		.andExpect(jsonPath("$[0].nombre", is("Grupo 1")))
        		.andExpect(jsonPath("$[1].correoDocente", is("andres@gmail.com")));
        		
        verify(service,times(1)).getGruposByDocente(71701882);
        verifyNoMoreInteractions(service);
    }
    
    @Test
    public void getGruposActivosByDocente() throws Exception {
    	GrupoDto grupoDto1 = 
    			new GrupoDto(1, "Grupo 1", 20, "Ma-Ju", new Date(), new Date(), new Date(), new Date(), true, "Matematicas Discretas 1", 2018, true, false, "andres@gmail.com",71701882);
    	GrupoDto grupoDto2 = 
    			new GrupoDto(2, "Grupo 2", 20, "Lu-Mie", new Date(), new Date(), new Date(), new Date(), true, "Matematicas Discretas 2", 2018, true, true, "andres@gmail.com",71701882);
    	List<GrupoDto> grupos = Arrays.asList(
    			grupoDto1,
    			grupoDto2);
        when(service.getGruposActivosByDocente(71701882)).thenReturn(grupos);
        this.mockMvc.perform(get("/grupos/getGruposActivosByDocente/{id}",71701882))
        		.andDo(print())
        		.andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON_UTF8_VALUE))
                .andExpect(jsonPath("$", hasSize(2)))
                .andExpect(jsonPath("$[0].id", is(1)))
        		.andExpect(jsonPath("$[1].id", is(2)))
        		.andExpect(jsonPath("$[0].nombre", is("Grupo 1")))
        		.andExpect(jsonPath("$[1].correoDocente", is("andres@gmail.com")));
        		
        verify(service,times(1)).getGruposActivosByDocente(71701882);
        verifyNoMoreInteractions(service);
    }
}
