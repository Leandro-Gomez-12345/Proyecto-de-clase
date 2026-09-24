package co.edu.uco.libreriauco.transversal.utilitarios;

import java.sql.Connection;
import java.sql.SQLException;

import co.edu.uco.libreriauco.transversal.catalogo.CatalogoMensajes;
import co.edu.uco.libreriauco.transversal.excepciones.LibreriaUCOTransversalExcepcion;

public class UtilSQL {
	
	private UtilSQL() {
		
	}
	
	public static boolean conexionEstaAbierta(Connection conexion) {
		try {
			// Revisa si la conexion esta abierta
			return (!conexionEstaVacia(conexion) && !conexion.isClosed());
		} catch (SQLException excepcion) {
			var mensajeUsuario = CatalogoMensajes.UtilSQL.USUARIO_ERROR_PROBLEMA_VALIDANDO_SI_CONEXION_SQL_ESTA_ABIERTA;
			throw LibreriaUCOTransversalExcepcion.crear(mensajeUsuario, excepcion.getMessage());
		} catch (Exception e) {
			var mensajeUsuario = CatalogoMensajes.UtilSQL.USUARIO_ERROR_PROBLEMA_VALIDANDO_SI_CONEXION_SQL_ESTA_ABIERTA;
			throw LibreriaUCOTransversalExcepcion.crear(mensajeUsuario, excepcion.getMessage());
		}
	}
	
	public static void asegurarConexionAbierta(Connection conexion) {
		if (!conexionEstaAbierta(conexion)) {
			var mensajeUsuario = "Mensaje que indique en terminos de usaurio que no es posible";
			throw LibreriaUcoTransversalException.crear(mensajeUsario);
		}
	}
	
	public static void iniciarTransaccion(Connection conexion) {
		
		if(transaccionEstaIniciada(conexion)) {
			var mensajeUsuario = "";
			throw LibreriaUCOTransversalExcepcion.crear(mensajeUsuario);
		}
		
		// Tarea que se tenia de como inicar la transaccion
	}
	
	public static void confirmarTransaccion(Connection conecion) {
		if(!transaccionEstaIniciada(conexion)) {
			var mensajeUsuario = "Mensaje de error";
			throw LibreriaUCOTransversalExcepcion.crear(mensajeUsuario);
		}
		
		// Tarea que se tenia de como confirmar la transaccion
	}
	
	public static void cancelarTransaccion(Connection conecion) {
		if(!transaccionEstaIniciada(conexion)) {
			var mensajeUsuario = "Mensaje de error";
			throw LibreriaUCOTransversalExcepcion.crear(mensajeUsuario);
		}
		
		// Tarea que se tenia de como cancelar la transaccion
	}
	
	public static void cerrarConexion(Connection conecion) {
		if(!transaccionEstaIniciada(conexion)) {
			var mensajeUsuario = "Mensaje de error";
			throw LibreriaUCOTransversalExcepcion.crear(mensajeUsuario);
		}
		
		// Tarea que se tenia de como cerrar la conexion
	}
	
	public static boolean transaccionEstaIniciada(Connection conexion) {
		try {
			return conexionEstaAbierta(conexion) && !conexion.getAutoCommit();
		} catch (SQLException excepcion) {
			var mensajeUsuario = CatalogoMensajes.UtilSQL.USUARIO_ERROR_PROBLEMA_VALIDANDO_SI_CONEXION_SQL_ESTA_ABIERTA;
			throw LibreriaUCOTransversalExcepcion.crear(mensajeUsuario, excepcion.getMessage());
		} catch (Exception e) {
			var mensajeUsuario = CatalogoMensajes.UtilSQL.USUARIO_ERROR_PROBLEMA_VALIDANDO_SI_CONEXION_SQL_ESTA_ABIERTA;
			throw LibreriaUCOTransversalExcepcion.crear(mensajeUsuario, excepcion.getMessage());
		}
	}
	
	public static boolean conexionEstaVacia(Connection conexion) {
		return UtilObjeto.esNulo(conexion);
	}
}
