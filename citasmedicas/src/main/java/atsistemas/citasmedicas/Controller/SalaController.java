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

import atsistemas.citasmedicas.dto.SalaDTO;
import atsistemas.citasmedicas.service.Sala.SalaService;

@RestController
@RequestMapping(value = "/api/sala")
public class SalaController {

	@Autowired
	private SalaService salaservice;
	
	private static final Logger log = LoggerFactory.getLogger(SalaController.class);

	@RequestMapping(method =  RequestMethod.GET)
	public List<SalaDTO> findAll(@RequestParam(required = false, defaultValue="0") Integer page,
			@RequestParam(required = false, defaultValue="10") Integer size) {
		log.debug("Buscando todos los salaes en el sistema");
		return salaservice.findAll(page, size);
	}

	@RequestMapping(method = RequestMethod.GET, value = "/{id}")
	public SalaDTO findById(@PathVariable Integer id) {
		log.debug(String.format("Buscando un sala con id %s", id));
		return salaservice.findById(id);
	}

	@RequestMapping(method = RequestMethod.POST)
	public SalaDTO create(@RequestBody SalaDTO sala) {
		log.debug(String.format("Se crear el sala siguiente: %s", sala));
		return salaservice.create(sala);
	}

	@RequestMapping(method = RequestMethod.PUT, value = "/{id}")
	public void update(@PathVariable Integer id, @RequestBody SalaDTO sala) {
		log.debug(String.format("Vamos a modificar el sala: %s", sala));
		salaservice.update(sala,id);
	}

	@RequestMapping(method = RequestMethod.DELETE, value = "/{id}")
	public void delete(@PathVariable Integer id) {
		log.debug(String.format("Vamos a borrar el sala con id %s", id));
		salaservice.delete(id);
	}	

}
