package co.web.dao;

import co.web.modelo.Reporte;
import co.web.util.Conexion;

public class ReporteDao extends Conexion<Reporte> implements GenericDao<Reporte> {

	private static final long serialVersionUID = 1L;

	public ReporteDao() {
		super(Reporte.class);
	}

}