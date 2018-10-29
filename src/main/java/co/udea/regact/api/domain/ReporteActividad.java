package co.udea.regact.api.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import java.util.Date;

@Entity
@Table(name = "REPORTEACTIVIDADES")
public class ReporteActividad {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "repo_id")
	private Integer id;

	@Column(name = "repo_fecha")
	@Temporal(TemporalType.DATE)
	private Date fecha;
	
	@Column(name = "repo_horas")
	private Integer horas;
	
	@Column(name = "repo_observaciones")
	private String observaciones;
	
	@ManyToOne
    @JoinColumn(name = "repo_grupo_id")
	private Grupo grupo;
	
	@ManyToOne
    @JoinColumn(name = "repo_act_id")
	private Actividad actividad;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Date getFecha() {
		return fecha;
	}

	public void setFecha(Date fecha) {
		this.fecha = fecha;
	}

	public Integer getHoras() {
		return horas;
	}

	public void setHoras(Integer horas) {
		this.horas = horas;
	}

	public String getObservaciones() {
		return observaciones;
	}

	public void setObservaciones(String observaciones) {
		this.observaciones = observaciones;
	}

	public Grupo getGrupo() {
		return grupo;
	}

	public void setGrupo(Grupo grupo) {
		this.grupo = grupo;
	}

	public Actividad getActividad() {
		return actividad;
	}

	public void setActividad(Actividad actividad) {
		this.actividad = actividad;
	}
	
	
	

}
