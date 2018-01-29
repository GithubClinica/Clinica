package atsistemas.citasmedicas.service.paciente;

import java.util.ArrayList;
import java.util.List;

import org.dozer.DozerBeanMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import atsistemas.citasmedicas.dao.PacienteDao;
import atsistemas.citasmedicas.dto.CitaDTO;
import atsistemas.citasmedicas.dto.PacienteDTO;
import atsistemas.citasmedicas.model.Paciente;
import atsistemas.citasmedicas.service.cita.CitaService;

@Service
public class PacienteServiceImpl implements PacienteService {
	
	@Autowired
	private PacienteDao pacienteDao;
	
	@Autowired
	private CitaService citaService;
	
	@Autowired
	private DozerBeanMapper dozer;

	
/*	@Override
	public PacienteDTO transform(Paciente paciente) {
		return dozer.map(paciente, PacienteDTO.class);
	} */
	
	@Override
	public PacienteDTO transform(Paciente paciente) {
		final PacienteDTO p = new PacienteDTO();
		p.setId(paciente.getId());
		p.setName(paciente.getName());
		p.setEmail(paciente.getEmail());
		return p;
	} 
	
/*	@Override
	public Paciente transform(PacienteDTO paciente) {
		return dozer.map(paciente, Paciente.class);
	}*/
	
	@Override
	public Paciente transform(PacienteDTO dto) {
		final Paciente p;
		if (dto.getId() != null && pacienteDao.exists(dto.getId())) {
			p = pacienteDao.findOne(dto.getId());
		} else {
			p = new Paciente();
		}
//		u.setId(dto.getId()); el id no se pone para proteger el control
		p.setName(dto.getName());
		p.setEmail(dto.getEmail());
		return p;
	}
	
	@Override
	public List<PacienteDTO> findAll(Integer page, Integer size) {
		final Iterable<Paciente> findAll = pacienteDao.findAll(new PageRequest(page, size)).getContent();
		final List<PacienteDTO> res = new ArrayList<>();
		findAll.forEach(pac -> {
			final PacienteDTO pacDTO = transform(pac);
			res.add(pacDTO);
		});
		return res;
	}

/*	
	@Override
	public PacienteDTO findPacienteDTOById(Integer id) {
		return transform(findPacienteById(id));
	}

	@Override
	public Paciente findPacienteById(Integer id) {
		final Paciente paciente = pacienteDao.findOne(id);
		if (paciente != null ) { //&& user.getDeleted() == null
			return paciente;
		}
		//throw new UserNotFoundException();
	}
	*/
	
	@Override
	public PacienteDTO findById(Integer id) {
		final Paciente doc = pacienteDao.findOne(id);
		return transform(doc);
	}

	@Override
	public PacienteDTO create(PacienteDTO pacienteDTO) {
		final Paciente paciente = transform(pacienteDTO);
		return transform(pacienteDao.save(paciente));
	}

	@Override
	public void update(PacienteDTO pacienteDTO, Integer idPaciente) {
		final Paciente act = transform(pacienteDTO);
		final Paciente old = pacienteDao.findById(idPaciente);
		modify(old, act);
		pacienteDao.save(old);
	}
	
	@Override
	public void modify(Paciente old, Paciente act) {
		old.setName(act.getName());
		old.setEmail(act.getEmail());
	}
	

	@Override
	public void delete(Integer id) {
		pacienteDao.delete(id);
	}
	
	public List<CitaDTO> findCitas(Integer id){
		List <CitaDTO> citas = new ArrayList<>();
		findById(id).getCitas().forEach(c -> {
			citas.add(citaService.transform(c));
		});
		return citas;
		
	}
}
