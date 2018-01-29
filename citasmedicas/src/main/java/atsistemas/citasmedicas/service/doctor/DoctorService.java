package atsistemas.citasmedicas.service.doctor;

import java.util.Date;
import java.util.List;

import org.springframework.data.domain.Page;

import atsistemas.citasmedicas.dto.ConsultaDTO;
import atsistemas.citasmedicas.dto.DoctorDTO;
import atsistemas.citasmedicas.model.Doctor;

public interface DoctorService {
	
//	Doctor map(MedicoDTO dto);
	
//	MedicoDTO map(Doctor medico);
	
	/**
	 * Realiza la busqueda de todos los Doctores existentes
	 * 
	 * @return List<DoctorDTO>
	 */
	List<DoctorDTO> findAll(Integer page, Integer size);

	/**
	 * Transforma un doctor en un doctorDTO
	 * 
	 * @param Doctor
	 * @returnDoctorDTO
	 */
	DoctorDTO transform(Doctor doctor);


	/**
	 * Transforma un doctoDTO en un doctor
	 * 
	 * @param DoctorDTO
	 * @return Doctor
	 */
	Doctor transform(DoctorDTO doctor);


	/**
	 * Busca por id
	 * 
	 * @param String
	 * @return
	 */

	DoctorDTO findById(String id);

	/**
	 * Crea un doctor
	 * 
	 * @param DoctorDTO
	 * @return DoctorDTO
	 */
	DoctorDTO create(DoctorDTO doctor);

	/**
	 * Modifica un doctor
	 * 
	 * @param DoctorDTO, String
	 */
	public void update(DoctorDTO doctorDTO, String idDoctor);

	/**
	 * Borra un Doctor
	 * 
	 * @param String
	 */
	void delete(String id);
	
	/**
	 * Inserta en el objeto de la base datos el objeto actualizado
	 * 
	 * @param Doctor, Doctor 
	 */
	public void modify(Doctor old, Doctor act);

	/**
	 * Encuentra los doctores con nombre e id
	 * 
	 * @param DoctorDTO
	 * @return List<Doctor> 
	 */
	public List<Doctor> findByCriteria(DoctorDTO DoctorQueryParams);

	/**
	 * Inserta los doctores de la Api externa en mi DB
	 * 
	 * @param DoctorDTO[]
	 */
	public void InsertApidoctor(DoctorDTO[] template);

	/**
	 * Devuelve el salario de un doctor
	 * Consultas que ha ejercido por el precio de la consulta
	 * 
	 * @param doctor_id, initdate, finishdate
	 * @return float
	 */
	public float totalprice(String id, Date initdate, Date finishdate);
	
	/**
	 * Devuelve los doctores con mas pacientes paginado a 5
	 * 
	 * @param Page<Doctor>
	 */
	public Page<Doctor> topdoctors();


}
