package co.edu.uco.libreriauco.negocio.negocio.reglas.impl.pais;

import co.edu.uco.libreriauco.dominio.PaisDominio;
import co.edu.uco.libreriauco.negocio.negocio.reglas.Rule;

public class ValidarDatosRegistrarInformacionNuevoPaisRule implements Rule<PaisDominio> {

	@Override
	public void ejecutar(PaisDominio... datos) {
		var dominio = datos[0];
		AsegurarNombreNuevoPaisNoExistaRule.obtenerInstancia().ejecutar(dominio.getNombre());		
	}

}
