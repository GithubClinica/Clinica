package atsistemas.citasmedicas.service.Sala;

import java.util.List;

import atsistemas.citasmedicas.dto.SalaDTO;
import atsistemas.citasmedicas.model.Doctor;
import atsistemas.citasmedicas.model.Sala;

public interface SalaService {
	
	/**
	 * Realiza la busqueda de todos las salas existentes
	 * 
	 * @param Integer, Integer
	 * 
	 * @return List<SalaDTO>
	 */
	List<SalaDTO> findAll(Integer page, Integer size);

	/**
	 * Transforma una Sala a SalaDTO
	 * 
	 * @param Sala
	 * @return SalaDTO
	 */
	SalaDTO transform(Sala sala);


	/**
	 * Transforma un doctoDTO en un sala
	 * 
	 * @param SalaDTO
	 * @return Sala
	 */
	Sala transform(SalaDTO sala);


	/**
	 * Busca por Sala por id
	 * 
	 * @param Integer
	 * @return SalaDTO
	 */

	SalaDTO findById(Integer id);

	/**
	 * Crea un sala
	 * 
	 * @param Sala
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
