package co.edu.uco.libreriauco.dao.factoria.impl;

import java.sql.DriverManager;
import java.sql.SQLException;

import co.edu.uco.libreriauco.dao.datos.entidad.DepartamentoDAO;
import co.edu.uco.libreriauco.dao.datos.entidad.PaisDAO;
import co.edu.uco.libreriauco.dao.datos.entidad.postgresql.DepartamentoPostgreSqlDAO;
import co.edu.uco.libreriauco.dao.datos.entidad.postgresql.PaisPostgreSqlDAO;
import co.edu.uco.libreriauco.dao.factoria.DAOFactory;
import co.edu.uco.libreriauco.excepcion.PersistenciaException;

public class PostgreSqlDAOFactory extends DAOFactory {

	private static final String URL = "jdbc:postgresql://localhost:5432/libreriauco";
	private static final String USUARIO = "postgres";
	private static final String CONTRASENA = "tu_contrasena";

	@Override
	protected void abrirConexion() {
		try {
			if (conexion != null && !conexion.isClosed()) {
				return;
			}
			conexion = DriverManager.getConnection(URL, USUARIO, CONTRASENA);
		} catch (SQLException excepcion) {
			throw new PersistenciaException("No se pudo abrir la conexión a PostgreSQL", excepcion);
		}
	}

	@Override
	public PaisDAO obtenerPaisDAO() {
		abrirConexion();
		return new PaisPostgreSqlDAO(conexion);
	}

	@Override
	public DepartamentoDAO obtenerDepartamentoDAO() {
		abrirConexion();
		return new DepartamentoPostgreSqlDAO(conexion);
	}

}