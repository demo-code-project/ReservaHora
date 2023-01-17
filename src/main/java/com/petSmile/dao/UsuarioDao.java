package com.petSmile.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.petSmile.config.Conexion;
import com.petSmile.model.Usuario;
import com.petSmile.utils.Utils;

public class UsuarioDao {

	public static List<Usuario> executeQueryWithResult(String query) {
		List<Usuario> lista = new ArrayList<>();
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
			System.out.println("Error in executeQueryWithResult Usuario" + e.getMessage());
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

	public static Usuario toObject(ResultSet rs) {

		try {
			Usuario objeto = new Usuario();
			objeto.setId(rs.getInt(1));
			objeto.setNombreUsuario(rs.getString(2));
			objeto.setPassword(rs.getString(3));
			return objeto;
		} catch (SQLException e) {
			System.out.println("Error toObject Usuario. " + e.getMessage());
		}

		return null;
	}

	public static Usuario search(String nombreUsuario) {
		String query = "SELECT * FROM Usuario WHERE nombreUsuario = '" + nombreUsuario + "'";
		List<Usuario> lista = executeQueryWithResult(query);
		return lista.isEmpty() ? null : lista.get(0);
	}

	public static boolean add(Usuario objeto) {

		String query = "INSERT INTO Usuario (" + "nombreUsuario, password" + ") VALUES (" + "'"
				+ objeto.getNombreUsuario() + "'," + "'" + objeto.getPassword() + "')";
		return executeQuery(query);
	}

	public static Usuario login(String nombreUsuario, String password) {
		Usuario usuario = search(nombreUsuario);
		if (usuario != null) {
			return usuario.getPassword().equals(password) ? usuario : null;
		}
		return null;
	}
}
