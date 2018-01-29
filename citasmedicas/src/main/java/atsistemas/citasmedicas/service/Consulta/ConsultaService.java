package atsistemas.citasmedicas.service.Consulta;

import java.util.List;

import atsistemas.citasmedicas.dto.ConsultaDTO;
import atsistemas.citasmedicas.model.Consulta;

public interface ConsultaService {

	/**
	 * Realiza la busqueda de todos los Consultaes existentes
	 * 
	 * @return List<ConsultaDTO>
	 */
	List<ConsultaDTO> findAll(Integer page, Integer size);

	/**
	 * Transforma un consulta en un consultaDTO
	 * 
	 * @param Consulta
	 * @return ConsultaDTO
	 */
	ConsultaDTO transform(Consulta consulta);


	/**
	 * Transforma un doctoDTO en un consulta
	 * 
	 * @param ConsultaDTO
	 * @return Consulta
	 */
	Consulta transform(ConsultaDTO consulta);

	/**
	 * Busca por id
	 * 
	 * @param Integer
	 * @return
	 */

	ConsultaDTO findById(Integer id);

	/**
	 * Crea un consulta
	 * 
	 * @param ConsultaDTO
	 * @return ConsultaDTO
	 */
	ConsultaDTO create(ConsultaDTO consulta);
	

	/**
	 * Modifica un consulta
	 * 
	 * @param ConsultaDTO, Integer
	 */
	
	void update(ConsultaDTO consultaDTO, Integer idConsulta);

	/**
	 * Borra un Consulta
	 * 
	 * @param Integer
	 */
	void delete(Integer id);
	
	/**
	 * Para el metodo update mete en el objeto de la base datos lo actualizado
	 * 
	 * @param Consulta, Consulta
	 */
	void modify(Consulta old, Consulta act);

}
