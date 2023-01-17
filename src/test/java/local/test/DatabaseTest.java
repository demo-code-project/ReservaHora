package local.test;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import com.petSmile.config.Conexion;

public class DatabaseTest {

	@Before
	public void setUp() throws Exception {
	}

	@Test
	public void testConexionBaseDatos() {
		assertNotNull(Conexion.getConnection());
	}

}
