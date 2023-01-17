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

import com.petSmile.dao.MascotaDao;
import com.petSmile.dao.AgendaDao;
import com.petSmile.model.Agenda;
import com.petSmile.utils.Utils;

/**
 * Servlet implementation class AgendaController
 */
@WebServlet("/agenda")
public class AgendaController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	String login = "index.jsp";
	String list = "admin/agenda/list.jsp";
	String add = "admin/agenda/add.jsp";

	Agenda agenda;
	HttpSession session;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public AgendaController() {
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
					request.setAttribute("listAgendas", AgendaDao.list());
					acceso = list;
					break;
				case "delete":
					int idAgenda = Integer.parseInt(request.getParameter("id"));
					if (AgendaDao.delete(idAgenda)) {
						request.setAttribute("success", "Agenda eliminada");
					} else {
						request.setAttribute("error", Utils.Message);
					}

					request.setAttribute("listAgendas", AgendaDao.list());
					acceso = list;
					break;
				case "add":
					acceso = add;
					request.setAttribute("listMascotas", MascotaDao.list());
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
						agenda = new Agenda();
						agenda.setMascota(MascotaDao.search(Integer.parseInt(request.getParameter("idMascota"))));
						String fecha_hora = request.getParameter("fecha");
						if (fecha_hora != null) {
							fecha_hora = fecha_hora.replace('T', ' ');
						}
						agenda.setHora(Utils.sdf.parse(fecha_hora + ":00"));
						agenda.setFecha(agenda.getHora());

						if (AgendaDao.add(agenda)) {
							request.setAttribute("success", "Agenda registrada");
						} else {
							request.setAttribute("error", Utils.Message);
						}
					} catch (Exception e) {
						request.setAttribute("error", e.getMessage());
					}

					request.setAttribute("listMascotas", MascotaDao.list());
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
