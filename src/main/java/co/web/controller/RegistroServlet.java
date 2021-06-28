package co.web.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import co.web.dao.RolDao;
import co.web.dao.UsuarioDao;
import co.web.modelo.Rol;
import co.web.modelo.Usuario;

/**
 * Servlet implementation class RegistroServlet
 */
@WebServlet("/registro")
public class RegistroServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    private RolDao rolDao;   
    private UsuarioDao usuarioDao;
    /**
     * @see HttpServlet#HttpServlet()
     */
    public RegistroServlet() {
        super();
        rolDao = new RolDao();
        usuarioDao = new UsuarioDao();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		List<Rol> roles = rolDao.list();
		request.setAttribute("roles", roles);
		RequestDispatcher dispatcher = request.getRequestDispatcher("registrarUsuario.jsp");
		dispatcher.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String usuario = request.getParameter("usuario");
		String email = request.getParameter("email");
		String pass = request.getParameter("pass");
		Rol r = rolDao.find(Integer.parseInt(request.getParameter("rol")));
		Usuario u = new Usuario(email, pass, (short) 1, usuario, r);
		usuarioDao.insert(u);
		response.sendRedirect("/final-web/administrador");
	}

}
