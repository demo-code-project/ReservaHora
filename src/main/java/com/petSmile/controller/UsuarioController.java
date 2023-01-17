package com.petSmile.controller;

import java.io.IOException;
import java.util.Collections;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.petSmile.dao.UsuarioDao;
import com.petSmile.model.Usuario;

/**
 * Servlet implementation class UsuarioController
 */
@WebServlet("/usuario")
public class UsuarioController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	String login = "index.jsp";
	String home_admin = "admin/home-admin.jsp";

	Usuario usuario;
	HttpSession session;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public UsuarioController() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		String acceso = login;
		try {
			session = request.getSession();
			String action = request.getParameter("accion");
			switch (action) {
			case "login":
				acceso = login;
				break;
			case "logout":
				acceso = login;
				session.removeAttribute("user");
				break;
			case "home":
				acceso = home_admin;
				break;
			default:
				break;
			}
		} catch (Exception e) {
			request.setAttribute("error", e.getMessage());
		}

		RequestDispatcher vista = request.getRequestDispatcher(acceso);
		vista.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		String acceso = login;
		try {
			session = request.getSession();

			String action = request.getParameter("accion");

			if (action.equals("Login")) {
				try {
					String username = request.getParameter("username");
					String password = request.getParameter("password");

					usuario = UsuarioDao.login(username, password);
					if (usuario == null) {
						request.setAttribute("error", "Credenciales incorrectas");
					} else {
						session.setAttribute("user", usuario);
						request.setAttribute("user", usuario);
						acceso = home_admin;
					}
				} catch (Exception e) {
					request.setAttribute("error", e.getMessage());
				}
			}

		} catch (Exception e) {
			request.setAttribute("error", e.getMessage());
		}

		RequestDispatcher vista = request.getRequestDispatcher(acceso);
		vista.forward(request, response);
	}

	public boolean isLogged() {
		List<String> atributos = Collections.list(session.getAttributeNames());
		if (atributos.contains("user")) {
			return session.getAttribute("user") != null;
		}
		return false;
	}

}
