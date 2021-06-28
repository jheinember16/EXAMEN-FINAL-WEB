package co.web.dao;

import co.web.modelo.Typedb;
import co.web.util.Conexion;

public class TypedbDao extends Conexion<Typedb> implements GenericDao<Typedb> {

	private static final long serialVersionUID = 1L;

	public TypedbDao() {
		super(Typedb.class);
	}

}
