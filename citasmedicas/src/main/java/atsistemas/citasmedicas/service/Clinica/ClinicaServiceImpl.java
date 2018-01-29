package atsistemas.citasmedicas.service.Clinica;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import atsistemas.citasmedicas.dao.ClinicaDao;
import atsistemas.citasmedicas.dto.ClinicaDTO;
import atsistemas.citasmedicas.dto.SalaDTO;
import atsistemas.citasmedicas.model.Clinica;
import atsistemas.citasmedicas.service.Sala.SalaService;

@Service
public class ClinicaServiceImpl implements ClinicaService {
	

	@Autowired
	private ClinicaDao clinicaDao;
	
	@Autowired
	private SalaService salaService;


	@Override
	public List<ClinicaDTO> findAll(Integer page, Integer size) {
		final Iterable<Clinica> findAll = clinicaDao.findAll(new PageRequest(page, size)).getContent();
		final List<ClinicaDTO> res = new ArrayList<>();
		findAll.forEach(cit -> {
			final ClinicaDTO citDTO = transform(cit);
			res.add(citDTO);
		});
		return res;
	}
	
	@Override
	public ClinicaDTO transform(Clinica clinica) {
		final ClinicaDTO s = new ClinicaDTO();
		s.setId(clinica.getId());
		s.setName(clinica.getName());
		return s;
	} 

	@Override
	public Clinica transform(ClinicaDTO dto) {
		final Clinica s;
		if (dto.getId() != null && clinicaDao.exists(dto.getId())) {
			s = clinicaDao.findOne(dto.getId());
		} else {
			s = new Clinica();
		}
//		u.setId(dto.getId()); el id no se pone para proteger el control
		s.setName(dto.getName());
		return s;
	}
	
	@Override
	public ClinicaDTO findById(Integer id) {
		final Clinica clinica = clinicaDao.findOne(id);
		return transform(clinica);
//		return Optional.ofNullable(findOne).orElseThrow(NotFoundException)
	}

	@Override
	public ClinicaDTO create(ClinicaDTO clinicaDTO) {
		final Clinica clinica = transform(clinicaDTO);
		return transform(clinicaDao.save(clinica));
	}
	

	@Override
	public void update(ClinicaDTO clinicaDTO, Integer idClinica) {
		final Clinica act = transform(clinicaDTO);
		final Clinica old = clinicaDao.findById(idClinica);
		modify(old, act);
		clinicaDao.save(old);
	}
	
	@Override
	public void modify(Clinica old, Clinica act) {
		old.setName(act.getName());
	}

	@Override
	public void delete(Integer id) {
		clinicaDao.delete(id);
	}
	
	public List<SalaDTO> findSalas(Integer id){
		List <SalaDTO> salas = new ArrayList<>();
		findById(id).getSalas().forEach(s -> {
			salas.add(salaService.transform(s));
		});
		return salas;
		
	}

}
