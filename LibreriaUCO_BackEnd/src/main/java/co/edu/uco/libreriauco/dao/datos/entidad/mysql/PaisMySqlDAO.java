package co.edu.uco.libreriauco.dao.datos.entidad.mysql;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import co.edu.uco.libreriauco.dao.datos.entidad.SqlDAO;
import co.edu.uco.libreriauco.dao.datos.entidad.PaisDAO;
import co.edu.uco.libreriauco.entidad.PaisEntidad;
import co.edu.uco.libreriauco.transversal.catalogo.CatalogoMensajes;
import co.edu.uco.libreriauco.transversal.excepciones.LibreriaUCODatosException;
import co.edu.uco.libreriauco.transversal.utilitarios.UtilObjeto;
import co.edu.uco.libreriauco.transversal.utilitarios.UtilTexto;
import co.edu.uco.libreriauco.transversal.utilitarios.UtilUUID;

public class PaisMySqlDAO extends SqlDAO implements PaisDAO {

	private static final String SQL_CREAR = "INSERT INTO pais (id, nombre) VALUES (?, ?)";
	private static final String SQL_CONSULTAR = "SELECT id, nombre FROM pais";
	private static final String SQL_ACTUALIZAR = "UPDATE pais SET nombre = ? WHERE id = ?";
	private static final String SQL_ELIMINAR = "DELETE FROM pais WHERE id = ?";

	public PaisMySqlDAO(final Connection conexion) {
		super(conexion);
	}

	@Override
	public void crear(PaisEntidad entidad) {
		try (var sentencia = getConexion().prepareStatement(SQL_CREAR)) {
			sentencia.setObject(1, entidad.getId().toString());
			sentencia.setObject(2, entidad.getNombre());
			
			sentencia.executeUpdate();
		}
		catch (SQLException excepcion) {
			var mensajeUsuario = CatalogoMensajes.Datos.USUARIO_ERROR_CREANDO_PAIS;
			throw LibreriaUCODatosException.crear(mensajeUsuario, excepcion.getMessage(), excepcion);
		}
		
	}

	@Override
	public PaisEntidad consultarPorId(UUID id) {
		var filtro = new PaisEntidad();
		filtro.setId(id);
		var resultados = consultarPorFiltro(filtro);
		return resultados.isEmpty() ? new PaisEntidad() : resultados.get(0);
	}

	@Override
	public List<PaisEntidad> consultarPorFiltro(PaisEntidad filtro) {
	    var filtroSeguro = UtilObjeto.obtenerValorDefectoSiValorOriginalEsNulo(filtro, new PaisEntidad());

	    var condiciones = new ArrayList<String>();
	    var parametros = new ArrayList<Object>();

	    if (!UtilUUID.obtenerUUIDDefecto().equals(filtroSeguro.getId())) {
	        condiciones.add("id = ?");
	        parametros.add(filtroSeguro.getId().toString());
	    }
	    if (!UtilTexto.getUtilTexto().esVacia(filtroSeguro.getNombre())) {
	        condiciones.add("nombre = ?");
	        parametros.add(filtroSeguro.getNombre());
	    }

	    String sql = SQL_CONSULTAR;                     
	    if (!condiciones.isEmpty()) {
	        sql = sql + " WHERE " + String.join(" AND ", condiciones);
	    }

	    return ejecutarConsulta(sql, parametros);
	}

	private List<PaisEntidad> ejecutarConsulta(String sql, List<Object> parametros) {
		var paises = new ArrayList<PaisEntidad>();

		try (var sentencia = getConexion().prepareStatement(sql)) {
			for (int i = 0; i < parametros.size(); i++) {
				sentencia.setObject(i + 1, parametros.get(i));   
			}

			try (var resultados = sentencia.executeQuery()) {
				while (resultados.next()) {
					paises.add(mapearPais(resultados));
				}
			}
		} catch (SQLException excepcion) {
			var mensajeUsuario = CatalogoMensajes.Datos.USUARIO_ERROR_CONSULTANDO_PAIS;
			throw LibreriaUCODatosException.crear(mensajeUsuario, excepcion.getMessage(), excepcion);
		}

		return paises;
	}

	private PaisEntidad mapearPais(ResultSet resultados) {
		try {
			var pais = new PaisEntidad();
			pais.setId(UtilUUID.convertirAUUID(resultados.getString("id")));
			pais.setNombre(resultados.getString("nombre"));
			return pais;
		}
		catch (SQLException  excepcion) {
			var mensajeUsuario = CatalogoMensajes.Datos.USUARIO_ERROR_CONSULTANDO_PAIS;
			throw LibreriaUCODatosException.crear(mensajeUsuario, excepcion.getMessage(), excepcion);
		}
	}

	@Override
	public List<PaisEntidad> consultarTodos() {
	    return ejecutarConsulta(SQL_CONSULTAR, List.of());
	}

	@Override
	public void actualizar(UUID id, PaisEntidad entidad) {
	    ejecutarActualizacion(SQL_ACTUALIZAR,
	            CatalogoMensajes.Datos.USUARIO_ERROR_ACTUALIZANDO_PAIS,
	            entidad.getNombre(),     
	            id.toString());          
	}
	
	@Override
	public void eliminar(UUID id) {
	    ejecutarActualizacion(SQL_ELIMINAR, CatalogoMensajes.Datos.USUARIO_ERROR_ELIMINANDO_PAIS,
	            id.toString());
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