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
			return (!conexionEstaVacia(conexion) && !conexion.isClosed());
		} catch (SQLException excepcion) {
			var mensajeUsuario = CatalogoMensajes.UtilSQL.USUARIO_ERROR_PROBLEMA_VALIDANDO_SI_CONEXION_SQL_ESTA_ABIERTA;
			throw LibreriaUCOTransversalExcepcion.crear(mensajeUsuario, excepcion.getMessage(), excepcion);
		} catch (Exception excepcion) {
			var mensajeUsuario = CatalogoMensajes.UtilSQL.USUARIO_ERROR_PROBLEMA_NO_CONTROLADO_SI_CONEXION_SQL_ESTA_ABIERTA;
			throw LibreriaUCOTransversalExcepcion.crear(mensajeUsuario, excepcion.getMessage(), excepcion);
		}
	}
	
	public static void asegurarConexionAbierta(Connection conexion) {
		if (!conexionEstaAbierta(conexion)) {
			var mensajeUsuario = "Mensaje que indique en terminos de usuario que no es posible continuar porque ls conexion no esta abierta";
			throw LibreriaUCOTransversalExcepcion.crear(mensajeUsuario);
		}
	}
	
	public static void iniciarTransaccion(Connection conexion) {
		
		if(transaccionEstaIniciada(conexion)) {
			var mensajeUsuario = CatalogoMensajes.UtilSQL.USUARIO_ERROR_NO_ES_POSIBLE_INICIAR_TRANSACCION_SQL;
			throw LibreriaUCOTransversalExcepcion.crear(mensajeUsuario);
		}
		
		// Tarea que se tenia de como inicar la transaccion
	}
	
	public static void confirmarTransaccion(Connection conexion) {
		if(!transaccionEstaIniciada(conexion)) {
			var mensajeUsuario = "Mensaje de error porque no es posible confirmar una transaccion que no fue iniciada";
			throw LibreriaUCOTransversalExcepcion.crear(mensajeUsuario);
		}
		
		// Tarea que se tenia de como confirmar la transaccion
	}
	
	public static void cancelarTransaccion(Connection conexion) {
		if(!transaccionEstaIniciada(conexion)) {
			var mensajeUsuario = "Mensaje de error porque no es posible cancelar una transaccion que no fue iniciada";
			throw LibreriaUCOTransversalExcepcion.crear(mensajeUsuario);
		}
		
		// Tarea que se tenia de como cancelar la transaccion
	}
	
	public static void cerrarConexion(Connection conexion) {
		if(!conexionEstaAbierta(conexion)) {
			var mensajeUsuario = "Mensaje de error porque no es posible cerrar una conexion que no esta abierta";
			throw LibreriaUCOTransversalExcepcion.crear(mensajeUsuario);
		}
		
		// Tarea que se tenia de como cerrar la conexion
	}
	
	public static boolean transaccionEstaIniciada(Connection conexion) {
		try {
			return conexionEstaAbierta(conexion) && !conexion.getAutoCommit();
		} catch (SQLException excepcion) {
			var mensajeUsuario = CatalogoMensajes.UtilSQL.USUARIO_ERROR_PROBLEMA_VALIDANDO_SI_TRANSACCION_SQL_ESTA_INICIADA;
			throw LibreriaUCOTransversalExcepcion.crear(mensajeUsuario, excepcion.getMessage(), excepcion);
		} catch (Exception excepcion) {
			var mensajeUsuario = CatalogoMensajes.UtilSQL.USUARIO_ERROR_PROBLEMA_NO_CONTROLADO_VALIDANDO_SI_TRANSACCION_SQL_ESTA_INICIADA;
			throw LibreriaUCOTransversalExcepcion.crear(mensajeUsuario, excepcion.getMessage(), excepcion);
		}
	}
	
	public static boolean conexionEstaVacia(Connection conexion) {
		return UtilObjeto.esNulo(conexion);
	}
}
