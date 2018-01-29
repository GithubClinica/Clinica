package atsistemas.citasmedicas.Controller;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import atsistemas.citasmedicas.dto.DoctorDTO;
import atsistemas.citasmedicas.model.Doctor;
import atsistemas.citasmedicas.service.doctor.DoctorService;

@RestController
@RequestMapping(value = "/api/doctor")
public class DoctorController {

	@Autowired
	private DoctorService doctorservice;

	@Autowired
	private RestTemplate restTemplate;
	
	private static final Logger log = LoggerFactory.getLogger(DoctorController.class);

	@RequestMapping(value = "/apidoctores", method = RequestMethod.GET)
	public DoctorDTO[] ApifindAll(@RequestParam(required = false, defaultValue = "0") Integer page,
			@RequestParam(required = false, defaultValue = "10") Integer size){

		final DoctorDTO[] template =  restTemplate.getForObject("http://doctor.dbgjerez.es:8080/api/doctor/", DoctorDTO[].class);
		doctorservice.InsertApidoctor(template);
		return template;
	}

	@RequestMapping(method = RequestMethod.GET, value = "/apidoctores/{id}")
	public DoctorDTO ApifindById(@PathVariable(value = "id") String id) {
		
		final DoctorDTO forobject = restTemplate.getForObject("http://doctor.dbgjerez.es:8080/api/doctor/{id}", DoctorDTO.class, id);
		return forobject;
	}	

	@RequestMapping(method = RequestMethod.GET)
	public List<DoctorDTO> findAll(@RequestParam(required = false, defaultValue = "0") Integer page,
			@RequestParam(required = false, defaultValue = "10") Integer size) {
		log.debug("Buscando todos los doctores en el sistema");
		return doctorservice.findAll(page, size);
	}

	@RequestMapping(method = RequestMethod.GET, value = "/{id}")
	public DoctorDTO findById(@PathVariable String id) {
		log.debug(String.format("Buscando un doctor con id %s", id));
		return doctorservice.findById(id);
	}

	@RequestMapping(method = RequestMethod.POST)
	public DoctorDTO create(@RequestBody DoctorDTO doctor) {
		log.debug(String.format("Se crear el doctor siguiente: %s", doctor));
		return doctorservice.create(doctor);
	}

	@RequestMapping(method = RequestMethod.PUT, value = "/{id}")
	public void update(@PathVariable String id, @RequestBody DoctorDTO doctor) {
		log.debug(String.format("Vamos a modificar el doctor: %s", doctor));
		doctorservice.update(doctor,id);
	}

	@RequestMapping(method = RequestMethod.DELETE, value = "/{id}")
	public void delete(@PathVariable String id) {
		log.debug(String.format("Vamos a borrar el doctor con id %s", id));
		doctorservice.delete(id);
	}
/*	
	@RequestMapping(method = RequestMethod.GET, value = "/{id}/consultations")
	public List<ConsultaDTO> findConsultations(@PathVariable String id) {	
		return doctorservice.findConsultations(id);
	}
*/
	@RequestMapping(method = RequestMethod.GET, value = "/search")
	public List<Doctor> findByCriteria(DoctorDTO doctorQueryParams) {
		List<Doctor> doctors = doctorservice.findByCriteria(doctorQueryParams);
		log.debug(" Buscamos los doctores por criterios especificados en el Dao "
				+ "en este caso id y nombre ");
		return doctors;
	}

	@RequestMapping(method = RequestMethod.GET, value = "/orderby")
	public Page<Doctor> topDoctors () {
		log.debug(" Devolvemos los medicons no mayor numero de pacientes");
		return doctorservice.topdoctors();
	}

//=====================================================================================	
/*
//  pasando un n por url con las nuevas palabras Top y first
	@RequestMapping(method = RequestMethod.GET, value = "/starsdoctors={num}")
	public List<Doctor> findTopNByDoctorstars(@PathVariable Integer num) {
		return doctorservice.findTopNByDoctorstars(num);
	}
*/
//====================================================================================

// Encuentra el numero de cosultas de un medico por id, entre 2 fechas, y muestra el dinero ganado
	@RequestMapping(method = RequestMethod.GET, value = "/stats/id={id}&initdate={initdatee}&finishdate={finishdatee}")
	public float totalprice (@PathVariable(value = "id") String id, @PathVariable String initdatee, @PathVariable String finishdatee) throws ParseException  {
	log.debug("Se busca el numero de cosultas de un Doctor entre un intevalo de fechas, "
			+ "y muestra el dinero ganado del Doctor con id = %s", id);
	SimpleDateFormat dateformat = new SimpleDateFormat ("yyyy-mm-dd");
	Date initdate = dateformat.parse(initdatee);
	Date finishdate = dateformat.parse(finishdatee);
	return doctorservice.totalprice(id, initdate, finishdate);
	}
	


}
