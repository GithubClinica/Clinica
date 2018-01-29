package atsistemas.citasmedicas.dao;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import atsistemas.citasmedicas.model.Consulta;

@Repository
public interface ConsultaDao extends PagingAndSortingRepository<Consulta, Integer> {
	
	public Consulta findById(@Param(value = "id") Integer id);


}
