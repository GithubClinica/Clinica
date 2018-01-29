package atsistemas.citasmedicas.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import atsistemas.citasmedicas.dto.DoctorDTO;
import atsistemas.citasmedicas.service.doctor.DoctorService;

@RestController
@RequestMapping(value = "doctor.dbgjerez.es:8080/api/doctor")
public class DoctorControllerDavid {
	
		@Autowired
		private DoctorService doctorservice;
		
		/*
		@Autowired
		private RestTemplate restTemplate;
		
//		private RestTemplate restTemplate = new RestTemplate();
		
		@RequestMapping("/")
		public String index() {
			
			//final ExampleDTO forObject = restTemplate.getForObject("http://elpuertoqueestelevantado, responsetype)
		
				restTemplate.getForObject(url, responseType)
				restTemplate.postForObject(url, request, responseType)
				restTemplate.put(url, request);
				restTemplate.delete(url);
				
				return ok;
			
		}
		
		
/*
		@RequestMapping(method =  RequestMethod.GET)
		public List<DoctorDTO> findAll(@RequestParam(required = false, defaultValue="0") Integer page,
				@RequestParam(required = false, defaultValue="10") Integer size) {
			return doctorservice.findAll(page, size);
		}
*/
/*
		@RequestMapping(method =  RequestMethod.GET)
		public List<DoctorDTO> findAll(@RequestParam(required = false, defaultValue="0") Integer page,
				@RequestParam(required = false, defaultValue="10") Integer size) {
			return doctorservice.findAll(page, size);
		}
		
		@RequestMapping(method = RequestMethod.GET, value = "/{id}")
		public DoctorDTO findById(@PathVariable String id) {
			return doctorservice.findById(id);
		}
*/
/*
		@RequestMapping(method = RequestMethod.POST)
		public DoctorDTO create(@RequestBody DoctorDTO doctor) {
			return doctorservice.create(doctor);
		}

		@RequestMapping(method = RequestMethod.PUT, value = "/{id}")
		public void update(@PathVariable Integer id, @RequestBody DoctorDTO doctor) {
			doctorservice.update(doctor);
		}

		@RequestMapping(method = RequestMethod.DELETE, value = "/{id}")
		public void delete(@PathVariable Integer id) {
			doctorservice.delete(id);
		}
*/		
}

