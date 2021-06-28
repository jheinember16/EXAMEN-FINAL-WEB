package co.web.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import co.web.dao.TypedbDao;
import co.web.modelo.Rol;
import co.web.modelo.Typedb;
import co.web.modelo.Usuario;

/**
 * Servlet implementation class BasesController
 */
@WebServlet("/bases")
public class BasesController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private TypedbDao tdbDao;
    /**
     * @see HttpServlet#HttpServlet()
     */
    public BasesController() {
        super();
        tdbDao = new TypedbDao();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		RequestDispatcher dispatcher = request.getRequestDispatcher("registrarBase.jsp");
		dispatcher.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String id = request.getParameter("id");
		String descripcion = request.getParameter("descripcion");
		String driver = request.getParameter("drive");
		String adicional = request.getParameter("adicional");
		Typedb tdb = new Typedb(id, adicional, descripcion, driver);
		tdbDao.insert(tdb);
		response.sendRedirect("/final-web/administrador");
	}

}
