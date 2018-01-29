package atsistemas.citasmedicas.service.cita;

import java.util.List;

import atsistemas.citasmedicas.dto.CitaDTO;
import atsistemas.citasmedicas.exceptions.NotFoundException;
import atsistemas.citasmedicas.model.Cita;
import atsistemas.citasmedicas.model.Clinica;

public interface CitaService {
	
	/**
	 * Realiza la busqueda de todos los Citas existentes
	 * 
	 * @return listado de citas
	 */
	List<CitaDTO> findAll(Integer page, Integer size);

	/**
	 * Transforma un cita en un citaDTO
	 * 
	 * @param Cita
	 * @return
	 */
	CitaDTO transform(Cita cita);


	/**
	 * Transforma un doctoDTO en un cita
	 * 
	 * @param cita
	 * @return
	 */
	Cita transform(CitaDTO cita);


	/**
	 * Busca por id
	 * 
	 * @param id
	 * @return
	 */

	CitaDTO findById(Integer id);

	/**
	 * Crea un cita
	 * 
	 * @param cita
	 * @return
	 */
	CitaDTO create(CitaDTO cita);

	/**
	 * Modifica un cita
	 * 
	 * @param cita
	 */
	void update(CitaDTO cita, Integer idCita);

	/**
	 * Borra un Cita
	 * 
	 * @param id
	 */
	void delete(Integer id);
	
	/**
	 * Mete en el objeto de la base datos el objeto actualizado
	 * 
	 * @param Cita, Cita 
	 */
	void modify(Cita old, Cita act);
	
//	public Cita DTOaCita (CitaDTO cita) throws NotFoundException;

}
