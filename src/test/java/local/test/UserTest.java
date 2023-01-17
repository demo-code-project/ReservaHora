package local.test;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import com.petSmile.dao.UsuarioDao;

public class UserTest {

	@Before
	public void setUp() throws Exception {
	}

	@Test
	public void testCredencialesCorrectas() {
		String username = "admin";
		String password = "admin";

		assertNotNull(UsuarioDao.login(username, password));
	}

	@Test
	public void testCredencialesIncorrectas() {
		String username = "admin";
		String password = "random";

		assertNull(UsuarioDao.login(username, password));
	}
}
