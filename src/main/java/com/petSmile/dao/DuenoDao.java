package com.petSmile.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.petSmile.config.Conexion;
import com.petSmile.model.Dueno;
import com.petSmile.utils.Utils;

public class DuenoDao {

	public static List<Dueno> executeQueryWithResult(String query) {
		List<Dueno> lista = new ArrayList<>();
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
			System.out.println("Error in executeQueryWithResult Dueno" + e.getMessage());
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
		}
		return false;
	}

	public static Dueno toObject(ResultSet rs) {

		try {
			Dueno objeto = new Dueno();
			objeto.setRut(rs.getString(1));
			objeto.setNombre(rs.getString(2));
			objeto.setApellido(rs.getString(3));
			objeto.setDireccion(rs.getString(4));
			objeto.setCorreo(rs.getString(5));
			objeto.setTelefono(rs.getString(6));
			objeto.setNombreMascota(rs.getString(7));
			return objeto;
		} catch (SQLException e) {
			System.out.println("Error toObject Dueno. " + e.getMessage());
			Utils.Message = e.getMessage();
		}

		return null;
	}

	public static List<Dueno> list() {
		String query = "SELECT * FROM Dueno";
		return executeQueryWithResult(query);
	}

	public static Dueno search(String rut) {
		String query = "SELECT * FROM Dueno WHERE rut = '" + rut + "'";
		List<Dueno> lista = executeQueryWithResult(query);
		return lista.isEmpty() ? null : lista.get(0);
	}

	public static boolean add(Dueno objeto) {

		String query = "INSERT INTO Dueno (" + "rut, nombre, apellido, direccion, correo, telefono, nombreMascota" + ")"
				+ " VALUES (" + "'" + objeto.getRut() + "'," + "'" + objeto.getNombre() + "'," + "'"
				+ objeto.getApellido() + "'," + "'" + objeto.getDireccion() + "'," + "'" + objeto.getCorreo() + "',"
				+ "'" + objeto.getTelefono() + "'," + "'" + objeto.getNombreMascota() + "')";
		return executeQuery(query);
	}

	public static boolean delete(String rut) {
		String query = "DELETE FROM Dueno WHERE rut = '" + rut + "'";
		return executeQuery(query);
	}
}
