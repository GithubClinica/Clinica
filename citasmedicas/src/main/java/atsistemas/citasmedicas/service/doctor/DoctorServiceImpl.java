package atsistemas.citasmedicas.service.doctor;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.dozer.DozerBeanMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import atsistemas.citasmedicas.dao.DoctorDao;
import atsistemas.citasmedicas.dto.ConsultaDTO;
import atsistemas.citasmedicas.dto.DoctorDTO;
import atsistemas.citasmedicas.model.Doctor;
import atsistemas.citasmedicas.service.Consulta.ConsultaService;
import atsistemas.citasmedicas.service.ServiceBase.ServiceBaseImpl;

@Service
public class DoctorServiceImpl extends ServiceBaseImpl implements DoctorService {

	@Autowired
	private DoctorDao doctorDao;

	@Autowired
	private DozerBeanMapper dozer;

	@Autowired
	private RestTemplate restTemplate;
	
	@Autowired
	private ConsultaService	consultaService;

	@Override
	public List<DoctorDTO> findAll(Integer page, Integer size) {
		final Iterable<Doctor> findAll = doctorDao.findAll(new PageRequest(page, size)).getContent();
		final List<DoctorDTO> res = new ArrayList<>();
		findAll.forEach(doc -> {
			final DoctorDTO docDTO = transform(doc);
			res.add(docDTO);
		});
		return res;
	}
	
	@Override
	public DoctorDTO transform(Doctor doctor) {
		return dozer.map(doctor, DoctorDTO.class);
	}

	@Override
	public Doctor transform(DoctorDTO doctor) {
		return dozer.map(doctor, Doctor.class);
	}

	@Override
	public DoctorDTO findById(String id) {
		final Doctor doc = doctorDao.findById(id);
		return transform(doc);
	}

	@Override
	public DoctorDTO create(DoctorDTO doctorDTO) {
		final Doctor doctor = transform(doctorDTO);
		return transform(doctorDao.save(doctor));
	}

	@Override
	public void update(DoctorDTO doctorDTO, String idDoctor) {
		final Doctor act = transform(doctorDTO);
		final Doctor old = doctorDao.findById(idDoctor);
		modify(old, act);
		doctorDao.save(old);
	}

	@Override
	public void modify(Doctor old, Doctor act) {
		old.setName(act.getName());
//		old.setEmail(act.getEmail());
		old.setPrice(act.getPrice());
	}

	@Override
	public void delete(String id) {
		doctorDao.delete(id);
	}
/*	
// Esta funcion lo que debe hacer es encontrar las consultas de un medico que se pasa por ID
	public List<ConsultaDTO> findConsultations(String id){
		List <ConsultaDTO> consultations = new ArrayList<>();
//	  obtener el las consultas
		findById(id).getConsultas().forEach(c -> {
			consultations.add(consultaService.transform(c));
		});
		return consultations;	
	}
*/
	@Override
	public List<Doctor> findByCriteria(DoctorDTO DoctorQueryParams) {
		// id
		String id = buildQueryTextParam(DoctorQueryParams.getId());
		// Name
		String name = buildQueryTextParam(DoctorQueryParams.getName());

		return doctorDao.findByCriteria(name, id);		
	}
	

	@Override
	public void InsertApidoctor(DoctorDTO[] template) {
	
		int j = 0;
		List<String> ids = new ArrayList<>();
		DoctorDTO[] res;
		DoctorDTO doctor = new DoctorDTO();
		
		do {
			res = restTemplate.getForObject("http://doctor.dbgjerez.es:8080/api/doctor/?page="+j, DoctorDTO[].class);
			j++;
			for (int i = 0; i<res.length;i++)
				ids.add(res[i].getId());
			} while (res.length!=0);
		
		for (int z = 0; z<ids.size();z++) {
			doctor = restTemplate.getForObject("http://doctor.dbgjerez.es:8080/api/doctor/"+ids.get(z), DoctorDTO.class);
			create(doctor);
		}
	
}
/*	
	@Override
	public List<Doctor> consulbetweendate(DoctorDTO doctorQueryParams) {
		String name = buildQueryTextParam(doctorQueryParams.getName());
		Date initdate = doctorQueryParams;
		Date finishdate = doctorQueryParams;
		List<Doctor> doctors = doctorDao.consulbetweendate(name, initdate, finishdate);
		return doctors;
	}
*/
	@Override
	public float totalprice(String id, Date initdate, Date finishdate) {
		final Integer Numcons = doctorDao.consulbetweendate(id, initdate, finishdate);
		final Doctor doctor = doctorDao.findOne(id);
		float price = doctor.getPrice();
		float totalprice = price * Numcons;
		return totalprice;			
		}

	@Override
	public Page<Doctor> topdoctors(){
		return doctorDao.topdoctors(new PageRequest(0, 5));
	}

//=====================================================================================	
/*
	@Override
	public List<Doctor> findTopNByDoctorstars(Integer num) {
		return doctorDao.findTopNByDoctorstars(num);
//====================================================================================
*/
}


	