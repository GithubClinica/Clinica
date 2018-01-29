package atsistemas.citasmedicas.model;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.springframework.format.annotation.DateTimeFormat;


@Entity
// @Getter
// @Setter
// @SequenceGenerator(name="ordencita", initialValue=1, allocationSize=8)
public class Cita implements Serializable {

	private static final long serialVersionUID = 7413758698575603096L;

	@Id
	@GeneratedValue
	private Integer id;
/*
	@SequenceGenerator(
		    name="ordencita",
		    sequenceName = "ORDENCITA_SEQ",
		    initialValue = 1, 
		    allocationSize = 5
		)
	
	@Id 
	@GeneratedValue (strategy = GenerationType.SEQUENCE, generator = "ordencita")*/
	private Integer orden;

	@Temporal(TemporalType.TIMESTAMP)
	@DateTimeFormat(pattern = "yyyy/mm/dd")
	private Date diacita;

//	@Mapping ("pacienteId") 
	@ManyToOne(fetch = FetchType.LAZY)
	private Paciente paciente;

	@ManyToOne(fetch = FetchType.LAZY)
	private Consulta consulta;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}
	
	public Integer getOrden() {
		return orden;
	}

	public void setOrden(Integer orden) {
		this.orden = orden;
	}

	public Date getDiacita() {
		return diacita;
	}

	public void setDiacita(Date diacita) {
		this.diacita = diacita;
	}
	
	public Paciente getPaciente() {
		return paciente;
	}

	public void setPaciente(Paciente paciente) {
		this.paciente = paciente;
	}

	public Consulta getConsulta() {
		return consulta;
	}

	public void setConsulta(Consulta consulta) {
		this.consulta = consulta;
	}

}
