package co.web.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import co.web.dao.UsuarioDao;
import co.web.modelo.Usuario;

/**
 * Servlet implementation class LoginController
 */
@WebServlet("/")
public class LoginController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private UsuarioDao usuarioDao;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LoginController() {
        super();
        usuarioDao = new UsuarioDao();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		RequestDispatcher dispatcher = request.getRequestDispatcher("inicioSesion.jsp");
		dispatcher.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String usuario = request.getParameter("usuario");
		String email = request.getParameter("email");
		String pass = request.getParameter("pass");
		Usuario u = usuarioDao.findByField("email", email);
		if (u.getPass().equals(pass) && u.getUsuario().equals(usuario)) {
			request.getSession().setAttribute("usuario", u);
			if (u.getRol().getId() == 1) {
				response.sendRedirect("/final-web/administrador");  
			} else {
				response.sendRedirect("/final-web/administrador");  
			}
		} else {
			
		}
	}

}
