package co.web.dao;

import co.web.modelo.Seguimiento;
import co.web.util.Conexion;

public class SeguimientoDao extends Conexion<Seguimiento> implements GenericDao<Seguimiento> {

	private static final long serialVersionUID = 1L;

	public SeguimientoDao() {
		super(Seguimiento.class);
	}

}
