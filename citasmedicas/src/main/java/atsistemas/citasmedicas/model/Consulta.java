package atsistemas.citasmedicas.model;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import atsistemas.citasmedicas.enums.TurnoEnum;

@Entity
//@Getter
//@Setter
public class Consulta {
	
	@Id
	@GeneratedValue
	private Integer id;

	@Temporal (value = TemporalType.DATE)
	private Date fechaConsulta;
	
	//si no se especifica string por defecto es ordinal
	@Enumerated (EnumType.STRING)
	private TurnoEnum turno;
	
	// Tiene el mismo nombre (listacitas) que en pacientes mirar si es correcto 
	@OneToMany(fetch = FetchType.LAZY, mappedBy ="consulta")
	private List<Cita> Citas = new ArrayList<>();

	@ManyToOne (fetch = FetchType.LAZY)
	private Doctor doctor;
	
	@ManyToOne (fetch = FetchType.LAZY)
	private Sala sala;
	
	public Integer getId() {
		return id;
	}
 
	public void setId(Integer id) {
		this.id = id;
	}
	
	public Date getFechaConsulta() {
		return fechaConsulta;
	}

	public void setFechaConsulta(Date fechaConsulta) {
		this.fechaConsulta = fechaConsulta;
	}

	public TurnoEnum getTurno() {
		return turno;
	}

	public void setTurno(TurnoEnum turno) {
		this.turno = turno;
	}

	public Doctor getDoctor() {
		return doctor;
	}

	public void setDoctor(Doctor doctor) {
		this.doctor = doctor;
	}

	public Sala getSala() {
		return sala;
	}

	public void setSala(Sala sala) {
		this.sala = sala;
	}
	
	
	public List<Cita> getCitas() {
		return Citas;
	}

	public void setCitas(List<Cita> citas) {
		Citas = citas;
	}


}

