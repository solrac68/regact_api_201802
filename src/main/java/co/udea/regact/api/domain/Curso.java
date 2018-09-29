package co.udea.regact.api.domain;


import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;


import com.fasterxml.jackson.annotation.JsonBackReference;


@Entity
@Table(name = "CURSOS")
public class Curso {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "cur_id")
	private Integer id;
	
	@Column(name = "cur_nombre")
	private String nombre;
	
	@Column(name = "cur_horas")
	private Integer horas;
	
	@Column(name = "cur_estado")
	private Boolean estado;
	
	@OneToMany(mappedBy = "curso", cascade = CascadeType.ALL)
	@JsonBackReference
	private Set<Grupo> grupos;
	
	public Curso() {
		
	}
	
	public Curso(String nombre, Integer horas,Boolean estado ) {
		this.nombre = nombre;
		this.horas = horas;
		this.estado = estado;
	}
	
	public Curso(String nombre, Integer cantidadHoras,Boolean estado, Set<Grupo> grupos) {
		this(nombre,cantidadHoras,estado);
		this.grupos = grupos;
	}
	

	
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	
	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	
	public int getHoras() {
		return horas;
	}

	public void setHoras(int cantidadHoras) {
		this.horas = cantidadHoras;
	}

	
	public Boolean getEstado() {
		return estado;
	}

	public void setEstado(Boolean estado) {
		this.estado = estado;
	}

	
	public Set<Grupo> getGrupos() {
		return grupos;
	}

	public void setGrupos(Set<Grupo> grupos) {
		this.grupos = grupos;
	}
	
	
}
