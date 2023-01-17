package com.petSmile.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.petSmile.config.Conexion;
import com.petSmile.model.Agenda;
import com.petSmile.utils.Utils;

public class AgendaDao {

	public static List<Agenda> executeQueryWithResult(String query) {
		List<Agenda> lista = new ArrayList<>();
		Connection connection;
		PreparedStatement ps;
		try {
			connection = Conexion.getConnection();
			ps = connection.prepareStatement(query);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				lista.add(toObject(rs));
			}
			ps.close();
			connection.close();
		} catch (SQLException e) {
			System.out.println("Error in executeQueryWithResult Agenda" + e.getMessage());
			Utils.Message = e.getMessage();
		}
		return lista;
	}

	public static boolean executeQuery(String query) {
		Connection connection;
		PreparedStatement ps;
		try {
			connection = Conexion.getConnection();
			ps = connection.prepareStatement(query);
			ps.executeUpdate();
			ps.close();
			connection.close();
			return true;
		} catch (SQLException e) {
			System.out.println("Error in executeQuery: " + e.getMessage());
			Utils.Message = e.getMessage();
		}
		return false;
	}

	public static Agenda toObject(ResultSet rs) {

		try {
			Agenda objeto = new Agenda();
			objeto.setId(rs.getInt(1));
			objeto.setMascota(MascotaDao.search(rs.getInt(2)));
			objeto.setDueno(DuenoDao.search(rs.getString(3)));
			objeto.setNombreMascota(rs.getString(4));
			objeto.setHora(Utils.sdf.parse(rs.getString(6)));
			objeto.setFecha(Utils.sdf.parse(rs.getString(6)));
			return objeto;
		} catch (Exception e) {
			System.out.println("Error toObject Agenda. " + e.getMessage());
		}

		return null;
	}

	public static List<Agenda> list() {
		String query = "SELECT * FROM Agenda";
		return executeQueryWithResult(query);
	}

	public static Agenda search(int id) {
		String query = "SELECT * FROM Agenda WHERE id = " + id;
		List<Agenda> lista = executeQueryWithResult(query);
		return lista.isEmpty() ? null : lista.get(0);
	}

	public static boolean add(Agenda objeto) {

		String query = "INSERT INTO Agenda (" + "idMascota, rutDueno, nombreMascota, hora, fecha" + ")" + " VALUES ("
				+ objeto.getMascota().getIdMascota() + "," + "'" + objeto.getMascota().getDueno().getRut() + "','"
				+ objeto.getMascota().getNombreMascota() + "'," + "'" + Utils.sdf.format(objeto.getHora()) + "','"
				+ Utils.sdf.format(objeto.getFecha()) + "')";
		return executeQuery(query);
	}

	public static boolean delete(int id) {
		String query = "DELETE FROM Agenda WHERE id = " + id;
		return executeQuery(query);
	}
}
