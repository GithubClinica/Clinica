package atsistemas.citasmedicas.dto;

import java.io.Serializable;
import java.util.List;

import atsistemas.citasmedicas.model.Consulta;

public class SalaDTO implements Serializable{


	private static final long serialVersionUID = 29308775355772271L;

	private Integer id;

	private String name;
	
	private Integer clinica;
	
	List<Consulta> consultas;

	public SalaDTO(Integer id, String name, Integer clinica) {
		super();
		this.id = id;
		this.name = name;
		this.clinica = clinica;
	}
	
	
	public SalaDTO() {
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

	public Integer getClinica() {
		return clinica;
	}

	public void setClinica(Integer clinica) {
		this.clinica = clinica;
	}
	
	public List<Consulta> getConsultas() {
		return consultas;
	}

	public void setConsultas(List<Consulta> consultas) {
		this.consultas = consultas;
	}
	
	public SalaDTO(Integer id, String name, Integer clinica, List<Consulta> consultas) {
		super();
		this.id = id;
		this.name = name;
		this.clinica = clinica;
		this.consultas = consultas;
	}

}
