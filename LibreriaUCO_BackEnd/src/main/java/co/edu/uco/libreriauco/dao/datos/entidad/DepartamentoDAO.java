package co.edu.uco.libreriauco.dao.datos.entidad;

import java.util.UUID;

import co.edu.uco.libreriauco.dao.datos.ActualizarDAO;
import co.edu.uco.libreriauco.dao.datos.ConsultarDAO;
import co.edu.uco.libreriauco.dao.datos.CrearDAO;
import co.edu.uco.libreriauco.dao.datos.EliminarDAO;
import co.edu.uco.libreriauco.entidad.DepartamentoEntidad;

public interface DepartamentoDAO extends CrearDAO<DepartamentoEntidad>, ConsultarDAO<DepartamentoEntidad, UUID>, 
ActualizarDAO<DepartamentoEntidad, UUID>, EliminarDAO<UUID>{

}
