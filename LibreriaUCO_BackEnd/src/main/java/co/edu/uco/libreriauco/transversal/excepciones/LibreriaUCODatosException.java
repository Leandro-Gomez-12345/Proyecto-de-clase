package co.edu.uco.libreriauco.transversal.excepciones;

import co.edu.uco.libreriauco.transversal.excepciones.enums.Capa;

public class LibreriaUCODatosException extends LibreriaUCOExcepcion{

	private LibreriaUCODatosException(Capa capa, String mensajeUsuario, String mensajeTecnico,
			Exception excepcionRaiz) {
		super(capa.DATOS, mensajeUsuario, mensajeTecnico, excepcionRaiz);
	}
	
}
