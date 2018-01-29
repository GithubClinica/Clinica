package atsistemas.citasmedicas.service;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.runners.MockitoJUnitRunner;

//@RunWith (MockitoJUnitRunner.class)
public class TestUserService {
/*	
//	todo lo que se pase por parametros se debe poner como static final
	private static final integer ID = 1;
	//Por cada Autowired se necesitará un mock
	
	@InjectMocks
	private UserService userservice = new UserServiceImpl();
	
	@Mock
	private Userdao userdao;
	
//	probamos el map
//	existen dos caso bases que exista el id del usuario o que no exista

	@Test
	public void mapToUserBaseExists() {
		Mockito.when(dao.exists(ID)).thenReturn(Boolean.TRUE);
//		final User user = new User();
//		user.setId(ID);
//		Mockito.when(dao.findOne(ID)).thenReturn(user);

		final User user = userMockWithId();

		// una funciona aparte de la misma forma que el userMockWithId
		final UserDTO dto = userDTOMockWithIdAndName();
		
		final User u = userService.map(dto);
		Assert.assertEquals(u.getId(), ID);
		Assert.assertEquals(u.getName(), dto.getName());
	}
	
	private User userwithMockitoId() {
		final User user = new User();
		user.setId(ID);
		Mockito.when(dao.findOne(ID)).thenReturn(user);
	}

	@Test
	public void mapToUserBaseNoExists() {
		
		
	}

	*/
}
