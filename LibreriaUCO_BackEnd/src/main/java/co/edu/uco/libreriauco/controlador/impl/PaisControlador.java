package co.edu.uco.libreriauco.controlador.impl;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import co.edu.uco.libreriauco.controlador.AbstractRestController;

@RestController
@RequestMapping("/api/v1/paises")
public class PaisControlador extends AbstractRestController {
	
	@GetMapping
	public String consultarTodos() {
		return "Ahora sí mono! Método GET exitoso";
	}
	
	@PostMapping
	public String regitrarInformacionNuevoPais() {
		return "Ahora sí mono! Método POST exitoso";
	}
	
	@PutMapping
	public String modificarInformacionPaisExistente() {
		return "Ahora sí mono! Método PUT exitoso";
	}
	
	@DeleteMapping
	public String darBajaInformacionPaisExistente() {
		return "Ahora sí mono! Método DELETE exitoso";
	}
}


// <protocolo>: //<host>:<puetos>/<recurso>
// http://localhost:8800/api/v1/paises
// http://127.0.0.1:8800/api/v1/paises
// http://127.0.0.1:8800/api/v1/paises

// http-->80 por defecto
// https-->443 por defecto