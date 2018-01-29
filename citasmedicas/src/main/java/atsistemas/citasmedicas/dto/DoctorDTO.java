package atsistemas.citasmedicas.dto;

import java.io.Serializable;
import java.util.List;
import java.util.Set;

import atsistemas.citasmedicas.model.Consulta;

//@Data
//@Getter
//@Setter
//@AllArgsConstructor
public class DoctorDTO implements Serializable {	

	private static final long serialVersionUID = -1677805754807035277L;

	private String id;
	
	private String name;
	
	private float price;
	
//	@JsonFormat(with = JsonFormat.Feature.ACCEPT_SINGLE_VALUE_AS_ARRAY)
//	private List<Consulta> consultas;
	

	public DoctorDTO ( String id, String name, float price/*List<Consulta> consultas*/) {
	super();
	this.id = id;
	this.name = name;
	this.price = price;
//	this.consultas = consultas;

	}
	
	public DoctorDTO () {
		super();
	}
	
	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
	public float getPrice() {
		return price;
	}

	public void setPrice(float price) {
		this.price = price;
	}
/*
	public List<Consulta> getConsultas() {
		return consultas;
	}

	public void setConsultas(List<Consulta> consultas) {
		this.consultas = consultas;
	}
*/
}

