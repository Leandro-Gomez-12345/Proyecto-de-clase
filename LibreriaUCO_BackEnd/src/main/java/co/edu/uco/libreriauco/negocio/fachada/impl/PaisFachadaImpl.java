package co.edu.uco.libreriauco.negocio.fachada.impl;

import java.util.List;
import java.util.UUID;

import co.edu.uco.libreriauco.dao.factoria.DAOFactory;
import co.edu.uco.libreriauco.dto.PaisDTO;
import co.edu.uco.libreriauco.negocio.fachada.PaisFachada;
import co.edu.uco.libreriauco.negocio.fachada.assembler.impl.PaisDTOAssembler;
import co.edu.uco.libreriauco.negocio.negocio.PaisNegocio;
import co.edu.uco.libreriauco.negocio.negocio.impl.PaisNegocioImpl;
import co.edu.uco.libreriauco.transversal.catalogo.CatalogoMensajes;
import co.edu.uco.libreriauco.transversal.excepciones.LibreriaUCOExcepcion;
import co.edu.uco.libreriauco.transversal.excepciones.LibreriaUCOFachadaExcepcion;

public class PaisFachadaImpl implements PaisFachada {
	
	private DAOFactory daoFactory;
	private PaisNegocio paisNegocio;
	
	public PaisFachadaImpl() {
		daoFactory = DAOFactory.obtenerFactoria();
		paisNegocio = new PaisNegocioImpl(daoFactory);
	}

	@Override
	public void registrarInformacionNuevoPais(PaisDTO datos) {
		daoFactory.iniciarTransacion();
		
		try {
			var paisDominio = PaisDTOAssembler.getInstance().convertirADominio(datos);
			paisNegocio.registrarInformacionNuevoPais(paisDominio);
			daoFactory.confirmarTransacion();
		} catch (LibreriaUCOExcepcion excepcion) {
			daoFactory.cancelarTransacion();
			throw excepcion;
		} catch (Exception excepcion) {
			daoFactory.cancelarTransacion();
			
			var mensajeUsuario = CatalogoMensajes.PaisFachadaImpl.USUARIO_ERROR_REGISTRANDO_PAIS_NUEVO;
			throw LibreriaUCOFachadaExcepcion.crear(mensajeUsuario, excepcion.getMessage(), excepcion);
		} finally {
			daoFactory.cerrarConexion();
		}
	}

	@Override
	public void modificarInformacionPaisExistente(UUID id, PaisDTO datos) {
		daoFactory.iniciarTransacion();
		
		try {
			var paisDominio = PaisDTOAssembler.getInstance().convertirADominio(datos);
			paisNegocio.modificarInformacionPaisExistente(id, paisDominio);
			daoFactory.confirmarTransacion();
		} catch (LibreriaUCOExcepcion excepcion) {
			daoFactory.cancelarTransacion();
			throw excepcion;
		} catch (Exception excepcion) {
			daoFactory.cancelarTransacion();
			
			var mensajeUsuario = CatalogoMensajes.PaisFachadaImpl.USUARIO_ERROR_MODIFICANDO_INFORMACION_PAIS_EXISTENTE;
			throw LibreriaUCOFachadaExcepcion.crear(mensajeUsuario, excepcion.getMessage(), excepcion);
		} finally {
			daoFactory.cerrarConexion();
		}
	}

	@Override
	public void darBajaInformacionPaisExistente(UUID id, PaisDTO datos) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public List<PaisDTO> consultarPorFiltro(PaisDTO filtro) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<PaisDTO> consultarTodos() {
		
		try {
			var listaPaises = paisNegocio.consultarTodos();
			return PaisDTOAssembler.getInstance().convertirADTO(listaPaises);
		} catch (LibreriaUCOExcepcion excepcion) {
			throw excepcion;
		} catch (Exception excepcion) {
			var mensajeUsuario = CatalogoMensajes.PaisFachadaImpl.USUARIO_ERROR_CONSULTANDO_PAISES;
			throw LibreriaUCOFachadaExcepcion.crear(mensajeUsuario, excepcion.getMessage(), excepcion);
		} finally {
			daoFactory.cerrarConexion();
		}
	}

	@Override
	public PaisDTO consultarPorId(UUID id) {
		// TODO Auto-generated method stub
		return null;
	}
	
}
