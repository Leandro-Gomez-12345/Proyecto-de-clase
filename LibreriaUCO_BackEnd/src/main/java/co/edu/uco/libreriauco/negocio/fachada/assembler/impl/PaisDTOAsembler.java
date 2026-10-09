package co.edu.uco.libreriauco.negocio.fachada.assembler.impl;

import java.util.List;

import co.edu.uco.libreriauco.dominio.PaisDominio;
import co.edu.uco.libreriauco.negocio.fachada.assembler.DTOAssembler;

public class PaisDTOAsembler implements DTOAssembler<PaisDominio, PaisDTO>{
	
	private static final DTOAssembler<PaisDominio, PaisDTO> instancia = new PaisDTOAssembler();
	
	private PaisDTOAsembler() {
		
	}
	
	public static PaisDTOAsembler getInstance() {
		return instancia;
	}

	@Override
	public PaisDTO convertirADTO(PaisDominio dominio) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public PaisDominio convertirADominio(PaisDTO dto) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<PaisDTO> convertirADTO(List<PaisDominio> listaDominios) {
		return listaDominios.stream().map(this::convertirADTO).toList();
	}
}
