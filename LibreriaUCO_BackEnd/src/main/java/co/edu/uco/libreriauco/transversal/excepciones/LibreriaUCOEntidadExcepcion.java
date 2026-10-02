package co.edu.uco.libreriauco.transversal.excepciones;

import co.edu.uco.libreriauco.transversal.excepciones.enums.Capa;
import co.edu.uco.libreriauco.transversal.utilitarios.UtilObjeto;
import co.edu.uco.libreriauco.transversal.utilitarios.UtilTexto;

public class LibreriaUCOEntidadExcepcion extends LibreriaUCOExcepcion {

	private static final long serialVersionUID = 1196571079529546022L;

	private LibreriaUCOEntidadExcepcion(String mensajeUsuario, String mensajeTecnico,
			Exception excepcionRaiz) {
		super(Capa.DOMINIO, mensajeUsuario, mensajeTecnico, excepcionRaiz);
	}
	
	public static LibreriaUCOExcepcion crear(String mensajeUsuario) {
		return new LibreriaUCOEntidadExcepcion(mensajeUsuario, mensajeUsuario,
				new Exception(mensajeUsuario));
	}
	
	public static LibreriaUCOExcepcion crear(String mensajeUsuario, String mensajeTecnico) {
		return new LibreriaUCOEntidadExcepcion(mensajeUsuario, mensajeTecnico,
				new Exception(mensajeTecnico));
	}
	
	public static LibreriaUCOExcepcion crear(String mensajeUsuario, String mensajeTecnico, Exception excepcionRaiz) {
		return new LibreriaUCOEntidadExcepcion(mensajeUsuario, mensajeTecnico,
				new Exception(excepcionRaiz));
	}
}
