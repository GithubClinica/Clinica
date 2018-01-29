package atsistemas.citasmedicas.dao;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import atsistemas.citasmedicas.model.Sala;

@Repository
public interface SalaDao extends PagingAndSortingRepository<Sala, Integer>{

	public Sala findById(@Param(value = "id") Integer id);

}
