package co.edu.uco.libreriauco.transversal.excepciones;

import co.edu.uco.libreriauco.transversal.excepciones.enums.Capa;
import co.edu.uco.libreriauco.transversal.utilitarios.UtilObjeto;
import co.edu.uco.libreriauco.transversal.utilitarios.UtilTexto;

public class LibreriaUCOEntidadExcepcion extends LibreriaUCOExcepcion {

	private LibreriaUCOEntidadExcepcion(Capa capa, String mensajeUsuario, String mensajeTecnico,
			Exception excepcionRaiz) {
		super(capa.DOMINIO, mensajeUsuario, mensajeTecnico, excepcionRaiz);
	}


}
