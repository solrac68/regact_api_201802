package co.udea.regact.api.domain;

import java.util.Set;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonManagedReference;


@Entity
@Table(name = "usuario")
public class Usuario {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "usu_id")
	private Integer id;
	
	@Column(name = "usu_nombre")
	private String nombre;
	
	@Column(name = "usu_email")
	private String email;
	
	@Column(name = "usu_password")
	private String password;
	
	@Column(name = "usu_estado")
	private Boolean estado;
	
	@ManyToMany(cascade = CascadeType.ALL)
	@JoinTable(name = "rel_usuario_curso_grupo", joinColumns = @JoinColumn(name = "usu_id", referencedColumnName = "usu_id"), inverseJoinColumns = @JoinColumn(name = "cur_id", referencedColumnName = "cur_id"))
	@JsonManagedReference
	private Set<Curso> cursos;
	
	@ManyToMany(cascade = CascadeType.ALL)
	@JoinTable(name = "rel_perfil_usuario", joinColumns = @JoinColumn(name = "usu_id", referencedColumnName = "usu_id"), inverseJoinColumns = @JoinColumn(name = "per_id", referencedColumnName = "per_id"))
	@JsonManagedReference
	private Set<Perfil> perfiles;
	
	public Usuario() {
	}
	
	public Usuario(String nombre,String email,String password,Boolean estado) {
		this.nombre = nombre;
		this.email = email;
		this.password = password;
		this.estado = estado;
	}
	
	public Usuario(String nombre,String email,String password,Boolean estado,Set<Curso> cursos,Set<Perfil> perfiles) {
		this(nombre,email,password,estado);
		this.cursos = cursos;
		this.perfiles = perfiles;
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

	
	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	
	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	
	public Boolean getEstado() {
		return estado;
	}

	public void setEstado(Boolean estado) {
		this.estado = estado;
	}

	
	public Set<Curso> getCursos() {
		return cursos;
	}

	
	public void setCursos(Set<Curso> cursos) {
		this.cursos = cursos;
	}

	
	public Set<Perfil> getPerfiles() {
		return perfiles;
	}

	public void setPerfiles(Set<Perfil> perfiles) {
		this.perfiles = perfiles;
	}

}
