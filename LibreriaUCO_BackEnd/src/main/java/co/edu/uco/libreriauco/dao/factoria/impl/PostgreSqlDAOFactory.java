package co.edu.uco.libreriauco.dao.factoria.impl;

import co.edu.uco.libreriauco.dao.datos.entidad.DepartamentoDAO;
import co.edu.uco.libreriauco.dao.datos.entidad.PaisDAO;
import co.edu.uco.libreriauco.dao.factoria.DAOFactory;

public class PostgreSqlDAOFactory extends DAOFactory{

	@Override
	protected void abrirConexion() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public PaisDAO obtenerPaisDAO() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public DepartamentoDAO obtenerDepartamentoDAO() {
		// TODO Auto-generated method stub
		return null;
	}

}
