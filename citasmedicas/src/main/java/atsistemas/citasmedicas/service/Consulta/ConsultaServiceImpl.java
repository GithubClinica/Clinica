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
		/*
		 * // Mismo mapeo que en citas final Doctor doctor = consulta.getDoctor(); //
		 * final Integer iddoctor = doctor.getId(); c.setDoctor(doctor.getId());
		 * consulta.getDoctor().getId()
		 */
		
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

		// Mismo mapeo que en Citas
		// final Integer idDoctor = dto.getDoctor();
		// final DoctorDTO dDTO = doctorService.findById(idDoctor);
		// c.setDoctor(doctorService.transform(dDTO));

		// Prueba mapeo en una línea
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
		
// para que te consiga pasar la id al actualizar por la URL y no por JSon
		final Consulta act = transform(consultaDTO);
		final Consulta old = consultaDao.findById(idConsulta);
		modify(old, act);
		consultaDao.save(old);

/*
// De toda la vida
		final Consulta consulta = transform(consultaDTO);
		consultaDao.save(consulta);
*/		
		/*
		 * final Consulta c = consultaDao.findOne(idConsulta); final Consulta c =
		 * transform(consultaDTO); // final Consulta consulta = transform(consultaDTO);
		 * // modDoctor(origin, c); consultaDao.findOne(idConsulta) final Consulta c =
		 * transform(consultaDao.findOne(idConsulta));
		 * 
		 * final Consulta c2 = consultaDao.findById(idConsulta); final Consulta c3 =
		 * transform (consultaDTO);
		 * 
		 * /* CitaDTO citaOld = citaService.findById(id); if (citaOld != null) {
		 * citaService.update(citaOld.copyFrom(consultaDTO)); }
		 */

	}
	
	@Override
	public void modify(Consulta old, Consulta act) {

//		old.setId(act.getId());
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
