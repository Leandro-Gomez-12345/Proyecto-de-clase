package co.edu.uco.libreriauco.transversal.catalogo;

public class CatalogoMensajes {
	
	private CatalogoMensajes() {
		
	}
	
	public static class UtilSQL {
		
		private UtilSQL() {
		}
		
		public static final String USUARIO_ERROR_PROBLEMA_VALIDANDO_SI_CONEXION_SQL_ESTA_ABIERTA = "Se ha presentado un problema tratado de validar si la conexión con contra la fuente de informacion en la cual se iba a tratar de llevar acabo la operacion deseada estaba o no abierta. Por favor intente de nuevo y si el problema persiste contacte al administrador de la aplicacion y reporte la novedad...";
		public static final String USUARIO_ERROR_PROBLEMA_NO_CONTROLADO_SI_CONEXION_SQL_ESTA_ABIERTA = "Se ha presentado un problema NO CONTROLADO tratado de validar si la conexión con contra la fuente de informacion en la cual se iba a tratar de llevar acabo la operacion deseada estaba o no abierta. Por favor intente de nuevo y si el problema persiste contacte al administrador de la aplicaicon y reporte la novedad...";
		public static final String USUARIO_ERROR_PROBLEMA_VALIDANDO_SI_TRANSACCION_SQL_ESTA_INICIADA = "Se ha presentado un problema tratado de validar si la conexión con contra la fuente de informacion estba en un estado concistente al tratar de llevar acabo la operacion deseada. Por favor intente de nuevo y si el problema persiste contacte al administrador de la aplicacion y reporte la novedad...";
		public static final String USUARIO_ERROR_PROBLEMA_NO_CONTROLADO_VALIDANDO_SI_TRANSACCION_SQL_ESTA_INICIADA = "Se ha presentado un problema NO CONTROLADO tratado de validar si la conexión con contra la fuente de informacion estba en un estado concistente al tratar de llevar acabo la operacion deseada. Por favor intente de nuevo y si el problema persiste contacte al administrador de la aplicacion y reporte la novedad...";
		public static final String USUARIO_ERROR_NO_ES_POSIBLE_INICIAR_TRANSACCION_SQL = "No es posible continuar con la operacion deseada, debiado a que la conexion contra la fuente de informacion se encuentra en un estado incosistente, por que esta cerrada, esta vacia o porque la transacción ya fue iniciada. Por favor intente de nuevo y si el problema persiste contacte al administrador de la aplicacion y reporte la novedad...";
	}
}
