package co.web.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import co.web.modelo.Usuario;

/**
 * Servlet implementation class AdministradorServlet
 */
@WebServlet("/administrador")
public class AdministradorServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AdministradorServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Usuario u = (Usuario) request.getSession().getAttribute("usuario");
		if (u != null && u.getRol().getId() == 1) {
			RequestDispatcher dispatcher = request.getRequestDispatcher("homeAdministrador.jsp");
			dispatcher.forward(request, response);
		} else {
			RequestDispatcher dispatcher = request.getRequestDispatcher("inicioSesion.jsp");
			dispatcher.forward(request, response);
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
