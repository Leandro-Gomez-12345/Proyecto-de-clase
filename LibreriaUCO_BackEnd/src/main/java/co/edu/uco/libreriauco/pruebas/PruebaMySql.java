package co.edu.uco.libreriauco.pruebas;

import co.edu.uco.libreriauco.dao.factoria.impl.MySqlDAOFactory;
import co.edu.uco.libreriauco.entidad.PaisEntidad;
import co.edu.uco.libreriauco.transversal.utilitarios.UtilUUID;

public class PruebaMySql {

	public static void main(String[] args) {
		var factoria = new MySqlDAOFactory();
		var paisDAO = factoria.obtenerPaisDAO();

		var pais = new PaisEntidad();
		pais.setId(UtilUUID.generar());
		pais.setNombre("Colombia");
		paisDAO.crear(pais);

		paisDAO.consultarTodos()
				.forEach(p -> System.out.println(p.getId() + " - " + p.getNombre()));
	}
}
