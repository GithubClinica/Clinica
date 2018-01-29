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
	 *  @param Integer, Integer
	 *  
	 * @return List<CitaDTO>
	 */
	List<CitaDTO> findAll(Integer page, Integer size);

	/**
	 * Transforma un cita en un citaDTO
	 * 
	 * @param Cita
	 * @return CitaDTO
	 */
	CitaDTO transform(Cita cita);


	/**
	 * Transforma un CitaDTO en un cita
	 * 
	 * @param CitaDTO
	 * @return Cita
	 */
	Cita transform(CitaDTO cita);


	/**
	 * Busca una cita por id
	 * 
	 * @param Integer
	 * @return CitaDTO
	 */

	CitaDTO findById(Integer id);

	/**
	 * Crea un cita
	 * 
	 * @param CitaDTO
	 * @return CitaDTO
	 */
	CitaDTO create(CitaDTO cita);

	/**
	 * Modifica un cita
	 * 
	 * @param CitaDTO, Integer
	 */
	void update(CitaDTO cita, Integer idCita);

	/**
	 * Borra un Cita
	 * 
	 * @param Integer
	 */
	void delete(Integer id);
	
	/**
	 * Mete en el objeto de la base datos el objeto actualizado
	 * 
	 * @param Cita, Cita 
	 */
	void modify(Cita old, Cita act);

}
