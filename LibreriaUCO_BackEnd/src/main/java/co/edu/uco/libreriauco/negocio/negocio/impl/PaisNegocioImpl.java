package co.edu.uco.libreriauco.negocio.negocio.impl;

import java.util.List;
import java.util.UUID;

import co.edu.uco.libreriauco.dao.factoria.DAOFactory;
import co.edu.uco.libreriauco.dominio.PaisDominio;
import co.edu.uco.libreriauco.entidad.PaisEntidad;
import co.edu.uco.libreriauco.negocio.negocio.PaisNegocio;
import co.edu.uco.libreriauco.negocio.negocio.assembler.impl.PaisEntidadAssembler;
import co.edu.uco.libreriauco.negocio.negocio.reglas.impl.pais.AsegurarNombreNuevoPaisNoExistaRule;
import co.edu.uco.libreriauco.transversal.catalogo.CatalogoMensajes;
import co.edu.uco.libreriauco.transversal.excepciones.LibreriaUCONegocioExcepcion;
import co.edu.uco.libreriauco.transversal.excepciones.LibreriaUCOTransversalExcepcion;

public class PaisNegocioImpl implements PaisNegocio {
	
	private DAOFactory daoFactory;
	
	protected PaisNegocioImpl(DAOFactory daoFactory) {
		this.daoFactory = daoFactory;
	}

	@Override
	public void registrarInformacionNuevoPais(PaisDominio datos) {
		asegurarDatosRegistroNuevoPaisValidos(datos);
		
		AsegurarNombreNuevoPaisNoExistaRule.obtenerInstancia().ejecutar(datos.getNombre(), daoFactory);		
		var paisEntidad = PaisEntidadAssembler.getInstance().convertirAEntidad(datos);
		paisEntidad.setId(generarIdPaisUnico());
		
		daoFactory.obtenerPaisDAO().crear(paisEntidad);
	}
	
	// Lo anterior son metodos de apoyo
	private void asegurarDatosRegistroNuevoPaisValidos(PaisDominio datos) {
		
	}
	
	private UUID generarIdPaisUnico() {
		return UUID.randomUUID();
	}

	@Override
	public void modificarInformacionPaisExistente(UUID id, PaisDominio datos) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void darBajaInformacionPaisExistente(UUID id, PaisDominio datos) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public List<PaisDominio> consultarPorFiltro(PaisDominio filtro) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<PaisDominio> consultarTodos() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public PaisDominio consultarPorId(UUID id) {
		// TODO Auto-generated method stub
		return null;
	}
	
	
}
