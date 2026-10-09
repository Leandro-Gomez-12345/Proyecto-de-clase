package co.edu.uco.libreriauco.transversal.excepciones;

import co.edu.uco.libreriauco.transversal.excepciones.enums.Capa;

public class LibreriaUCOFachadaExcepcion extends LibreriaUCOExcepcion {

	private static final long serialVersionUID = -8286544944606272166L;

	private LibreriaUCOFachadaExcepcion(String mensajeUsuario, String mensajeTecnico,
			Exception excepcionRaiz) {
		super(Capa.NEGOCIO, mensajeUsuario, mensajeTecnico, excepcionRaiz);
	}

	public static LibreriaUCOExcepcion crear(String mensajeUsuario) {
		return new LibreriaUCOFachadaExcepcion(mensajeUsuario, mensajeUsuario,
				new Exception(mensajeUsuario));
	}
	
	public static LibreriaUCOExcepcion crear(String mensajeUsuario, String mensajeTecnico) {
		return new LibreriaUCOFachadaExcepcion(mensajeUsuario, mensajeTecnico,
				new Exception(mensajeTecnico));
	}
	
	public static LibreriaUCOExcepcion crear(String mensajeUsuario, String mensajeTecnico, Exception excepcionRaiz) {
		return new LibreriaUCOFachadaExcepcion(mensajeUsuario, mensajeTecnico,
				new Exception(excepcionRaiz));
	}
	
}
