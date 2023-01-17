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
import com.petSmile.dao.MascotaDao;
import com.petSmile.model.Mascota;
import com.petSmile.utils.Utils;

/**
 * Servlet implementation class MascotaController
 */
@WebServlet("/mascota")
public class MascotaController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	String login = "index.jsp";
	String list = "admin/mascota/list.jsp";
	String add = "admin/mascota/add.jsp";

	Mascota mascota;
	HttpSession session;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public MascotaController() {
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
					request.setAttribute("listMascotas", MascotaDao.list());
					acceso = list;
					break;
				case "delete":
					int idMascota = Integer.parseInt(request.getParameter("id"));
					if (MascotaDao.delete(idMascota)) {
						request.setAttribute("success", "Mascota eliminada");
					} else {
						request.setAttribute("error", Utils.Message);
					}

					request.setAttribute("listMascotas", MascotaDao.list());
					acceso = list;
					break;
				case "add":
					acceso = add;
					request.setAttribute("listDuenos", DuenoDao.list());
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
						mascota = new Mascota();
						mascota.setDueno(DuenoDao.search(request.getParameter("rutDueno")));
						mascota.setTipoMascota(request.getParameter("tipoMascota"));
						mascota.setEdad(Integer.parseInt(request.getParameter("edad")));
						mascota.setNombreMascota(request.getParameter("nombreMascota"));

						if (MascotaDao.add(mascota)) {
							request.setAttribute("success", "Mascota registrada");
						} else {
							request.setAttribute("error", Utils.Message);
						}
					} catch (Exception e) {
						request.setAttribute("error", e.getMessage());
					}

					request.setAttribute("listDuenos", DuenoDao.list());
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
