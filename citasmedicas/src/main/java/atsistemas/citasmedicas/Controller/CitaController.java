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
import atsistemas.citasmedicas.service.cita.CitaService;

@RestController
@RequestMapping(value = "/api/cita")
public class CitaController {
	
	@Autowired
	private CitaService citaService;

	private static final Logger log = LoggerFactory.getLogger(ClinicaController.class);

	@RequestMapping(method = { RequestMethod.GET })
	public List<CitaDTO> findAll(@RequestParam(required = false, defaultValue="0") Integer page,
			@RequestParam(required = false, defaultValue="10") Integer size) {
		 log.debug("Buscando todos los citaes en el sistema");
		return citaService.findAll(page, size);
	}

	@RequestMapping(method = RequestMethod.GET, value = "/{id}")
	public CitaDTO findOneById(@PathVariable Integer id) {
		 log.debug(String.format("Buscando un cita con id %s", id));
		return citaService.findById(id);
	}

	@RequestMapping(method = RequestMethod.POST)
	public CitaDTO create(@RequestBody CitaDTO cita) {
		 log.debug(String.format("Se crear el cita siguiente: %s", cita));
		return citaService.create(cita);
	}

	@RequestMapping(method = RequestMethod.PUT, value = "/{id}")
	public void update(@PathVariable Integer id, @RequestBody CitaDTO cita) {
		log.debug(String.format("Vamos a modificar el libro: %s", id));
		citaService.update(cita,id);
	}

	@RequestMapping(method = RequestMethod.DELETE, value = "/{id}")
	public void delete(@PathVariable Integer id) {
		log.debug(String.format("Vamos a borrar la cita con id %s", id));
		citaService.delete(id);
	}

}
