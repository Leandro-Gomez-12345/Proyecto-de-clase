package co.edu.uco.libreriauco.negocio.negocio.reglas.impl.departamento;

import java.util.UUID;

import co.edu.uco.libreriauco.dao.factoria.DAOFactory;
import co.edu.uco.libreriauco.negocio.negocio.reglas.Rule;
import co.edu.uco.libreriauco.transversal.catalogo.CatalogoMensajes;
import co.edu.uco.libreriauco.transversal.excepciones.LibreriaUCONegocioExcepcion;
import co.edu.uco.libreriauco.transversal.utilitarios.UtilUUID;

public class AsegurarIdDepartamentoExista implements Rule<Object>{
	
	private static final Rule<Object> instancia = new AsegurarIdDepartamentoExista();
	
	private AsegurarIdDepartamentoExista() {
		
	}
	
	public static final Rule<Object> obtenerInstancia() {
		return instancia;
	}

	@Override
	public void ejecutar(Object... datos) {
		var departamentoId = (UUID) datos[0];
		var daoFactory = (DAOFactory) datos[1];
		
		var departamentosEncontrados = daoFactory.obtenerDepartamentoDAO().consultarPorId(departamentoId);
		
		if (UtilUUID.obtenerUUIDDefecto().equals(departamentosEncontrados.getId())) {
			var mensajeUsuario = CatalogoMensajes.DepartamentoNegocioImpl.DEPARTAMENTO_NO_EXISTE;
			throw LibreriaUCONegocioExcepcion.crear(mensajeUsuario);
		}
	}
	
	
}
