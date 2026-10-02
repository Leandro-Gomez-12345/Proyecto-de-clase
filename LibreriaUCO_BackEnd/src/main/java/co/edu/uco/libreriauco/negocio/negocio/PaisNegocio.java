package co.edu.uco.libreriauco.negocio.negocio;

import java.util.List;
import java.util.UUID;

import co.edu.uco.libreriauco.dominio.PaisDominio;

public interface PaisNegocio {
	
	// Aca se colocan los metodos en el diagrama de clases
	void registrarInformacionNuevoPais(PaisDominio datos);
	
	void modificarInformacionPaisExistente(UUID id, PaisDominio datos);
	
	void darBajaInformacionPaisExistente(UUID id, PaisDominio datos);
	
	List<PaisDominio> consultarPorFiltro(PaisDominio filtro);
	
	List<PaisDominio> consultarTodos();
	
	PaisDominio consultarPorId(UUID id);
	
}
