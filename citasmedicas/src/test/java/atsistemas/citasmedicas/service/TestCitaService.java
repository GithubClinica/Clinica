package atsistemas.citasmedicas.service;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.runners.MockitoJUnitRunner;

import atsistemas.citasmedicas.dao.CitaDao;
import atsistemas.citasmedicas.exceptions.NotFoundException;
import atsistemas.citasmedicas.model.Cita;
import atsistemas.citasmedicas.service.cita.CitaService;
import atsistemas.citasmedicas.service.cita.CitaServiceImpl;


@RunWith(MockitoJUnitRunner.class)
public class TestCitaService {
	
	private static final Integer ID = 1;

	
	private CitaService service = new CitaServiceImpl();
	
	@Mock
	private CitaDao dao;
	

	@Test
	public void testFindByIdBase() throws NotFoundException {
		final Cita cita = new Cita ();
		cita.setId(ID);
		Mockito.when(dao.findById(8)).thenReturn(cita);
				
	}
	
	@Test(expected = NotFoundException.class) //expecte --> se que va a fallar espero esta excepción
	public void testFindByIdNotFound() throws NotFoundException{
		service.findById(999);	
	}

}
