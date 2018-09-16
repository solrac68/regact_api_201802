package co.udea.regact.api.domain;

import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonBackReference;

@Entity
@Table(name = "perfil")
public class Perfil {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "per_id")
	private Integer id;
	
	@Column(name = "per_nombre")
	private String nombre;
	
	@ManyToMany(fetch = FetchType.LAZY, mappedBy = "perfiles")
	@JsonBackReference
	private Set<Usuario> usuarios;
	
	public Perfil() {
		
	}
	
	public Perfil(String nombre) {
		this.nombre = nombre;
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
	
	
	public Set<Usuario> getUsuarios() {
		return usuarios;
	}

	public void setUsuarios(Set<Usuario> usuarios) {
		this.usuarios = usuarios;
	}
	
	

}
