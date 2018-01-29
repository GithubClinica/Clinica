package atsistemas.citasmedicas.service.Sala;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import atsistemas.citasmedicas.dao.SalaDao;
import atsistemas.citasmedicas.dto.SalaDTO;
import atsistemas.citasmedicas.model.Sala;
import atsistemas.citasmedicas.service.Clinica.ClinicaService;


@Service
public class SalaServiceImpl implements SalaService{

	@Autowired
	private SalaDao salaDao;
	
	@Autowired
	private ClinicaService clinicaService;

	@Override
	public List<SalaDTO> findAll(Integer page, Integer size) {
		final Iterable<Sala> findAll = salaDao.findAll(new PageRequest(page, size)).getContent();
		final List<SalaDTO> res = new ArrayList<>();
		findAll.forEach(cit -> {
			final SalaDTO citDTO = transform(cit);
			res.add(citDTO);
		});
		return res;
	}
	
	@Override
	public SalaDTO transform(Sala sala) {
		final SalaDTO s = new SalaDTO();
		s.setId(sala.getId());
		s.setName(sala.getName());
		s.setClinica(sala.getClinica().getId());
		
		return s;
	} 

	@Override
	public Sala transform(SalaDTO dto) {
		final Sala s;
		if (dto.getId() != null && salaDao.exists(dto.getId())) {
			s = salaDao.findOne(dto.getId());
		} else {
			s = new Sala();
		}
//		u.setId(dto.getId()); el id no se pone para proteger el control
		s.setName(dto.getName());
		s.setClinica(clinicaService.transform(clinicaService.findById(dto.getClinica())));
		return s;
	}
	
	@Override
	public SalaDTO findById(Integer id) {
		final Sala sala = salaDao.findOne(id);
		return transform(sala);
//		return Optional.ofNullable(findOne).orElseThrow(NotFoundException)
	}

	@Override
	public SalaDTO create(SalaDTO salaDTO) {
		final Sala sala = transform(salaDTO);
		return transform(salaDao.save(sala));
	}
	

	@Override
	public void update(SalaDTO salaDTO, Integer idSala) {
		final Sala act = transform(salaDTO);
		final Sala old = salaDao.findById(idSala);
		modify(old, act);
		salaDao.save(old);
	}
	
	@Override
	public void modify(Sala old, Sala act) {
		old.setName(act.getName());
		old.setClinica(act.getClinica());
	}

	@Override
	public void delete(Integer id) {
		salaDao.delete(id);
	}
	
}
