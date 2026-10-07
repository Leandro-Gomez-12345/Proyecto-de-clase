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
		
		public static final String USUARIO_ERROR_CONEXION_SQL_NO_ESTA_ABIERTA = "No es posible llevar a cabo la operacion deseada porque la conexion con la fuente de informacion no esta abierta. Por favor intente de nuevo y si el problema persiste contacte al administrador de la aplicacion...";
		public static final String USUARIO_ERROR_CONEXION_SQL_NO_ES_VALIDA = "La conexion con la fuente de informacion no esta respondiendo. Por favor intente de nuevo y si el problema persiste contacte al administrador de la aplicacion...";
		public static final String USUARIO_ERROR_PROBLEMA_VALIDANDO_SI_CONEXION_SQL_ES_VALIDA = "Se presento un problema tratando de validar si la conexion con la fuente de informacion esta respondiendo. Por favor intente de nuevo y si el problema persiste contacte al administrador de la aplicacion...";
		public static final String USUARIO_ERROR_INICIANDO_TRANSACCION_SQL = "Se presento un problema tratando de iniciar la operacion sobre la fuente de informacion. Por favor intente de nuevo y si el problema persiste contacte al administrador de la aplicacion...";
		public static final String USUARIO_ERROR_NO_ES_POSIBLE_CONFIRMAR_TRANSACCION_SQL = "No es posible confirmar la operacion porque no fue iniciada previamente. Por favor intente de nuevo y si el problema persiste contacte al administrador de la aplicacion...";
		public static final String USUARIO_ERROR_CONFIRMANDO_TRANSACCION_SQL = "Se presento un problema tratando de confirmar los cambios en la fuente de informacion. Por favor intente de nuevo y si el problema persiste contacte al administrador de la aplicacion...";
		public static final String USUARIO_ERROR_NO_ES_POSIBLE_CANCELAR_TRANSACCION_SQL = "No es posible cancelar la operacion porque no fue iniciada previamente. Por favor intente de nuevo y si el problema persiste contacte al administrador de la aplicacion...";
		public static final String USUARIO_ERROR_CANCELANDO_TRANSACCION_SQL = "Se presento un problema tratando de deshacer los cambios en la fuente de informacion. Por favor intente de nuevo y si el problema persiste contacte al administrador de la aplicacion...";
		public static final String USUARIO_ERROR_CERRANDO_CONEXION_SQL = "Se presento un problema tratando de cerrar la conexion con la fuente de informacion. Por favor intente de nuevo y si el problema persiste contacte al administrador de la aplicacion...";
	}
	
	public static final class Datos {

		private Datos() {
		}

		public static final String USUARIO_ERROR_ABRIENDO_CONEXION = "No fue posible conectarse con la fuente de informacion. Por favor intente de nuevo y si el problema persiste contacte al administrador de la aplicacion...";
		public static final String USUARIO_ERROR_CREANDO_PAIS = "Se presento un problema tratando de registrar la informacion del pais. Por favor intente de nuevo y si el problema persiste contacte al administrador de la aplicacion...";
		public static final String USUARIO_ERROR_CONSULTANDO_PAIS = "Se presento un problema tratando de consultar la informacion de los paises. Por favor intente de nuevo y si el problema persiste contacte al administrador de la aplicacion...";
		public static final String USUARIO_ERROR_ACTUALIZANDO_PAIS = "Se presento un problema tratando de actualizar la informacion del pais. Por favor intente de nuevo y si el problema persiste contacte al administrador de la aplicacion...";
		public static final String USUARIO_ERROR_ELIMINANDO_PAIS = "Se presento un problema tratando de eliminar la informacion del pais. Por favor intente de nuevo y si el problema persiste contacte al administrador de la aplicacion...";
	}
	
	public static class PaisNegocioImpl {

		private PaisNegocioImpl() {
			
		}
		
		
		public static final String PAIS_EXISTE_CON_EL_MISMO_NOMBRE_DE_PAIS_A_CREAR = "Ya existe otro pais con el nombre con el cual se desea crear el pais deseado";
		public static final String NOMBRE_PAIS_OBLIGATORIO = "";
		public static final String LONGITUD_NOMBRE_PAIS_NO_VALIDA = "La longitud del nombre";
		public static final String FORMATO_PAIS_NO_VALIDO = "";
	}
}
