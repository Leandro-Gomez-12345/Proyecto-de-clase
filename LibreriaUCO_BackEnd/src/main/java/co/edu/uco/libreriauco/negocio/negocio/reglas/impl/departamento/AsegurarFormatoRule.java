package co.edu.uco.libreriauco.negocio.negocio.reglas.impl.departamento;

import co.edu.uco.libreriauco.dominio.DepartamentoDominio;
import co.edu.uco.libreriauco.dominio.PaisDominio;
import co.edu.uco.libreriauco.negocio.negocio.reglas.Rule;
import co.edu.uco.libreriauco.transversal.catalogo.CatalogoMensajes;
import co.edu.uco.libreriauco.transversal.excepciones.LibreriaUCONegocioExcepcion;
import co.edu.uco.libreriauco.transversal.utilitarios.UtilObjeto;
import co.edu.uco.libreriauco.transversal.utilitarios.UtilTexto;
import co.edu.uco.libreriauco.transversal.utilitarios.UtilUUID;

public class AsegurarFormatoRule implements Rule<DepartamentoDominio>{
	
	private static final Rule<DepartamentoDominio> instancia = new AsegurarFormatoRule();
	
	private AsegurarFormatoRule() {
		
	}
	
	public static final Rule<DepartamentoDominio> obtenerInstancia() {
		return instancia;
	}

	@Override
	public void ejecutar(DepartamentoDominio... datos) {
		var departamento = UtilObjeto.obtenerValorDefectoSiValorOriginalEsNulo(datos[0], 
				new DepartamentoDominio.Builder().build());
		
		validarPais(departamento.getPais());
		validarLongitudNombreDepartamento(departamento.getNombre());
		asegurarCaracteresValidos(departamento.getNombre());
	}
	
	private void validarPais(PaisDominio pais) {
		if (UtilUUID.obtenerUUIDDefecto().equals(pais.getId())) {
			var mensajeUsuario = CatalogoMensajes.DepartamentoNegocioImpl.PAIS_OBLIGATORIO_NO_VALIDO;
			throw LibreriaUCONegocioExcepcion.crear(mensajeUsuario);
		}
	}
	
	private void validarLongitudNombreDepartamento(String nombre) {
		if (!UtilTexto.getUtilTexto().longitudCadenaEsValida(nombre, 3, 50, true)) {
			var mensajeUsuario = CatalogoMensajes.DepartamentoNegocioImpl.LONGITUD_NOMBRE_DEPARTAMENTO_NO_VALIDA;
			throw LibreriaUCONegocioExcepcion.crear(mensajeUsuario);
		}
	}
	
	private void asegurarCaracteresValidos(String nombre) {
		if (!UtilTexto.getUtilTexto().formatoEsValido(nombre, UtilTexto.SOLO_LETRAS_ESPACIOS)) {
			var mensajeUsuario = CatalogoMensajes.DepartamentoNegocioImpl.FORMATO_DEPARTAMENTO_NO_VALIDO;
			throw LibreriaUCONegocioExcepcion.crear(mensajeUsuario);
		}
	}
	
}
