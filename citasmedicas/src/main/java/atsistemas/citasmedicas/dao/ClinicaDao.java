package atsistemas.citasmedicas.dao;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import atsistemas.citasmedicas.model.Clinica;

@Repository
public interface ClinicaDao  extends PagingAndSortingRepository <Clinica, Integer> {

	public Clinica findById(@Param(value = "id") Integer id);
	
	
}
