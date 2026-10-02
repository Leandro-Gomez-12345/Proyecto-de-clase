package co.edu.uco.libreriauco.dao.factoria.impl;

import java.sql.DriverManager;
import java.sql.SQLException;

import co.edu.uco.libreriauco.dao.datos.entidad.DepartamentoDAO;
import co.edu.uco.libreriauco.dao.datos.entidad.PaisDAO;
import co.edu.uco.libreriauco.dao.datos.entidad.mysql.DepartamentoMySqlDAO;
import co.edu.uco.libreriauco.dao.datos.entidad.mysql.PaisMySqlDAO;
import co.edu.uco.libreriauco.dao.factoria.DAOFactory;
import co.edu.uco.libreriauco.transversal.catalogo.CatalogoMensajes;
import co.edu.uco.libreriauco.transversal.excepciones.LibreriaUCODatosException;

public class MySqlDAOFactory extends DAOFactory {
	
	private static final String URL = System.getenv().getOrDefault("LIBRERIAUCO_MYSQL_URL",
			"jdbc:mysql://localhost:3306/libreriauco");
	private static final String USUARIO = System.getenv().getOrDefault("LIBRERIAUCO_MYSQL_USUARIO", "root");
	private static final String CONTRASENA = System.getenv().getOrDefault("LIBRERIAUCO_MYSQL_CONTRASENA", "");

	@Override
	protected void abrirConexion() {
		try {
			setConexion(DriverManager.getConnection(URL, USUARIO, CONTRASENA));
		} catch (SQLException excepcion) {
			var mensajeUsuario = CatalogoMensajes.Datos.USUARIO_ERROR_ABRIENDO_CONEXION;
			throw LibreriaUCODatosException.crear(mensajeUsuario, excepcion.getMessage(), excepcion);
		}
	}

	@Override
	public PaisDAO obtenerPaisDAO() {
		return new PaisMySqlDAO(getConexion());
	}

	@Override
	public DepartamentoDAO obtenerDepartamentoDAO() {
		return new DepartamentoMySqlDAO(getConexion());
	}
	
}
