package atsistemas.citasmedicas.dto;

import java.io.Serializable;
import java.util.Date;

import lombok.Data;

//@Data
// @Getter
// @Setter
public class CitaDTO implements Serializable {

	private static final long serialVersionUID = 6114656466237549276L;

	private Integer id;

	private Integer orden;

	private Integer paciente;

	private Integer consulta;

	private Date diacita;

	public CitaDTO(Integer id, Integer orden, Integer paciente, Integer consulta, Date diacita) {
		super();
		this.id = id;
		this.orden = orden;
		this.paciente = paciente;
		this.consulta = consulta;
		this.diacita = diacita;
	}

	public CitaDTO() {
		super();
	}

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

	public Integer getPaciente() {
		return paciente;
	}

	public void setPaciente(Integer paciente) {
		this.paciente = paciente;
	}

	public Integer getConsulta() {
		return consulta;
	}

	public void setConsulta(Integer consulta) {
		this.consulta = consulta;
	}

	public Date getDiacita() {
		return diacita;
	}

	public void setDiacita(Date diacita) {
		this.diacita = diacita;
	}

	/*
	@Override
	public String toString() {
		return "CitaDTO [id=" + id + ", orden=" + orden + ", paciente=" + paciente + ", consulta=" + consulta + ", diacita=" + diacita + "]";
	}
*/
}
