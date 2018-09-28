package co.udea.regact.api.dto;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

public class GrupoDto {
	private Integer id;
	private String nombre;
	private int cantidadestudiantes;
	private String diaclase;
	private Date horainiclase;
	private Date horafinclase;
	private Date fechaInicio;
	private Date fechaFin;
	private Boolean estadoCurso;
	private String nombreCurso;
	private Integer anoSemestre;
	private Boolean estadoSemestre;
	private Boolean semestre;
	private String correoDocente;
	
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
	public int getCantidadestudiantes() {
		return cantidadestudiantes;
	}
	public void setCantidadestudiantes(int cantidadestudiantes) {
		this.cantidadestudiantes = cantidadestudiantes;
	}
	public String getDiaclase() {
		return diaclase;
	}
	public void setDiaclase(String diaclase) {
		this.diaclase = diaclase;
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
	public Boolean getEstadoCurso() {
		return estadoCurso;
	}
	public void setEstadoCurso(Boolean estadoCurso) {
		this.estadoCurso = estadoCurso;
	}
	public String getNombreCurso() {
		return nombreCurso;
	}
	public void setNombreCurso(String nombreCurso) {
		this.nombreCurso = nombreCurso;
	}
	public Integer getAnoSemestre() {
		return anoSemestre;
	}
	public void setAnoSemestre(Integer anoSemestre) {
		this.anoSemestre = anoSemestre;
	}
	public Boolean getEstadoSemestre() {
		return estadoSemestre;
	}
	public void setEstadoSemestre(Boolean estadoSemestre) {
		this.estadoSemestre = estadoSemestre;
	}
	public Boolean getSemestre() {
		return semestre;
	}
	public void setSemestre(Boolean semestre) {
		this.semestre = semestre;
	}
	public String getCorreoDocente() {
		return correoDocente;
	}
	public void setCorreoDocente(String correoDocente) {
		this.correoDocente = correoDocente;
	}
	public Date getHorainiclase() {
		return horainiclase;
	}
	public void setHorainiclase(Date horainiclase) {
		this.horainiclase = horainiclase;
	}
	public Date getHorafinclase() {
		return horafinclase;
	}
	public void setHorafinclase(Date horafinclase) {
		this.horafinclase = horafinclase;
	}
}
