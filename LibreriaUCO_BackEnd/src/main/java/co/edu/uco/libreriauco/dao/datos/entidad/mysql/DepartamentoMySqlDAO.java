package co.edu.uco.libreriauco.dao.datos.entidad.mysql;

import java.sql.Connection;
import java.util.List;
import java.util.UUID;

import co.edu.uco.libreriauco.dao.datos.entidad.SqlDAO;
import co.edu.uco.libreriauco.dao.datos.entidad.DepartamentoDAO;
import co.edu.uco.libreriauco.entidad.DepartamentoEntidad;

public class DepartamentoMySqlDAO extends SqlDAO implements DepartamentoDAO {

	public DepartamentoMySqlDAO(final Connection conexion) {
		super(conexion);
	}

	@Override
	public DepartamentoDAO consultarPorId(UUID id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<DepartamentoDAO> consultarPorFiltro(DepartamentoDAO filtro) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<DepartamentoDAO> consultarTodos() {
		// TODO Auto-generated method stub
		return null;
	}

	
}
