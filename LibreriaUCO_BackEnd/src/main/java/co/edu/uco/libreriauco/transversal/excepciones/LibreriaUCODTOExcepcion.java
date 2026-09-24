package co.edu.uco.libreriauco.transversal.excepciones;

import co.edu.uco.libreriauco.transversal.excepciones.enums.Capa;
import co.edu.uco.libreriauco.transversal.utilitarios.UtilObjeto;
import co.edu.uco.libreriauco.transversal.utilitarios.UtilTexto;

public class LibreriaUCODTOExcepcion extends LibreriaUCOExcepcion {

	protected LibreriaUCODTOExcepcion(Capa capa, String mensajeUsuario, String mensajeTecnico,
			Exception excepcionRaiz) {
		super(capa.ENTIDAD, mensajeUsuario, mensajeTecnico, excepcionRaiz);
	}


}
