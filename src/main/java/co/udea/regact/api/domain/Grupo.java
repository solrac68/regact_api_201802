package co.udea.regact.api.domain;


import java.util.Date;
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

@Entity
@Table(name = "GRUPOS")
public class Grupo {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "gru_id")
	private Integer id;
	
	@Column(name = "gru_nombre")
	private String nombre;
	
	@Column(name = "gru_cantidadestudiantes")
	private int cantidadestudiantes;
	
	@Column(name = "gru_diaclase")
	private String  diaclase;
	
	@Column(name = "gru_horainiclase")
	@Temporal(TemporalType.TIME)
	private Date  horainiclase;
	
	@Column(name = "gru_horafinclase")
	@Temporal(TemporalType.TIME)
	private Date  horafinclase;

	@Temporal(TemporalType.DATE)
	@Column(name = "gru_fechainicio")
	private Date fechaInicio;

	@Temporal(TemporalType.DATE)
	@Column(name = "gru_fechafin")
	private Date fechaFin;
	
	@Column(name = "gru_estado")
	private Boolean estado;
	
	@ManyToOne
    @JoinColumn(name = "gru_cur_id")
	private Curso curso;
	
	@ManyToOne
    @JoinColumn(name = "gru_sem_id")
	private Semestre semestre;
	
	@ManyToOne
	@JoinColumn(name = "gru_doce_email")
	private Docente docente;

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

	public Boolean getEstado() {
		return estado;
	}

	public void setEstado(Boolean estado) {
		this.estado = estado;
	}

	public Curso getCurso() {
		return curso;
	}

	public void setCurso(Curso curso) {
		this.curso = curso;
	}

	public Semestre getSemestre() {
		return semestre;
	}

	public void setSemestre(Semestre semestre) {
		this.semestre = semestre;
	}

	public Docente getDocente() {
		return docente;
	}

	public void setDocente(Docente docente) {
		this.docente = docente;
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
