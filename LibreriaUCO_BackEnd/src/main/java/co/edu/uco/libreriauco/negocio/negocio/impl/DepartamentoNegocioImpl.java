package co.edu.uco.libreriauco.negocio.negocio.impl;

import java.util.List;
import java.util.UUID;

import co.edu.uco.libreriauco.dao.factoria.DAOFactory;
import co.edu.uco.libreriauco.dominio.DepartamentoDominio;
import co.edu.uco.libreriauco.negocio.negocio.DepartamentoNegocio;
import co.edu.uco.libreriauco.negocio.negocio.assembler.impl.DepartamentoEntidadAssembler;
import co.edu.uco.libreriauco.negocio.negocio.reglas.impl.departamento.AsegurarDepartamentoUnicoRule;
import co.edu.uco.libreriauco.negocio.negocio.reglas.impl.departamento.AsegurarFormatoRule;
import co.edu.uco.libreriauco.negocio.negocio.reglas.impl.departamento.AsegurarIdDepartamentoExista;
import co.edu.uco.libreriauco.transversal.utilitarios.UtilUUID;

public class DepartamentoNegocioImpl implements DepartamentoNegocio {
	
	private DAOFactory daoFactory;
	
	public DepartamentoNegocioImpl(DAOFactory daoFactory) {
		this.daoFactory = daoFactory;
	}

	@Override
	public void registrarInformacionNuevoDepartamento(DepartamentoDominio datos) {
		AsegurarFormatoRule.obtenerInstancia().ejecutar(datos);
		AsegurarDepartamentoUnicoRule.obtenerInstancia().ejecutar(datos.getPais().getId(), 
				datos.getNombre(), daoFactory);
		
		var departamentoEntidad = DepartamentoEntidadAssembler.getInstance().convertirAEntidad(datos);
		departamentoEntidad.setId(UtilUUID.generar());
		
		daoFactory.obtenerDepartamentoDAO().crear(departamentoEntidad);
	}

	@Override
	public void modificarInformacionDepartamentoExistente(UUID id, DepartamentoDominio datos) {
		AsegurarIdDepartamentoExista.obtenerInstancia().ejecutar(id, daoFactory);
		AsegurarFormatoRule.obtenerInstancia().ejecutar(datos);
		AsegurarDepartamentoUnicoRule.obtenerInstancia().ejecutar(datos.getPais().getId(), 
				datos.getNombre(), daoFactory);
		
		var departamentoEntidad = DepartamentoEntidadAssembler.getInstance().convertirAEntidad(datos);
		
		daoFactory.obtenerDepartamentoDAO().actualizar(id, departamentoEntidad);
	}

	@Override
	public void darBajaInformacionDepartamentoExistente(UUID id) {
		AsegurarIdDepartamentoExista.obtenerInstancia().ejecutar(id, daoFactory);
		
		daoFactory.obtenerDepartamentoDAO().eliminar(id);
	}

	@Override
	public List<DepartamentoDominio> consultarTodos() {
		var departamentos = daoFactory.obtenerDepartamentoDAO().consultarTodos();
		return DepartamentoEntidadAssembler.getInstance().convertirADominio(departamentos);
	}
	
}
