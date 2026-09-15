package dao.datos.entidad;

import java.util.UUID;

import co.edu.uco.libreriauco.entidad.PaisEntidad;
import dao.datos.ActualizarDAO;
import dao.datos.ConsultarDAO;
import dao.datos.CrearDAO;
import dao.datos.EliminarDAO;

public interface PaisDAO extends CrearDAO<PaisEntidad>, ConsultarDAO<PaisEntidad, UUID>, 
		ActualizarDAO<PaisEntidad, UUID>, EliminarDAO<UUID> {
	
	
}
