package atsistemas.citasmedicas.dao;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;


import atsistemas.citasmedicas.model.Paciente;

@Repository
public interface PacienteDao extends PagingAndSortingRepository<Paciente, Integer>{

	public Paciente findById(@Param(value = "id") Integer id);

}
