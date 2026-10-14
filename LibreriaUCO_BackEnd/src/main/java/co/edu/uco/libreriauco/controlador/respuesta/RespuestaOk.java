package co.edu.uco.libreriauco.controlador.respuesta;

import java.util.List;

public class RespuestaOk<D> extends Respuesta<D> {

	protected RespuestaOk(List<String> mensajes, List<D> datos) {
		super(mensajes, datos, EstadoRespuesta.OK);
	}
	
	public static <D> RespuestaError<D> crear(List<String> mensajes, List<D> datos) {
		return new RespuestaError<>(mensajes, datos);
	}
	
	public static <D> RespuestaError<D> crear(List<D> datos) {
		return new RespuestaError<>(List.of(), datos);
	}
	
	public static <D> RespuestaOk<D> crear() {
		return new RespuestaError<>(List.of(), List.of());
	}
}
