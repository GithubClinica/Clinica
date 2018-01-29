package atsistemas.citasmedicas.service.cita;

import java.util.ArrayList;
import java.util.List;

import org.dozer.DozerBeanMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import atsistemas.citasmedicas.dao.CitaDao;
import atsistemas.citasmedicas.dao.ConsultaDao;
import atsistemas.citasmedicas.dao.PacienteDao;
import atsistemas.citasmedicas.dto.CitaDTO;
import atsistemas.citasmedicas.model.Cita;
import atsistemas.citasmedicas.model.Consulta;
import atsistemas.citasmedicas.model.Paciente;
import atsistemas.citasmedicas.service.Consulta.ConsultaService;
import atsistemas.citasmedicas.service.paciente.PacienteService;

@Service
public class CitaServiceImpl implements CitaService{
	
	@Autowired
	private CitaDao citaDao;
	
	@Autowired
	private PacienteDao pacienteDao;
	
	@Autowired
	private ConsultaDao consultaDao;
	
	@Autowired
	private PacienteService pacienteService;
	
	@Autowired
	private ConsultaService	consultaService;

	@Autowired
	private DozerBeanMapper dozer;

	@Override
	public List<CitaDTO> findAll(Integer page, Integer size) {
		final Iterable<Cita> findAll = citaDao.findAll(new PageRequest(page, size)).getContent();
		final List<CitaDTO> res = new ArrayList<>();
		findAll.forEach(cit -> {
			final CitaDTO citDTO = transform(cit);
			res.add(citDTO);
		});
		return res;
	}
	
/*
	@Override
	public CitaDTO transform(Cita cita) {
		return dozer.map(cita, CitaDTO.class);
	}
*/
	@Override
	public CitaDTO transform(Cita cita) {
		//otro mapeo 2 lineas con paciente y consulta
		Paciente p = cita.getPaciente();
		Consulta con = cita.getConsulta();
		final CitaDTO c = new CitaDTO();
		// otro mapeo  dos lineas paciente y consulta
		Paciente paciente = pacienteDao.findById(p.getId());
		Consulta consulta = consultaDao.findById(con.getId());
		c.setId(cita.getId());
		c.setOrden(cita.getOrden());
		c.setDiacita(cita.getDiacita());
		// otro mapeo 2 lineas
		c.setConsulta(consulta.getId());
		c.setPaciente(paciente.getId());
/*
		//Reducido el de antes a una línea
		c.setPaciente(cita.getPaciente().getId());
		c.setConsulta(cita.getConsulta().getId());
*/		
		return c;
	} 

/*
	@Override
	public Cita transform(CitaDTO cita) {
		return dozer.map(cita, Cita.class);
	}
*/

	@Override
	public Cita transform(CitaDTO dto) {
		final Cita c;
		Consulta consulta =(consultaService.transform(consultaService.findById(dto.getConsulta())));
		Paciente paciente = (pacienteService.transform(pacienteService.findById(dto.getPaciente())));
		if (dto.getId() != null && citaDao.exists(dto.getId())) {
			c = citaDao.findOne(dto.getId());
		} else {
			c = new Cita();
		}
//		u.setId(dto.getId()); el id no se pone para proteger el control
		c.setOrden(dto.getOrden());
		c.setDiacita(dto.getDiacita());
		c.setPaciente(paciente);
		c.setConsulta(consulta);

/*
		//Mismo que arriba pero reducido
		c.setPaciente(pacienteService.transform(pacienteService.findById(dto.getPaciente())));
		c.setConsulta(consultaService.transform(consultaService.findById(dto.getConsulta())));
*/
		
		return c;
	}
	
	@Override
	public CitaDTO findById(Integer id) {
		final Cita doc = citaDao.findOne(id);
		return transform(doc);	
//		return Optional.ofNullable(findOne).orElseThrow(NotFoundException)
	}

	@Override
	public CitaDTO create(CitaDTO citaDTO) {
		final Cita cita = transform(citaDTO);
		return transform(citaDao.save(cita));
	}


	@Override
	public void update(CitaDTO citaDTO, Integer idCita) {
		final Cita act = transform(citaDTO);
		final Cita old = citaDao.findById(idCita);
		modify(old, act);
		citaDao.save(old);
	}
	
	@Override
	public void modify(Cita old, Cita act) {
		old.setOrden(act.getOrden());
		old.setDiacita(act.getDiacita());
		old.setPaciente(act.getPaciente());
		old.setConsulta(act.getConsulta());
	}
	
	@Override
	public void delete(Integer id) {
		citaDao.delete(id);
	}

}
	
