package co.edu.uco.libreriauco.transversal.excepciones;

import co.edu.uco.libreriauco.transversal.excepciones.enums.Capa;

public class LibreriaUCOTransversalExcepcion extends LibreriaUCOExcepcion {

	private static final long serialVersionUID = -4395270926304123906L;

	private LibreriaUCOTransversalExcepcion(String mensajeUsuario, String mensajeTecnico,
			Exception excepcionRaiz) {
		super(Capa.TRANSVERSAL, mensajeUsuario, mensajeTecnico, excepcionRaiz);
	}

	public static LibreriaUCOExcepcion crear(String mensajeUsuario) {
		return new LibreriaUCOTransversalExcepcion(mensajeUsuario, mensajeUsuario,
				new Exception(mensajeUsuario));
	}
	
	public static LibreriaUCOExcepcion crear(String mensajeUsuario, String mensajeTecnico) {
		return new LibreriaUCOTransversalExcepcion(mensajeUsuario, mensajeTecnico,
				new Exception(mensajeTecnico));
	}
	
	public static LibreriaUCOExcepcion crear(String mensajeUsuario, String mensajeTecnico, Exception excepcionRaiz) {
		return new LibreriaUCOTransversalExcepcion(mensajeUsuario, mensajeTecnico,
				new Exception(excepcionRaiz));
	}
}
