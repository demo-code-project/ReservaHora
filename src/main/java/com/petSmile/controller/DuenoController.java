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

import com.petSmile.dao.DuenoDao;
import com.petSmile.model.Dueno;
import com.petSmile.utils.Utils;

/**
 * Servlet implementation class DuenoController
 */
@WebServlet("/dueno")
public class DuenoController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	String login = "index.jsp";
	String list = "admin/dueno/list.jsp";
	String add = "admin/dueno/add.jsp";

	Dueno dueno;
	HttpSession session;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public DuenoController() {
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
			if (isLogged()) {
				String action = request.getParameter("accion");
				switch (action) {
				case "list":
					request.setAttribute("listDuenos", DuenoDao.list());
					acceso = list;
					break;
				case "delete":
					String rutDueno = request.getParameter("rut");
					if (DuenoDao.delete(rutDueno)) {
						request.setAttribute("success", "Dueño eliminado");
					} else {
						request.setAttribute("error", Utils.Message);
					}

					request.setAttribute("listDuenos", DuenoDao.list());
					acceso = list;
					break;
				case "add":
					acceso = add;
					break;
				default:
					break;
				}
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
			if (isLogged()) {
				String action = request.getParameter("accion");

				if (action.equals("Registrar")) {
					acceso = add;

					try {
						dueno = new Dueno();
						dueno.setRut(request.getParameter("rut"));
						dueno.setNombre(request.getParameter("nombre"));
						dueno.setApellido(request.getParameter("apellido"));
						dueno.setDireccion(request.getParameter("direccion"));
						dueno.setCorreo(request.getParameter("correo"));
						dueno.setTelefono(request.getParameter("telefono"));
						dueno.setNombreMascota(request.getParameter("nombreMascota"));

						if (DuenoDao.add(dueno)) {
							request.setAttribute("success", "Dueño registrado");
						} else {
							request.setAttribute("success", "Dueño registrado");
						}
					} catch (Exception e) {
						request.setAttribute("error", e.getMessage());
					}
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
