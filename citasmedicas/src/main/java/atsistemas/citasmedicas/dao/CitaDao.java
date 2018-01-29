package atsistemas.citasmedicas.dao;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import atsistemas.citasmedicas.model.Cita;

@Repository
public interface CitaDao extends PagingAndSortingRepository <Cita, Integer> {

	public Cita findById(@Param(value = "id") Integer id);
}
