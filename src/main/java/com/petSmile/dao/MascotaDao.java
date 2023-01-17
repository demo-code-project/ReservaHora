package com.petSmile.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.petSmile.config.Conexion;
import com.petSmile.model.Mascota;
import com.petSmile.utils.Utils;

public class MascotaDao {

	public static List<Mascota> executeQueryWithResult(String query) {
		List<Mascota> lista = new ArrayList<>();
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
			System.out.println("Error in executeQueryWithResult Mascota" + e.getMessage());
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

	public static Mascota toObject(ResultSet rs) {

		try {
			Mascota objeto = new Mascota();
			objeto.setIdMascota(rs.getInt(1));
			objeto.setDueno(DuenoDao.search(rs.getString(2)));
			objeto.setTipoMascota(rs.getString(3));
			objeto.setEdad(rs.getInt(4));
			objeto.setNombreMascota(rs.getString(5));
			return objeto;
		} catch (SQLException e) {
			System.out.println("Error toObject Mascota. " + e.getMessage());
		}

		return null;
	}

	public static List<Mascota> list() {
		String query = "SELECT * FROM Mascota";
		return executeQueryWithResult(query);
	}

	public static Mascota search(int id) {
		String query = "SELECT * FROM Mascota WHERE idMascota = " + id;
		List<Mascota> lista = executeQueryWithResult(query);
		return lista.isEmpty() ? null : lista.get(0);
	}

	public static boolean add(Mascota objeto) {

		String query = "INSERT INTO Mascota (" + "rutDueno, tipoMascota, edad, nombreMascota" + ")" + " VALUES (" + "'"
				+ objeto.getDueno().getRut() + "'," + "'" + objeto.getTipoMascota() + "'," + +objeto.getEdad() + ","
				+ "'" + objeto.getNombreMascota() + "')";
		return executeQuery(query);
	}

	public static boolean delete(int id) {
		String query = "DELETE FROM Mascota WHERE idMascota = " + id;
		return executeQuery(query);
	}
}
