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

import co.edu.uco.libreriauco.controlador.respuesta.RespuestaOk;
import co.edu.uco.libreriauco.dto.DepartamentoDTO;
import co.edu.uco.libreriauco.negocio.fachada.impl.DepartamentoFachadaImpl;

@RestController
@RequestMapping("/api/v1/departamentos")
public class DepartamentoControlador {
	
	@PostMapping
	public ResponseEntity<RespuestaOk<String>> regitrarInformacionNuevoDepartamento(@RequestBody DepartamentoDTO pais) {
		var fachada = new DepartamentoFachadaImpl();
		fachada.registrarInformacionNuevoDepartamento(pais);
		RespuestaOk<String> respuesta = RespuestaOk.crear("Se ha registrado la informacion del nuevo departamento de forma exitosa.");
		return ResponseEntity.ok(respuesta);
	}
	
	@PutMapping("/{id}")
	public ResponseEntity<RespuestaOk<String>> modificarInformacionDepartamentoExistente(@PathVariable UUID id, @RequestBody DepartamentoDTO pais) {
		var fachada = new DepartamentoFachadaImpl();
		fachada.modificarInformacionDepartamentoExistente(id, pais);
		RespuestaOk<String> respuesta = RespuestaOk.crear("Se ha actualizado la informacion del departamento de forma exitosa.");
		return ResponseEntity.ok(respuesta);
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<RespuestaOk<String>> darBajaInformacionDepartamentoExistente(@PathVariable UUID id) {
		var fachada = new DepartamentoFachadaImpl();
		fachada.darBajaInformacionDepartamentoExistente(id);
		RespuestaOk<String> respuesta = RespuestaOk.crear("Se ha eliminado el departamento de forma existosa.");
		return ResponseEntity.ok(respuesta);
	}
	
	@GetMapping
	public ResponseEntity<RespuestaOk<DepartamentoDTO>> consultarTodos() {
		var fachada = new DepartamentoFachadaImpl();
		var departamentos = fachada.consultarTodos();
		
		RespuestaOk<DepartamentoDTO> respuesta = RespuestaOk.crear(departamentos);
		return ResponseEntity.ok(respuesta);
	}
}
