package co.edu.uco.libreriauco.negocio.fachada;

import java.util.List;
import java.util.UUID;

import co.edu.uco.libreriauco.dto.DepartamentoDTO;

public interface DepartamentoFachada {
	
	void registrarInformacionNuevoDepartamento(DepartamentoDTO datos);
	
	void modificarInformacionDepartamentoExistente(UUID id, DepartamentoDTO datos);
	
	void darBajaInformacionDepartamentoExistente(UUID id);
	
	List<DepartamentoDTO> consultarTodos();
	
}
