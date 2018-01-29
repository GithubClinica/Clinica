package atsistemas.citasmedicas.Controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import atsistemas.citasmedicas.dto.CitaDTO;
import atsistemas.citasmedicas.dto.PacienteDTO;
import atsistemas.citasmedicas.service.cita.CitaService;
import atsistemas.citasmedicas.service.paciente.PacienteService;

@RestController
@RequestMapping(value = "/api/paciente")
public class PacienteController {

		@Autowired
		private PacienteService pacienteservice;
		
		@Autowired
		private CitaService citaService;
		
		private static final Logger log = LoggerFactory.getLogger(PacienteController.class);

		@RequestMapping(method =  RequestMethod.GET)
		public List<PacienteDTO> findAll(@RequestParam(required = false, defaultValue="0") Integer page,
				@RequestParam(required = false, defaultValue="10") Integer size) {
			log.debug("Buscando todos los pacientees en el sistema");
			return pacienteservice.findAll(page, size);
		}

		@RequestMapping(method = RequestMethod.GET, value = "/{id}")
		public PacienteDTO findById(@PathVariable Integer id) {
			log.debug(String.format("Buscando un paciente con id %s", id));
			return pacienteservice.findById(id);
		}

		@RequestMapping(method = RequestMethod.POST)
		public PacienteDTO create(@RequestBody PacienteDTO paciente) {
			log.debug(String.format("Se crear el paciente siguiente: %s", paciente));
			return pacienteservice.create(paciente);
		}

		@RequestMapping(method = RequestMethod.PUT, value = "/{id}")
		public void update(@PathVariable Integer id, @RequestBody PacienteDTO paciente) {
			log.debug(String.format("Vamos a modificar el paciente: %s", paciente));
			pacienteservice.update(paciente,id);
		}

		@RequestMapping(method = RequestMethod.DELETE, value = "/{id}")
		public void delete(@PathVariable Integer id) {
			log.debug(String.format("Vamos a borrar el paciente con id %s", id));
			pacienteservice.delete(id);
		}	
		
		@RequestMapping(method = RequestMethod.GET, value = "/{id}/citas")
		public List<CitaDTO> findCitas (@PathVariable Integer id) {
			log.debug(String.format("Obtenemos las citas de un paciente con id %s", id));
			return pacienteservice.findCitas(id);
		}

}
