package co.udea.regact.api.service.impl;



import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import co.udea.regact.api.domain.Curso;
import co.udea.regact.api.repository.CursoRepository;
import co.udea.regact.api.service.CursoService;

@Service
@Qualifier("CursoServiceImpl")
public class CursoServiceImpl implements CursoService {
	
	private CursoRepository cursoRepository;

	@Override
	public Curso getCurso(Integer id) {
		// TODO Auto-generated method stub
		return null;
	}
	
//	private CursoRepository cursoRepository;
//    private Messages messages;	
//	
//	public CursoServiceImpl(CursoRepository heroRepository, Messages messages){
//		this.cursoRepository = heroRepository;
//		this.messages = messages;
//	}
//
//	@Override
//	public Curso getCurso(String codigo) {
//		Optional<Curso> cursoOptional = cursoRepository.findByCodigo(codigo);
//		if(!cursoOptional.isPresent()){
//			throw new DataNotFoundException(messages.get("exception.data_not_found.curso"));
//		}
//		return cursoOptional.get();
//	}

}

