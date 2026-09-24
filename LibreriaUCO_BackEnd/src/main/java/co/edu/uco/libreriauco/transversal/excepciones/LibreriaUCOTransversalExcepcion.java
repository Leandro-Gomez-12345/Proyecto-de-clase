package co.edu.uco.libreriauco.transversal.excepciones;

import co.edu.uco.libreriauco.transversal.excepciones.enums.Capa;
import co.edu.uco.libreriauco.transversal.utilitarios.UtilObjeto;
import co.edu.uco.libreriauco.transversal.utilitarios.UtilTexto;

public class LibreriaUCOTransversalExcepcion extends LibreriaUCOExcepcion {

	private LibreriaUCOTransversalExcepcion(Capa capa, String mensajeUsuario, String mensajeTecnico,
			Exception excepcionRaiz) {
		super(capa.TRANSVERSAL, mensajeUsuario, mensajeTecnico, excepcionRaiz);
	}


}
