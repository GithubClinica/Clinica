package atsistemas.citasmedicas.service.Consulta;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import atsistemas.citasmedicas.dao.ConsultaDao;
import atsistemas.citasmedicas.dto.ConsultaDTO;
import atsistemas.citasmedicas.model.Consulta;
import atsistemas.citasmedicas.model.Doctor;
import atsistemas.citasmedicas.service.Sala.SalaService;
import atsistemas.citasmedicas.service.doctor.DoctorService;

@Service
public class ConsultaServiceImpl implements ConsultaService {

	@Autowired
	private ConsultaDao consultaDao;

	@Autowired
	private DoctorService doctorService;

	@Autowired
	private SalaService salaService;

	/*
	 * @Autowired private DozerBeanMapper dozer;
	 */
	/*
	 * @Override public ConsultaDTO transform(Consulta consulta) { return
	 * dozer.map(consulta, ConsultaDTO.class); }
	 */
	@Override
	public ConsultaDTO transform(Consulta consulta) {
		final ConsultaDTO c = new ConsultaDTO();
		c.setId(consulta.getId());
		c.setTurno(consulta.getTurno());
		c.setFechaConsulta(consulta.getFechaConsulta());
		c.setDoctor(consulta.getDoctor().getId());
		c.setSala(consulta.getSala().getId());

		return c;
	}

	/*
	 * @Override public Consulta transform(ConsultaDTO consulta) { return
	 * dozer.map(consulta, Consulta.class); }
	 */

	@Override
	public Consulta transform(ConsultaDTO dto) {
		final Consulta c;
		if (dto.getId() != null && consultaDao.exists(dto.getId())) {
			c = consultaDao.findOne(dto.getId());
		} else {
			c = new Consulta();
		}
		// u.setId(dto.getId()); el id no se pone para proteger el control
		c.setTurno(dto.getTurno());
		c.setFechaConsulta(dto.getFechaConsulta());
		c.setDoctor(doctorService.transform(doctorService.findById(dto.getDoctor())));
		c.setSala(salaService.transform(salaService.findById(dto.getSala())));

		return c;
	}

	@Override
	public List<ConsultaDTO> findAll(Integer page, Integer size) {
		final Iterable<Consulta> findAll = consultaDao.findAll(new PageRequest(page, size)).getContent();
		final List<ConsultaDTO> res = new ArrayList<>();
		findAll.forEach(doc -> {
			final ConsultaDTO docDTO = transform(doc);
			res.add(docDTO);
		});
		return res;
	}

	@Override
	public ConsultaDTO findById(Integer id) {
		final Consulta doc = consultaDao.findOne(id);
		return transform(doc);
	}

	@Override
	public ConsultaDTO create(ConsultaDTO consultaDTO) {
		final Consulta consulta = transform(consultaDTO);
		return transform(consultaDao.save(consulta));
	}

	@Override
	public void update(ConsultaDTO consultaDTO, Integer idConsulta) {
		
// Para conseguir pasar la id al actualizar por la URL y no por JSon
		final Consulta act = transform(consultaDTO);
		final Consulta old = consultaDao.findById(idConsulta);
		modify(old, act);
		consultaDao.save(old);
	}
	
	@Override
	public void modify(Consulta old, Consulta act) {

		old.setTurno(act.getTurno());
		old.setFechaConsulta(act.getFechaConsulta());
		old.setSala(act.getSala());
		old.setDoctor(act.getDoctor());
	}

	@Override
	public void delete(Integer id) {
		consultaDao.delete(id);
	}

}
