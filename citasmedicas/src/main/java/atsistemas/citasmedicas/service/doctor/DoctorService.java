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
	 * @return listado de doctores
	 */
	List<DoctorDTO> findAll(Integer page, Integer size);

	/**
	 * Transforma un doctor en un doctorDTO
	 * 
	 * @param Doctor
	 * @return
	 */
	DoctorDTO transform(Doctor doctor);


	/**
	 * Transforma un doctoDTO en un doctor
	 * 
	 * @param doctor
	 * @return
	 */
	Doctor transform(DoctorDTO doctor);


	/**
	 * Busca por id
	 * 
	 * @param id
	 * @return
	 */

	DoctorDTO findById(String id);

	/**
	 * Crea un doctor
	 * 
	 * @param doctor
	 * @return DoctorDTO
	 */
	DoctorDTO create(DoctorDTO doctor);

	/**
	 * Modifica un doctor
	 * 
	 * @param doctor
	 */
	public void update(DoctorDTO doctorDTO, String idDoctor);

	/**
	 * Borra un Doctor
	 * 
	 * @param id
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
/*	
	/**
	 * Devuelve todas las consultas de un determinado doctor
	 * 
	 * @param String
	 * 
	 * @return List<ConsultaDTO> 
	 
	public List<ConsultaDTO> findConsultations(String id);
*/	
	/**
	 * Inserta los doctores de la Api externa en mi DB
	 * 
	 * @param DoctorDTO[]
	 */
	public void InsertApidoctor(DoctorDTO[] template);
/*
	/**
	 * Obtiene todos los doctores
	 * 
	 * @return DoctorDTO
	 
	public DoctorDTO[] ApiPages ();
*/
	/**
	 * Devuelve el salario de un doctor
	 * Consultas que ha ejercido por el precio de la consulta
	 * 
	 * @param doctor_id, initdate, finishdate
	 * @return float
	 */
	public float totalprice(String id, Date initdate, Date finishdate);
	
	/**
	 * Devuelve los doctores con mas pacientes
	 * 
	 * @param List<Doctor>
	 * @return num?
	 */
//	public List<Doctor> findTopNByDoctorsWithMorePatients(Integer num);
//	public List<Doctor> topDoctors(/*Integer num*/) ;
//	public Page<Doctor> topDoctors(/*Integer num*/) ;
	public Page<Doctor> topdoctors();


}
