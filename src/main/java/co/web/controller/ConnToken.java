package co.web.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import co.web.dao.ConnectiontokenDao;
import co.web.dao.RolDao;
import co.web.dao.TypedbDao;
import co.web.modelo.Connectiontoken;
import co.web.modelo.Rol;
import co.web.modelo.Typedb;
import co.web.modelo.Usuario;

/**
 * Servlet implementation class ConnToken
 */
@WebServlet("/token")
public class ConnToken extends HttpServlet {
	private static final long serialVersionUID = 1L;
    private TypedbDao tdbDao;
    private ConnectiontokenDao ckDao;
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ConnToken() {
        super();
        tdbDao = new TypedbDao();
        ckDao = new ConnectiontokenDao();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		List<Typedb> tipos = tdbDao.list();
		request.setAttribute("tipos", tipos);
		RequestDispatcher dispatcher = request.getRequestDispatcher("token.jsp");
		dispatcher.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String host = request.getParameter("host");
		String userDB = request.getParameter("userDB");
		String pass = request.getParameter("pass");
		short puerto = Short.parseShort(request.getParameter("puerto"));
		String token = request.getParameter("token");
		Typedb type = tdbDao.find(Integer.parseInt(request.getParameter("type")));
		String db = request.getParameter("db");
		Connectiontoken ck = new Connectiontoken(db, host, pass, puerto, token, userDB, type);
		ckDao.insert(ck);
		response.sendRedirect("/final-web/administrador");
	}

}
