package co.edu.uco.libreriauco.negocio.negocio.reglas.impl.departamento;

import java.util.UUID;

import co.edu.uco.libreriauco.dao.factoria.DAOFactory;
import co.edu.uco.libreriauco.entidad.DepartamentoEntidad;
import co.edu.uco.libreriauco.entidad.PaisEntidad;
import co.edu.uco.libreriauco.negocio.negocio.reglas.Rule;
import co.edu.uco.libreriauco.transversal.catalogo.CatalogoMensajes;
import co.edu.uco.libreriauco.transversal.excepciones.LibreriaUCONegocioExcepcion;

public class AsegurarDepartamentoUnicoRule implements Rule<Object>{
	
	private static final Rule<Object> instancia = new AsegurarDepartamentoUnicoRule();
	
	private AsegurarDepartamentoUnicoRule() {
		
	}
	
	public static final Rule<Object> obtenerInstancia() {
		return instancia;
	}
	
	@Override
	public void ejecutar(Object... datos) {
		var pais = (UUID) datos[0];
		var nombreDepartamento = (String) datos[1];
		var daoFactory = (DAOFactory) datos[2];

		var departamentoFiltro = new DepartamentoEntidad();
		departamentoFiltro.setPais(new PaisEntidad(pais, ""));
		departamentoFiltro.setNombre(nombreDepartamento);
		
		var departamentosEncontrados = daoFactory.obtenerDepartamentoDAO().consultarPorFiltro(departamentoFiltro);
		
		if (!departamentosEncontrados.isEmpty()) {
			var mensajeUsuario = CatalogoMensajes.DepartamentoNegocioImpl.DEPARTAMENTO_EXISTE_CON_EL_MISMO_NOMBRE;
			throw LibreriaUCONegocioExcepcion.crear(mensajeUsuario);
		}
	}
	
}
