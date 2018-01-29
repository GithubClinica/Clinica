package atsistemas.citasmedicas.service.Sala;

import java.util.List;

import atsistemas.citasmedicas.dto.SalaDTO;
import atsistemas.citasmedicas.model.Doctor;
import atsistemas.citasmedicas.model.Sala;

public interface SalaService {
	
	/**
	 * Realiza la busqueda de todos las salas existentes
	 * 
	 * @return listado de salas
	 */
	List<SalaDTO> findAll(Integer page, Integer size);

	/**
	 * Transforma una Sala en una SalaDTO
	 * 
	 * @param Objeto Sala
	 * @return
	 */
	SalaDTO transform(Sala sala);


	/**
	 * Transforma un doctoDTO en un sala
	 * 
	 * @param sala
	 * @return
	 */
	Sala transform(SalaDTO sala);


	/**
	 * Busca por id
	 * 
	 * @param id
	 * @return SalaDTO
	 */

	SalaDTO findById(Integer id);

	/**
	 * Crea un sala
	 * 
	 * @param SalaDTO
	 * @return SalaDTO
	 */
	SalaDTO create(SalaDTO sala);

	/**
	 * Modifica un sala
	 * 
	 * @param SalaDTO, Integer
	 */
	void update(SalaDTO sala, Integer IdSala);

	/**
	 * Borra un Sala
	 * 
	 * @param id
	 */
	void delete(Integer id);

	/**
	 * Mete en el objeto de la base datos el objeto actualizado
	 * 
	 * @param Sala,Sala 
	 */
	void modify(Sala old, Sala act);
}
