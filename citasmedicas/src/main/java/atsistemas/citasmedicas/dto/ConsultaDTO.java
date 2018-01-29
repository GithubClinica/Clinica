package atsistemas.citasmedicas.dto;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import org.springframework.format.annotation.DateTimeFormat;

import atsistemas.citasmedicas.enums.TurnoEnum;
import atsistemas.citasmedicas.model.Cita;

public class ConsultaDTO implements Serializable {

	private static final long serialVersionUID = -2489202374263393532L;
	
	private Integer id;
	
	private Date fechaConsulta;
	
	private TurnoEnum turno;
	
	private String doctor;
	
	private Integer sala;
	
	private List<Cita> citas;

	public ConsultaDTO(Integer id, Date fechaConsulta, TurnoEnum turno, String doctor, Integer sala) {
		super();
		this.id = id;
		this.fechaConsulta = fechaConsulta;
		this.turno = turno;
		this.doctor = doctor;
		this.sala = sala;
	}

	public ConsultaDTO() {
		super();
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}
	
//	@DateTimeFormat (pattern="yyyy-MM-dd")
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

	public String getDoctor() {
		return doctor;
	}

	public void setDoctor(String doctor) {
		this.doctor = doctor;
	}

	public Integer getSala() {
		return sala;
	}

	public void setSala(Integer sala) {
		this.sala = sala;
	}
	

	public List<Cita> getCitas() {
		return citas;
	}

	public void setCitas(List<Cita> citas) {
		citas = citas;
	}
}
