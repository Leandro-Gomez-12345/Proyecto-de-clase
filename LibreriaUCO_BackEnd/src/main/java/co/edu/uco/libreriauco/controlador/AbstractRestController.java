package co.edu.uco.libreriauco.controlador;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.servlet.resource.NoResourceFoundException;

import co.edu.uco.libreriauco.controlador.respuesta.RespuestaError;
import co.edu.uco.libreriauco.transversal.excepciones.LibreriaUCOExcepcion;
import co.edu.uco.libreriauco.transversal.utilitarios.UtilUUID;

@RestControllerAdvice
public abstract class AbstractRestController {
	
	@ExceptionHandler(LibreriaUCOExcepcion.class)
	public ResponseEntity<RespuestaError<String>> controlarLibreriaUcoException(LibreriaUCOExcepcion excepcion) {
		var correlationId = UtilUUID.generarComoTexto();
		var mensajeRespuesta = "Se ha presentado tratando de llevar a cabo la operacion deseada. Por favor intente de nuevo y si el problema persiste contacte al administrador de la aplicacion y entreguele el codigo: "
				.concat(correlationId);
		var respuesta = RespuestaError.crear(excepcion.getMensajeUsuario());
		// logger.printException(excepcion);
		return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(respuesta);
	}
	
	@ExceptionHandler(NoResourceFoundException.class)
	public ResponseEntity<RespuestaError<String>> controlarNotReourcerFoundException(NoResourceFoundException excepcion) {
		var correlationId = UtilUUID.generarComoTexto();
		var mensajeRespuesta = "Ojo mono porque el recurso que pidio no existe..." + excepcion.getResourcePath()
		+ " por el metodo " + excepcion.getHttpMethod();
		var respuesta = RespuestaError.crear(mensajeRespuesta);
		// logger.printException(excepcion);
		//Esto de abajo no puede estar en el final
		excepcion.printStackTrace();
		return ResponseEntity.status(HttpStatus.NOT_FOUND ).body(respuesta);
	}
	
	@ExceptionHandler(Exception.class)
	public ResponseEntity<RespuestaError<String>> controlarException(LibreriaUCOExcepcion excepcion) {
		var correlationId = UtilUUID.generarComoTexto();
		var mensajeRespuesta = "Se ha presentado tratando de llevar a cabo la operacion deseada. Por favor intente de nuevo y si el problema persiste contacte al administrador de la aplicacion y entreguelo "
				.concat(correlationId);
		var respuesta = RespuestaError.crear(mensajeRespuesta);
		// logger.printException(excepcion);
		//Esto de abajo no puede estar en el final
		excepcion.printStackTrace();
		return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR ).body(respuesta);
	}
	
}
