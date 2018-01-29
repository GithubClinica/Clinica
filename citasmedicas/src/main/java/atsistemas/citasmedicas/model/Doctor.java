package atsistemas.citasmedicas.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
// @Getter
// @Setter
public class Doctor implements Serializable {

	private static final long serialVersionUID = 2710912514628704112L;

	@Id
//	@GeneratedValue
	private String id;

	private String name;
	
	private float price;

//	private String email;

	// Relación 1 a n de medico a consulta
	@OneToMany(fetch = FetchType.LAZY, mappedBy = "doctor")
	private List<Consulta> Consultas = new ArrayList<>() ;

	// @Override
	public String toString() {
		return String.valueOf(id);
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
	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}
*/


}
