package co.edu.uco.libreriauco.dao.datos.entidad.mysql;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import co.edu.uco.libreriauco.dao.datos.entidad.DepartamentoDAO;
import co.edu.uco.libreriauco.dao.datos.entidad.SqlDAO;
import co.edu.uco.libreriauco.entidad.DepartamentoEntidad;
import co.edu.uco.libreriauco.entidad.PaisEntidad;
import co.edu.uco.libreriauco.transversal.catalogo.CatalogoMensajes;
import co.edu.uco.libreriauco.transversal.excepciones.LibreriaUCODatosException;
import co.edu.uco.libreriauco.transversal.utilitarios.UtilObjeto;
import co.edu.uco.libreriauco.transversal.utilitarios.UtilTexto;
import co.edu.uco.libreriauco.transversal.utilitarios.UtilUUID;

public class DepartamentoMySqlDAO extends SqlDAO implements DepartamentoDAO {

	private static final String SQL_CREAR = "INSERT INTO departamento (id, nombre, pais) VALUES (?, ?, ?)";
	private static final String SQL_CONSULTAR = "SELECT id, nombre, pais FROM departamento";
	private static final String SQL_ACTUALIZAR = "UPDATE departamento SET nombre = ?, pais = ? WHERE id = ?";
	private static final String SQL_ELIMINAR = "DELETE FROM departamento WHERE id = ?";

	public DepartamentoMySqlDAO(final Connection conexion) {
		super(conexion);
	}

	@Override
	public void crear(DepartamentoEntidad entidad) {
		entidad = UtilObjeto.obtenerValorDefectoSiValorOriginalEsNulo(entidad, new DepartamentoEntidad());
		var mensajeUsuario = CatalogoMensajes.Datos.USUARIO_ERROR_CREANDO_DEPARTAMENTO;
		ejecutarActualizacion(SQL_CREAR, mensajeUsuario, entidad.getId().toString(), 
				entidad.getNombre(), entidad.getPais().getId().toString());
	}

	@Override
	public DepartamentoEntidad consultarPorId(UUID id) {
		var filtro = new DepartamentoEntidad();
		filtro.setId(id);
		var resultados = consultarPorFiltro(filtro);
		return resultados.isEmpty() ? new DepartamentoEntidad() : resultados.get(0);
	}

	@Override
	public List<DepartamentoEntidad> consultarPorFiltro(DepartamentoEntidad filtro) {
		filtro = UtilObjeto.obtenerValorDefectoSiValorOriginalEsNulo(filtro, new DepartamentoEntidad());
		
		var condiciones = new ArrayList<String>(); 
		var parametros = new ArrayList<Object>();
		
		if (!UtilUUID.obtenerUUIDDefecto().equals(filtro.getId())) {
			condiciones.add("id = ?");
			parametros.add(filtro.getId().toString());
		}
		
		if (!UtilTexto.getUtilTexto().esVacia(filtro.getNombre())) {
			condiciones.add("nombre = ?");
			parametros.add(filtro.getNombre());
		}
		
		if (!UtilUUID.obtenerUUIDDefecto().equals(filtro.getPais().getId())) {
			condiciones.add("pais = ?");
			parametros.add(filtro.getPais().getId().toString());
		}
		
		String sql = SQL_CONSULTAR;
		if (!condiciones.isEmpty()) {
		    sql = sql + " WHERE " + String.join(" AND ", condiciones);
		}
		
		return ejecutarConsulta(sql, parametros);
	}

	@Override
	public List<DepartamentoEntidad> consultarTodos() {
		return ejecutarConsulta(SQL_CONSULTAR, List.of());
	}

	private List<DepartamentoEntidad> ejecutarConsulta(String sql, List<Object> parametros) {
		var departamentos = new ArrayList<DepartamentoEntidad>();

		try (var sentencia = getConexion().prepareStatement(sql)) {
			for (int i = 0; i < parametros.size(); i++) {
				sentencia.setObject(i + 1, parametros.get(i));   
			}

			try (var resultados = sentencia.executeQuery()) {
				while (resultados.next()) {
					departamentos.add(mapearDepartamento(resultados));
				}
			}
		} catch (SQLException excepcion) {
			var mensajeUsuario = CatalogoMensajes.Datos.USUARIO_ERROR_CONSULTANDO_DEPARTAMENTO;
			throw LibreriaUCODatosException.crear(mensajeUsuario, excepcion.getMessage(), excepcion);
		}

		return departamentos;
	}
	
	private DepartamentoEntidad mapearDepartamento(ResultSet resultados) {
		try {
			var departamento = new DepartamentoEntidad();
			departamento.setId(UtilUUID.convertirAUUID(resultados.getString("id")));
			departamento.setNombre(resultados.getString("nombre"));
			
			var pais = new PaisEntidad();
			pais.setId(UtilUUID.convertirAUUID(resultados.getString("pais")));
			
			departamento.setPais(pais);
			return departamento;
		}
		catch (Exception excepcion) {
			var mensajeUsuario = CatalogoMensajes.Datos.USUARIO_ERROR_CONSULTANDO_DEPARTAMENTO;
			throw LibreriaUCODatosException.crear(mensajeUsuario, excepcion.getMessage(), excepcion);
		}
	}

	@Override
	public void actualizar(UUID id, DepartamentoEntidad entidad) {
		entidad = UtilObjeto.obtenerValorDefectoSiValorOriginalEsNulo(entidad, new DepartamentoEntidad());
		var mensajeUsuario = CatalogoMensajes.Datos.USUARIO_ERROR_ACTUALIZANDO_DEPARTAMENTO;
		ejecutarActualizacion(SQL_ACTUALIZAR, mensajeUsuario, entidad.getNombre(),
				entidad.getPais().getId().toString(), UtilUUID.obtenerValorDefecto(id).toString());
	}

	@Override
	public void eliminar(UUID id) {
		var mensajeUsuario = CatalogoMensajes.Datos.USUARIO_ERROR_ELIMINANDO_DEPARTAMENTO;
		ejecutarActualizacion(SQL_ELIMINAR, mensajeUsuario, UtilUUID.obtenerValorDefecto(id).toString());
	}

	private void ejecutarActualizacion(String sql, String mensajeUsuario, Object... parametros) {
	    try (var sentencia = getConexion().prepareStatement(sql)) {
	        for (int i = 0; i < parametros.length; i++) {
	            sentencia.setObject(i + 1, parametros[i]);  
	        }
	        sentencia.executeUpdate();
	    } catch (SQLException excepcion) {
	        throw LibreriaUCODatosException.crear(mensajeUsuario, excepcion.getMessage(), excepcion);
	    }
	}
}