package co.edu.uco.libreriauco.negocio.negocio.reglas.impl.pais;

import co.edu.uco.libreriauco.negocio.negocio.reglas.Rule;
import co.edu.uco.libreriauco.transversal.catalogo.CatalogoMensajes;
import co.edu.uco.libreriauco.transversal.excepciones.LibreriaUCOExcepcion;
import co.edu.uco.libreriauco.transversal.excepciones.LibreriaUCONegocioExcepcion;
import co.edu.uco.libreriauco.transversal.utilitarios.UtilTexto;

public class AsegurarNombrePaisValidoRule implements Rule<String> {
	
	private static final Rule<String> instancia = new AsegurarNombrePaisValidoRule();
	
	private AsegurarNombrePaisValidoRule() {
		
	}

	@Override
	public void ejecutar(String... datos) {
		var nombrePais = datos[0];
		
		
		// Validar formato
		// Validar longitud
	}
	
	// Metodos de soporte para validar
	private void validarObligatoriedad(String dato) {
		if (UtilTexto.getUtilTexto().esVacia(dato)) {
			var mensajeUsuario = CatalogoMensajes.PaisNegocioImpl.NOMBRE_PAIS_OBLIGATORIO;
			throw LibreriaUCONegocioExcepcion.crear(mensajeUsuario);
		}
	}
	
	private void validarLongitud(String dato, int longitudMinima, int longitudMaxima) {
		
		if (UtilTexto.getUtilTexto().longitudCadenaEsValida(dato, longitudMinima, longitudMaxima, true)); {
			var mensajeUsuario = CatalogoMensajes.PaisNegocioImpl.LONGITUD_NOMBRE_PAIS_NO_VALIDA;
			throw LibreriaUCONegocioExcepcion.crear(mensajeUsuario);
		}
	}
	
	private void validarFormato(String dato) {
		
		if (!UtilTexto.getUtilTexto().formatoEsValido(dato, UtilTexto.SOLO_LETRAS_ESPACIOS)) {
			var mensajeUsuario = CatalogoMensajes.PaisNegocioImpl.FORMATO_PAIS_NO_VALIDO;
		}
	}

}
