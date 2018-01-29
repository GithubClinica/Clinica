package atsistemas.citasmedicas.service.Consulta;

import java.util.List;

import atsistemas.citasmedicas.dto.ConsultaDTO;
import atsistemas.citasmedicas.model.Consulta;

public interface ConsultaService {

	/**
	 * Realiza la busqueda de todos los Consultaes existentes
	 * 
	 * @return listado de consultaes
	 */
	List<ConsultaDTO> findAll(Integer page, Integer size);

	/**
	 * Transforma un consulta en un consultaDTO
	 * 
	 * @param Consulta
	 * @return
	 */
	ConsultaDTO transform(Consulta consulta);


	/**
	 * Transforma un doctoDTO en un consulta
	 * 
	 * @param consulta
	 * @return
	 */
	Consulta transform(ConsultaDTO consulta);

	/**
	 * Busca por id
	 * 
	 * @param id
	 * @return
	 */

	ConsultaDTO findById(Integer id);

	/**
	 * Crea un consulta
	 * 
	 * @param consulta
	 * @return
	 */
	ConsultaDTO create(ConsultaDTO consulta);
	

	/**
	 * Modifica un consulta, id
	 * 
	 * @param consulta
	 */
	
//	void update(ConsultaDTO consulta);
	void update(ConsultaDTO consultaDTO, Integer idConsulta);

	/**
	 * Borra un Consulta
	 * 
	 * @param id
	 */
	void delete(Integer id);
	
	/**
	 * Para el metodo update mete en el objeto de la base datos lo actualizado
	 * 
	 * @param old, act (de tipo Consulta)
	 */
	void modify(Consulta old, Consulta act);

}
