package co.web.dao;

import co.web.modelo.Rol;
import co.web.util.Conexion;

public class RolDao extends Conexion<Rol> implements GenericDao<Rol> {

	private static final long serialVersionUID = 1L;

	public RolDao() {
		super(Rol.class);
	}

}
