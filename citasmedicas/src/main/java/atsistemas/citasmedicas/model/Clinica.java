package atsistemas.citasmedicas.model;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import java.util.ArrayList;
import java.util.List;
import lombok.Getter;
import lombok.Setter;

@Entity
//@Getter
//@Setter
public class Clinica {

	@Id
	@GeneratedValue
	private Integer id;

	private String name;

	// Relación 1 a n de clinica a sala
	@OneToMany(fetch = FetchType.LAZY, mappedBy = "clinica")
	private List<Sala> salas = new ArrayList<>();

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


	public List<Sala> getSalas() {
		return salas;
	}

	public void setSalas(List<Sala> Salas) {
		this.salas = salas;
	}


}
