package co.udea.regact.api.domain;

import java.util.Date;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import com.fasterxml.jackson.annotation.JsonBackReference;

@Entity
@Table(name = "SEMESTRES")
public class Semestre {
	
	@Id
	@Column(name = "sem_id")
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer id;
	
	@Temporal(TemporalType.DATE)
	@Column(name = "sem_fechainicio")
	private Date fechaInicio;
	
	@Temporal(TemporalType.DATE)
	@Column(name = "sem_fechafin")
	private Date fechaFin;
	
	@Column(name = "sem_ano")
	private Integer ano;
	
	@Column(name = "sem_semestre")
	private Boolean semestre;
	
	@Column(name = "sem_estado")
	private Boolean estado;
	
	@OneToMany(mappedBy = "semestre", cascade = CascadeType.ALL)
	@JsonBackReference
	private Set<Grupo> grupos;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Date getFechaInicio() {
		return fechaInicio;
	}

	public void setFechaInicio(Date fechaInicio) {
		this.fechaInicio = fechaInicio;
	}

	public Date getFechaFin() {
		return fechaFin;
	}

	public void setFechaFin(Date fechaFin) {
		this.fechaFin = fechaFin;
	}

	public Integer getAno() {
		return ano;
	}

	public void setAno(Integer ano) {
		this.ano = ano;
	}

	public Boolean getSemestre() {
		return semestre;
	}

	public void setSemestre(Boolean semestre) {
		this.semestre = semestre;
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
