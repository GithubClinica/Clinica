package atsistemas.citasmedicas.service.Clinica;

import java.util.List;

import atsistemas.citasmedicas.dto.ClinicaDTO;
import atsistemas.citasmedicas.dto.SalaDTO;
import atsistemas.citasmedicas.model.Clinica;

public interface ClinicaService {

		/**
		 * Realiza la busqueda de todos las clinicas existentes
		 * 
		 * @param Integer, Integer
		 * @return List<SalaDTO>
		 */
		List<ClinicaDTO> findAll(Integer page, Integer size);

		/**
		 * Transforma una Clinica en una ClinicaDTO
		 * 
		 * @param Clinica
		 * @return ClinicaDTO
		 */
		ClinicaDTO transform(Clinica clinica);


		/**
		 * Transforma un doctoDTO en un clinica
		 * 
		 * @param ClinicaDTO
		 * @return Clinica
		 */
		Clinica transform(ClinicaDTO clinica);


		/**
		 * Busca una clínica por id
		 * 
		 * @param Integer
		 * @return ClinicaDTO
		 */

		ClinicaDTO findById(Integer id);

		/**
		 * Crea un clinica
		 * 
		 * @param ClinicaDTO
		 * @return ClinicaDTO
		 */
		ClinicaDTO create(ClinicaDTO clinica);

		/**
		 * Modifica un clinica
		 * 
		 * @param ClinicaDTO, Integer
		 */
		void update(ClinicaDTO clinica, Integer IdClinica);

		/**
		 * Borra un Clinica
		 * 
		 * @param Integer
		 */
		void delete(Integer id);

		/**
		 * Mete en el objeto de la base datos el objeto actualizado
		 * 
		 * @param Clinica,Clinica 
		 */
		void modify(Clinica old, Clinica act);
		
		/**
		 * Obtiene las Salas a partir de una clinica
		 * 
		 * @param Integer
		 * 
		 * * @return List<SalaDTO>
		 */
		public List<SalaDTO> findSalas(Integer id);
}
