package dao.factoria;

import java.sql.Connection;

import dao.datos.entidad.DepartamentoDAO;
import dao.datos.entidad.PaisDAO;

public abstract class DAOFactory {
	
	private Connection conexion;
	
	protected DAOFactory(Connection conexion) {
		this.conexion = conexion;
	}
	
	protected Connection getConexion() {
		return conexion;
	}
	
	protected void setConexion(Connection conexion) {
		// Tarea: Asegurar que la conexion este abierta y sea valida
		this.conexion = conexion;
	}
	
	protected void abrirConexion1() {
		Connection conexion = null;
		setConexion(conexion);
	}
	
	protected abstract void abrirConexion();
	
	public void cerrarConexion() {
		// Tarea: ¿Cómo se cierra la conexión de forma segura?
	}
	
	public void iniciarTransaccion() {
		// Tarea: ¿Como se inicia una transaccion de forma segura?
	}
	
	public void confirmarTransaccion() {
		// Tarea: ¿Como se confirma una transaccion de forma segura?
	}
	
	public void cancelarTransaccion() {
		// Tarea: ¿Como se cancela una transaccion de forma segura?
	}
	
	public abstract PaisDAO obtenerPaisDAO();
	
	public abstract DepartamentoDAO obtenerDepartamentoDAO();
}
