package dao.datos.entidad;

public abstract class SqlDAO {
	
	private Connection conexion;
	
	protected SqlDAO(Connection conexion) {
		setConexion(conexion);
	}
	
	private void setConexion(Connection conexion) {
		this.conexion = conexion;
	}
	
	protected connecition getConnection() {
		return conexion;
	}
}
