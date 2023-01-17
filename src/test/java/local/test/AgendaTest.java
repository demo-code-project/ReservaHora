package local.test;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.Before;
import org.junit.Test;

import com.petSmile.dao.AgendaDao;
import com.petSmile.dao.MascotaDao;
import com.petSmile.model.Agenda;
import com.petSmile.model.Mascota;
import com.petSmile.utils.Utils;

public class AgendaTest {

	@Before
	public void setUp() throws Exception {
	}

	@Test
	public void testRegistroAgendaCorrecto() {
		try {
			List<Mascota> mascotas = MascotaDao.list();
			if (!mascotas.isEmpty()) {
				Agenda agenda = new Agenda();
				agenda.setMascota(mascotas.get(0));
				agenda.setFecha(Utils.sdf.parse("2023-01-16 08:00:00"));
				agenda.setHora(Utils.sdf.parse("2023-01-16 08:00:00"));

				assertEquals(AgendaDao.add(agenda), true);
			}
		} catch (Exception e) {
			assertEquals("", "Excepción producida");
		}
	}
}
