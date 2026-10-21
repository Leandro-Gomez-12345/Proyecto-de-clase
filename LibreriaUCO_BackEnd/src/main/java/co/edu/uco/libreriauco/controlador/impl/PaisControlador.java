package co.edu.uco.libreriauco.controlador.impl;

import java.util.UUID;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import co.edu.uco.libreriauco.controlador.AbstractRestController;
import co.edu.uco.libreriauco.controlador.respuesta.RespuestaOk;
import co.edu.uco.libreriauco.dto.PaisDTO;
import co.edu.uco.libreriauco.negocio.fachada.PaisFachada;
import co.edu.uco.libreriauco.negocio.fachada.impl.PaisFachadaImpl;

@RestController
@RequestMapping("/api/v1/paises")
public class PaisControlador extends AbstractRestController {
	
	private PaisFachada fachada = new PaisFachadaImpl();
	
	@GetMapping("/dummy")
	public PaisDTO consultarDummy() {
		return new PaisDTO();
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<RespuestaOk<PaisDTO>> consultarPorId(@PathVariable UUID id) {
		var pais = fachada.consultarPorId(id);
		RespuestaOk<PaisDTO> respuesta = RespuestaOk.crear(pais);
		return ResponseEntity.ok(respuesta);
	}
	
	//...../api/v1/paises?id=valor&nombre=Colombia
	//...../api/v1/paises?id=valor
	//...../api/v1/paises?nombre=Colombia&id=valor
	//...../api/v1/paises
	//...../api/v1/paises?paisResidencia=valor Bad Practice
	//...../api/v1/paises?pais-residencia=valor Best Practice
	// Lo anterior son Query Params
	@GetMapping
	public ResponseEntity<RespuestaOk<PaisDTO>> consultarPorFiltro(PaisDTO filtro) {
		var pais = fachada.consultarPorFiltro(filtro);
		RespuestaOk<PaisDTO> respuesta = RespuestaOk.crear(pais);
		return ResponseEntity.ok(respuesta);
	}
	
	@PostMapping
	public ResponseEntity<RespuestaOk<String>> regitrarInformacionNuevoPais(@RequestBody PaisDTO pais) {
		fachada.registrarInformacionNuevoPais(pais);
		RespuestaOk<String> respuesta = RespuestaOk.crear("Se ha registrado la informacion del nuevo pais de forma exitosa.");
		return ResponseEntity.ok(respuesta);
	}
	
	@PutMapping("/{id}")
	public ResponseEntity<RespuestaOk<String>> modificarInformacionPaisExistente(@PathVariable UUID id, @RequestBody PaisDTO datos) {
		fachada.modificarInformacionPaisExistente(id, datos);
		RespuestaOk<String> respuesta = RespuestaOk.crear("Se ha modificado la informacion del pais deseado de forma exitosa.");
		return ResponseEntity.ok(respuesta);
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<RespuestaOk<String>> darBajaPaisExistente(@PathVariable UUID id) {
		fachada.darBajaInformacionPaisExistente(id);
		RespuestaOk<String> respuesta = RespuestaOk.crear("Se ha eliminado la informacion del pais deseado de forma exitosa.");
		return ResponseEntity.ok(respuesta);
	}
}


// <protocolo>: //<host>:<puetos>/<recurso>
// http://localhost:8800/api/v1/paises
// http://127.0.0.1:8800/api/v1/paises
// http://127.0.0.1:8800/api/v1/paises

// http-->80 por defecto
// https-->443 por defecto