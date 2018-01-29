package atsistemas.citasmedicas.service;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.runners.MockitoJUnitRunner;

import atsistemas.citasmedicas.dao.DoctorDao;
import atsistemas.citasmedicas.dto.DoctorDTO;
import atsistemas.citasmedicas.model.Doctor;
import atsistemas.citasmedicas.service.doctor.DoctorService;
import atsistemas.citasmedicas.service.doctor.DoctorServiceImpl;

@RunWith (MockitoJUnitRunner.class)
public class TestDoctorService {
	
//	todo lo que se pase por parametros se debe poner como static final
	private static final String ID = "dsfdsfs";
	private static final String NAME = "test";
	private static final String EMAIL = "test@test.com";
	
	@InjectMocks
	private DoctorService doctorService = new DoctorServiceImpl();
	
	@Mock
	private DoctorDao doctorDao;
	
    @Mock
    private DoctorDTO doctorDTO;
	
	//Para probar el transform
	
	@Test
	public void transformToDoctorBaseExists() {
/* lo tengo que comentar porque el metodo exists solo recibe como parametro un
 * entero y es string
 */
/*
		Mockito.when(doctorDao.exists(ID)).thenReturn(Boolean.TRUE);
//		final Doctor doctor = doctorwithMockitoId();
		final Doctor doctor = new Doctor();
		doctor.setId(ID);;
		Mockito.when(doctorDao.findById(ID)).thenReturn(doctor);		
*/		
		
		
	}
/*	
	private Doctor doctorwithMockitoId() {
		final Doctor doctor = new Doctor();
		doctor.setId(ID);
		doctor.setName(NAME);
		doctor.setEmail(EMAIL);
		Mockito.when(doctorDao.findById(ID)).thenReturn(doctor);		
	}
*/
		
}
