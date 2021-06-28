package co.web.dao;

import co.web.modelo.Connectiontoken;
import co.web.util.Conexion;

public class ConnectiontokenDao extends Conexion<Connectiontoken> implements GenericDao<Connectiontoken> {

	private static final long serialVersionUID = 1L;

	public ConnectiontokenDao() {
		super(Connectiontoken.class);
	}

}