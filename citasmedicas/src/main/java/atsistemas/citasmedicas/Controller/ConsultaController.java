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

import atsistemas.citasmedicas.dto.ConsultaDTO;
import atsistemas.citasmedicas.service.Consulta.ConsultaService;

@RestController
@RequestMapping(value = "/api/consulta")
public class ConsultaController {

	@Autowired
	private ConsultaService consultaservice;
	
	private static final Logger log = LoggerFactory.getLogger(ConsultaController.class);

	@RequestMapping(method =  RequestMethod.GET)
	public List<ConsultaDTO> findAll(@RequestParam(required = false, defaultValue="0") Integer page,
			@RequestParam(required = false, defaultValue="10") Integer size) {
		log.debug("Buscando todos los consultaes en el sistema");
		return consultaservice.findAll(page, size);
	}

	@RequestMapping(method = RequestMethod.GET, value = "/{id}")
	public ConsultaDTO findById(@PathVariable Integer id) {
		log.debug(String.format("Buscando un consulta con id %s", id));
		return consultaservice.findById(id);
	}

	@RequestMapping(method = RequestMethod.POST)
	public ConsultaDTO create(@RequestBody ConsultaDTO consulta) {
		log.debug(String.format("Se crear el consulta siguiente: %s", consulta));
		return consultaservice.create(consulta);
	}

	@RequestMapping(method = RequestMethod.PUT, value = "/{id}")
	public void update( @RequestBody ConsultaDTO consulta, @PathVariable Integer id) {
		log.debug(String.format("Vamos a modificar el consulta: %s", consulta));
		consultaservice.update(consulta,id);
	}

	@RequestMapping(method = RequestMethod.DELETE, value = "/{id}")
	public void delete(@PathVariable Integer id) {
		log.debug(String.format("Vamos a borrar el consulta con id %s", id));
		consultaservice.delete(id);
	}
}
