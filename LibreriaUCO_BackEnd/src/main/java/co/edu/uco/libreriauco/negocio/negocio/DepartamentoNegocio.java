package co.edu.uco.libreriauco.negocio.negocio;

import java.util.List;
import java.util.UUID;

import co.edu.uco.libreriauco.dominio.DepartamentoDominio;

public interface DepartamentoNegocio {
	
	void registrarInformacionNuevoDepartamento(DepartamentoDominio datos);
	
	void modificarInformacionDepartamentoExistente(UUID id, DepartamentoDominio datos);
	
	void darBajaInformacionDepartamentoExistente(UUID id);
	
	List<DepartamentoDominio> consultarTodos();
	
}
