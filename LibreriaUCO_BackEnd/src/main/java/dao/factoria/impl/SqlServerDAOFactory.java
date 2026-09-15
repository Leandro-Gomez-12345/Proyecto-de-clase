package dao.factoria.impl;

import java.sql.Connection;

import dao.datos.entidad.DepartamentoDAO;
import dao.datos.entidad.PaisDAO;
import dao.datos.entidad.sqlserver.DepartamentoSqlServerDAO;
import dao.datos.entidad.sqlserver.PaisSqlServerDAO;
import dao.factoria.DAOFactory;

public class SqlServerDAOFactory extends DAOFactory {
	
	@Override
	protected void abrirConexion() {
		//TAREA: ¿Como abrir una conexion con SQL Server desde java?	
		Connection conexion = null;
		setConexion(conexion);
		
	}

	@Override
	public PaisDAO obtenerPaisDAO() {

		return new PaisSqlServerDAO();
	}

	@Override
	public DepartamentoDAO obtenerDepartamentoDAO() {

		return new DepartamentoSqlServerDAO();
	}
}
