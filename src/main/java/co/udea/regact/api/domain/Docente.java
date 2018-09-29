package co.udea.regact.api.domain;

import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonBackReference;

@Entity
@Table(name = "DOCENTES")
public class Docente {
	@Id
	@Column(name = "doce_email")
	private String email;
	
	@Column(name = "doce_departamento")
	private String departamento;
	
	@Column(name = "doce_titulo")
	private String titulo;
	
	@OneToMany(mappedBy = "docente", cascade = CascadeType.ALL)
	@JsonBackReference
	private Set<Grupo> grupos;

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getDepartamento() {
		return departamento;
	}

	public void setDepartamento(String departamento) {
		this.departamento = departamento;
	}

	public String getTitulo() {
		return titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	public Set<Grupo> getGrupos() {
		return grupos;
	}

	public void setGrupos(Set<Grupo> grupos) {
		this.grupos = grupos;
	}

}
