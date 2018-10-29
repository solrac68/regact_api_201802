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
@Table(name = "ACTIVIDADES")
public class Actividad {
	@Id
	@Column(name = "act_id")
	private Integer id;
	
	@Column(name = "act_descripcion")
	private String descripcion;
	
	@OneToMany(mappedBy = "actividad", cascade = CascadeType.ALL)
	@JsonBackReference
	private Set<ReporteActividad> reporteActividades;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public Set<ReporteActividad> getReporteActividades() {
		return reporteActividades;
	}

	public void setReporteActividades(Set<ReporteActividad> reporteActividades) {
		this.reporteActividades = reporteActividades;
	}

}
