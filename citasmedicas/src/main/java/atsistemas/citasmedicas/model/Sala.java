package atsistemas.citasmedicas.model;

import java.io.Serializable;
import java.util.ArrayList;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

import java.util.List;
import lombok.Getter;
import lombok.Setter;

@Entity
//@Getter
//@Setter
public class Sala implements Serializable{

	private static final long serialVersionUID = 2438580784430424458L;

	@Id
	@GeneratedValue
	private Integer id;

	private String name;
	
	@ManyToOne (fetch = FetchType.LAZY)
	private Clinica clinica;
	
	// Relación 1 a n de sala a consulta
	@OneToMany(fetch = FetchType.LAZY, mappedBy = "sala")
	private List<Consulta> consultas = new ArrayList<>();
	
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

	public Clinica getClinica() {
		return clinica;
	}

	public void setClinica(Clinica clinica) {
		this.clinica = clinica;
	}
	
}
