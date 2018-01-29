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

import atsistemas.citasmedicas.dto.ClinicaDTO;
import atsistemas.citasmedicas.dto.SalaDTO;
import atsistemas.citasmedicas.service.Clinica.ClinicaService;
import atsistemas.citasmedicas.service.Sala.SalaService;

@RestController
@RequestMapping(value = "/api/clinica")
public class ClinicaController {

	@Autowired
	private ClinicaService clinicaservice;
	
	@Autowired
	private SalaService salaService;
	
	private static final Logger log = LoggerFactory.getLogger(ClinicaController.class);

	@RequestMapping(method =  RequestMethod.GET)
	public List<ClinicaDTO> findAll(@RequestParam(required = false, defaultValue="0") Integer page,
			@RequestParam(required = false, defaultValue="10") Integer size) {
		log.debug("Buscando todos los clinicaes en el sistema");
		return clinicaservice.findAll(page, size);
	}

	@RequestMapping(method = RequestMethod.GET, value = "/{id}")
	public ClinicaDTO findById(@PathVariable Integer id) {
		log.debug(String.format("Buscando un clinica con id %s", id));
		return clinicaservice.findById(id);
	}

	@RequestMapping(method = RequestMethod.POST)
	public ClinicaDTO create(@RequestBody ClinicaDTO clinica) {
		log.debug(String.format("Se crear el clinica siguiente: %s", clinica));
		return clinicaservice.create(clinica);
	}

	@RequestMapping(method = RequestMethod.PUT, value = "/{id}")
	public void update(@PathVariable Integer id, @RequestBody ClinicaDTO clinica) {
		log.debug(String.format("Vamos a modificar el clinica: %s", clinica));
		clinicaservice.update(clinica,id);
	}

	@RequestMapping(method = RequestMethod.DELETE, value = "/{id}")
	public void delete(@PathVariable Integer id) {
		log.debug(String.format("Vamos a borrar el clinica con id %s", id));
		clinicaservice.delete(id);
	}	

	@RequestMapping(method = RequestMethod.GET, value = "/{id}/salas")
	public List<SalaDTO> findSalas (@PathVariable Integer id) {
		log.debug(String.format("Obtenemos las salas de una clinica con id %s", id));
		return clinicaservice.findSalas(id);
	}
}
