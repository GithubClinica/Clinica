package atsistemas.citasmedicas.dto;

import java.io.Serializable;
import java.util.List;

import atsistemas.citasmedicas.model.Consulta;
import atsistemas.citasmedicas.model.Sala;

public class ClinicaDTO implements Serializable {

	private static final long serialVersionUID = -1887577701385776361L;

	private Integer id;

	private String name;

//	private List<Consulta> Consultas;
	private List<Sala> salas;

	public ClinicaDTO(Integer id, String name) {
		super();
		this.id = id;
		this.name = name;
	}

	public ClinicaDTO() {
		super();
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
/*
	public List<Consulta> getConsultas() {
		return Consultas;
	}

	public void setConsultas(List<Consulta> consultas) {
		Consultas = consultas;
	}
*/	
	public List<Sala> getSalas() {
		return salas;
	}

	public void setSalas(List<Sala> salas) {
		this.salas = salas;
	}
}
