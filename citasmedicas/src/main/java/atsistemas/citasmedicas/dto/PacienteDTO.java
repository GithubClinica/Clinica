package atsistemas.citasmedicas.dto;

import java.io.Serializable;
import java.util.List;

import atsistemas.citasmedicas.model.Cita;


//@Data de lombok
public class PacienteDTO implements Serializable {

	private static final long serialVersionUID = 7354727676433845111L;

	private Integer id;
	
	private String name;
	
	private String email;
	
	 private List<Cita> citas;

	public PacienteDTO ( Integer id, String name, String email) {
	super();
	this.id = id;
	this.name = name;
	this.email = email;
	}
	
	public PacienteDTO (Integer id) {
		super();
		this.id = id;
	}
	
	public PacienteDTO () {
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

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}
	
	public List<Cita> getCitas() {
		return citas;
	}

	public void setCitas(List<Cita> citas) {
		this.citas = citas;
	}
	
}
