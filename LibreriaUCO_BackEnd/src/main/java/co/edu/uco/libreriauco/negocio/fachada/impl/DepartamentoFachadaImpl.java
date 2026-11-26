package co.edu.uco.libreriauco.negocio.fachada.impl;

import java.util.List;
import java.util.UUID;

import co.edu.uco.libreriauco.dao.factoria.DAOFactory;
import co.edu.uco.libreriauco.dto.DepartamentoDTO;
import co.edu.uco.libreriauco.negocio.fachada.DepartamentoFachada;
import co.edu.uco.libreriauco.negocio.fachada.assembler.impl.DepartamentoDTOAssembler;
import co.edu.uco.libreriauco.negocio.negocio.DepartamentoNegocio;
import co.edu.uco.libreriauco.negocio.negocio.impl.DepartamentoNegocioImpl;
import co.edu.uco.libreriauco.transversal.catalogo.CatalogoMensajes;
import co.edu.uco.libreriauco.transversal.excepciones.LibreriaUCOExcepcion;
import co.edu.uco.libreriauco.transversal.excepciones.LibreriaUCOFachadaExcepcion;

public class DepartamentoFachadaImpl implements DepartamentoFachada{
	
	private DAOFactory daoFactory;
	private DepartamentoNegocio departamentoNegocio;
	
	public DepartamentoFachadaImpl() {
		daoFactory = DAOFactory.obtenerFactoria();
		departamentoNegocio = new DepartamentoNegocioImpl(daoFactory);
	}

	@Override
	public void registrarInformacionNuevoDepartamento(DepartamentoDTO datos) {
		daoFactory.iniciarTransacion();
		
		try {
			var departamentoDominio = DepartamentoDTOAssembler.getInstance().convertirADominio(datos);
			departamentoNegocio.registrarInformacionNuevoDepartamento(departamentoDominio);
			daoFactory.confirmarTransacion();
		} catch (LibreriaUCOExcepcion excepcion) {
			daoFactory.cancelarTransacion();
			throw excepcion;
		} catch (Exception excepcion) {
			daoFactory.cancelarTransacion();
			
			var mensajeUsuario = CatalogoMensajes.DepartamentoFachadaImpl.USUARIO_ERROR_REGISTRANDO_DEPARTAMENTO_NUEVO;
			throw LibreriaUCOFachadaExcepcion.crear(mensajeUsuario, excepcion.getMessage(), excepcion);
		} finally {
			daoFactory.cerrarConexion();
		}
		
	}

	@Override
	public void modificarInformacionDepartamentoExistente(UUID id, DepartamentoDTO datos) {
		daoFactory.iniciarTransacion();
		
		try {
			var departamentoDominio = DepartamentoDTOAssembler.getInstance().convertirADominio(datos);
			departamentoNegocio.modificarInformacionDepartamentoExistente(id, departamentoDominio);
			daoFactory.confirmarTransacion();
		}
		 catch (LibreriaUCOExcepcion excepcion) {
			daoFactory.cancelarTransacion();
			throw excepcion;
		} catch (Exception excepcion) {
			daoFactory.cancelarTransacion();
			
			var mensajeUsuario = CatalogoMensajes.DepartamentoFachadaImpl.USUARIO_ERROR_MODIFICANDO_INFORMACION_DEPARTAMENTO_EXISTENTE;
			throw LibreriaUCOFachadaExcepcion.crear(mensajeUsuario, excepcion.getMessage(), excepcion);
		} 
		finally {
			daoFactory.cerrarConexion();
		}
	}

	@Override
	public void darBajaInformacionDepartamentoExistente(UUID id) {
		daoFactory.iniciarTransacion();
		
		try {
			departamentoNegocio.darBajaInformacionDepartamentoExistente(id);
			daoFactory.confirmarTransacion();
		}
		catch (LibreriaUCOExcepcion excepcion) {
			daoFactory.cancelarTransacion();
			throw excepcion;
		}
		catch (Exception excepcion) {
			daoFactory.cancelarTransacion();
			
			var mensajeUsuario = CatalogoMensajes.DepartamentoFachadaImpl.USUARIO_ERROR_ELIMINANDO_DEPARTAMENTO_EXISTE;
			throw LibreriaUCOFachadaExcepcion.crear(mensajeUsuario, excepcion.getMessage(), excepcion);
		}
		finally {
			daoFactory.cerrarConexion();
		}
		
	}

	@Override
	public List<DepartamentoDTO> consultarTodos() {
		try {
			var departamentos = departamentoNegocio.consultarTodos();
			return DepartamentoDTOAssembler.getInstance().convertirADTO(departamentos);
		}
		catch (LibreriaUCOExcepcion excepcion) {
			throw excepcion;
		}
		catch (Exception excepcion) {
			var mensajeUsuario = CatalogoMensajes.DepartamentoFachadaImpl.USUARIO_ERROR_CONSULTANDO_DEPARTAMENTOS;
			throw LibreriaUCOFachadaExcepcion.crear(mensajeUsuario, excepcion.getMessage(), excepcion);
		}
		finally {
			daoFactory.cerrarConexion();
		}
	}
	
}
