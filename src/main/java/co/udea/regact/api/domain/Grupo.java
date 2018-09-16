package co.udea.regact.api.domain;


import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name = "grupo")
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
	
	@Column(name = "gru_horarioclase")
	@Temporal(TemporalType.TIME)
	private Date  horarioclase;
	
	@Column(name = "gru_estado")
	private Boolean estado;

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

	public Date getHorarioclase() {
		return horarioclase;
	}

	public void setHorarioclase(Date horarioclase) {
		this.horarioclase = horarioclase;
	}

	public Boolean getEstado() {
		return estado;
	}

	public void setEstado(Boolean estado) {
		this.estado = estado;
	}
	
	
	
	
	
	

}
