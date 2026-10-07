package co.edu.uco.libreriauco.negocio.negocio.reglas;

public interface Rule<O> {
	
	// tres puntos son argumentos variables
	void ejecutar(O... datos);
	
}
