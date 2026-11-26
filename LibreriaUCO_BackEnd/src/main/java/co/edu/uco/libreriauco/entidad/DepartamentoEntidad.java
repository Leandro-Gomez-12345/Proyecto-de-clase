package co.edu.uco.libreriauco.entidad;

import java.util.UUID;

import co.edu.uco.libreriauco.transversal.utilitarios.UtilObjeto;
import co.edu.uco.libreriauco.transversal.utilitarios.UtilTexto;
import co.edu.uco.libreriauco.transversal.utilitarios.UtilUUID;

public class DepartamentoEntidad {
	
	private PaisEntidad pais;
	private UUID id;
	private String nombre;
	
	public DepartamentoEntidad() {
		setId(UtilUUID.obtenerUUIDDefecto());
		setNombre(UtilTexto.VACIA);
		setPais(new PaisEntidad());
	}
	
	public DepartamentoEntidad(UUID id, String nombre, PaisEntidad pais) {
		setId(id);
		setNombre(nombre);
		setPais(pais);
	}
	
	public UUID getId() {
		return id;
	}
	
	public void setId(UUID id) {
		this.id=  UtilUUID.obtenerValorDefecto(id);
	}
	
	public String getNombre() {
		return nombre;
	}
	
	public void setNombre(String nombre) {
		this.nombre = UtilTexto.getUtilTexto().quitarEspaciosEnBlanco(nombre);
	}

	public PaisEntidad getPais() {
		return pais;
	}

	public void setPais(PaisEntidad pais) {
		this.pais = UtilObjeto.obtenerValorDefectoSiValorOriginalEsNulo(pais, new PaisEntidad());
	}
	
}
