package co.edu.uco.libreriauco.negocio.negocio;

import java.util.List;
import java.util.UUID;

import co.edu.uco.libreriauco.dominio.PaisDominio;

public interface PaisNegocio {
	
	void registrarInformacionNuevoPais(PaisDominio datos);
	
	void modificarInformacionPaisExistente(UUID id, PaisDominio datos);
	
	void darBajaInformacionPaisExistente(UUID id, PaisDominio datos);
	
	List<PaisDominio> consultarPorFiltro(PaisDominio filtro);
	
	List<PaisDominio> consultarTodos();
	
	PaisDominio consultarPorId(UUID id);
	
}
