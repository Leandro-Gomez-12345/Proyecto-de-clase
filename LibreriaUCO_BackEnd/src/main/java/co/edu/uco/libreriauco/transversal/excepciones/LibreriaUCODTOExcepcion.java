package co.edu.uco.libreriauco.transversal.excepciones;

import co.edu.uco.libreriauco.transversal.excepciones.enums.Capa;

public class LibreriaUCODTOExcepcion extends LibreriaUCOExcepcion {

	private static final long serialVersionUID = -856566259327133495L;

	private LibreriaUCODTOExcepcion(String mensajeUsuario, String mensajeTecnico,
			Exception excepcionRaiz) {
		super(Capa.ENTIDAD, mensajeUsuario, mensajeTecnico, excepcionRaiz);
	}
	
	public static LibreriaUCOExcepcion crear(String mensajeUsuario) {
		return new LibreriaUCODTOExcepcion(mensajeUsuario, mensajeUsuario,
				new Exception(mensajeUsuario));
	}
	
	public static LibreriaUCOExcepcion crear(String mensajeUsuario, String mensajeTecnico) {
		return new LibreriaUCODTOExcepcion(mensajeUsuario, mensajeTecnico,
				new Exception(mensajeTecnico));
	}
	
	public static LibreriaUCOExcepcion crear(String mensajeUsuario, String mensajeTecnico, Exception excepcionRaiz) {
		return new LibreriaUCODTOExcepcion(mensajeUsuario, mensajeTecnico,
				new Exception(excepcionRaiz));
	}
}
