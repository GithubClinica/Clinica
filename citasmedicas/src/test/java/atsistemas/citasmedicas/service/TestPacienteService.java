package atsistemas.citasmedicas.service;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.runners.MockitoJUnitRunner;

import atsistemas.citasmedicas.dao.PacienteDao;
import atsistemas.citasmedicas.dto.PacienteDTO;
import atsistemas.citasmedicas.model.Paciente;
import atsistemas.citasmedicas.service.paciente.PacienteService;


@RunWith (MockitoJUnitRunner.class)
public class TestPacienteService {

	private static final Integer ID = 1;
	private static final String NAME = "test";
	private static final String EMAIL = "test@test.com";
	
	@InjectMocks
	private PacienteService pacienteService;
	
	@Mock
	private PacienteDao pacienteDao;
	
	@Mock
	private PacienteDTO	pacienteDTO;
	
	@Test
	public void transformToPacienteBaseExists() {
		Mockito.when(pacienteDao.exists(ID)).thenReturn(Boolean.TRUE);
//		final Paciente paciente = pacientewithMockitoId();
		final Paciente p = new Paciente();
		p.setId(ID);
		Mockito.when(pacienteDao.findById(ID)).thenReturn(p);		
		
		final Paciente paciente = pacienteService.transform(pacienteDTO);
		Assert.assertEquals(paciente.getId(), ID);
		Assert.assertEquals(paciente.getName(), pacienteDTO.getName());
		Assert.assertEquals(paciente.getEmail(),pacienteDTO.getEmail());		
	}
	
	@Test
	public void transformToPacienteBaseNOExists() {
		Mockito.when(pacienteDao.exists(ID)).thenReturn(Boolean.TRUE);
//		final Paciente paciente = pacientewithMockitoId();
		final Paciente p = new Paciente();
		p.setId(ID);
		Mockito.when(pacienteDao.findById(ID)).thenReturn(p);		
		
		final Paciente paciente2 = pacienteService.transform(pacienteDTO);
		Assert.assertEquals(paciente2.getId(), ID);
		Assert.assertEquals(paciente2.getName(), pacienteDTO.getName());
		Assert.assertEquals(paciente2.getEmail(),pacienteDTO.getEmail());		
	}
	
	
}
