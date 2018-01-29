package atsistemas.citasmedicas.service.paciente;

import java.util.List;

import atsistemas.citasmedicas.dto.CitaDTO;
import atsistemas.citasmedicas.dto.PacienteDTO;
import atsistemas.citasmedicas.model.Paciente;

public interface PacienteService {
	
	
	/**
	 * Realiza la busqueda de todos los Pacientees existentes
	 * 
	 * @param Integer, Integer
	 * @return List<PacienteDTO>
	 */
	List<PacienteDTO> findAll(Integer page, Integer size);

	/**
	 * Transforma un paciente en un pacienteDTO
	 * 
	 * @param Paciente
	 * @return PacienteDTO
	 */
	PacienteDTO transform(Paciente paciente);


	/**
	 * Transforma un pacienteDTO a paciente
	 * 
	 * @param PacienteDTO
	 * @return Paciente
	 */
	Paciente transform(PacienteDTO paciente);


	/**
	 * Busca un paciente por id
	 * 
	 * @param Integer
	 * @return PacienteDTO
	 */

	PacienteDTO findById(Integer id);

	/**
	 * Crea un paciente
	 * 
	 * @param Paciente
	 * @return PacienteDTO
	 */
	PacienteDTO create(PacienteDTO paciente);

	/**
	 * Modifica un paciente
	 * 
	 * @param PacienteDTO,  Integer
	 */
	void update(PacienteDTO paciente, Integer idPaciente);

	/**
	 * Borra un Paciente
	 * 
	 * @param Integer
	 */
	void delete(Integer id);
	
	/**
	 * Mete en el objeto de la base datos el objeto actualizado
	 * 
	 * @param Paciente, Paciente 
	 */
	void modify(Paciente old, Paciente act);
	
	/**
	 * Obtiene las citas a partir de un paciente
	 * 
	 * @param id
	 * 
	 * * @return List<SalaDTO>
	 */
	public List<CitaDTO>findCitas(Integer id);

}
