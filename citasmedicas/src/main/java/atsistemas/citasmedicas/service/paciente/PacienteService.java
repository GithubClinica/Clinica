package atsistemas.citasmedicas.service.paciente;

import java.util.List;

import atsistemas.citasmedicas.dto.CitaDTO;
import atsistemas.citasmedicas.dto.PacienteDTO;
import atsistemas.citasmedicas.model.Paciente;

public interface PacienteService {
	
	
//	Doctor map(MedicoDTO dto);
	
//	MedicoDTO map(Doctor medico);
	
	/**
	 * Realiza la busqueda de todos los Pacientees existentes
	 * 
	 * @return listado de pacientees
	 */
	List<PacienteDTO> findAll(Integer page, Integer size);

	/**
	 * Transforma un paciente en un pacienteDTO
	 * 
	 * @param Paciente
	 * @return
	 */
	PacienteDTO transform(Paciente paciente);


	/**
	 * Transforma un doctoDTO en un paciente
	 * 
	 * @param paciente
	 * @return
	 */
	Paciente transform(PacienteDTO paciente);


	/**
	 * Busca por id
	 * 
	 * @param id
	 * @return
	 */

	PacienteDTO findById(Integer id);

	/**
	 * Crea un paciente
	 * 
	 * @param paciente
	 * @return
	 */
	PacienteDTO create(PacienteDTO paciente);

	/**
	 * Modifica un paciente
	 * 
	 * @param paciente
	 */
	void update(PacienteDTO paciente, Integer idPaciente);

	/**
	 * Borra un Paciente
	 * 
	 * @param id
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
