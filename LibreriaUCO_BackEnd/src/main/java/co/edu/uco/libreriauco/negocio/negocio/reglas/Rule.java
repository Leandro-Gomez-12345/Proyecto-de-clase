package co.edu.uco.libreriauco.negocio.negocio.reglas;

public interface Rule<O> {
	
	@SuppressWarnings("unchecked")
	void ejecutar(O... datos);
	
}
