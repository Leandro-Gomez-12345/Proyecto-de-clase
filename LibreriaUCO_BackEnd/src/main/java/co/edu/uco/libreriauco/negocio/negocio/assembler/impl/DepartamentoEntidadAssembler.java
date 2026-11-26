package co.edu.uco.libreriauco.negocio.negocio.assembler.impl;

import java.util.List;

import co.edu.uco.libreriauco.dominio.DepartamentoDominio;
import co.edu.uco.libreriauco.entidad.DepartamentoEntidad;
import co.edu.uco.libreriauco.negocio.negocio.assembler.EntidadAssembler;
import co.edu.uco.libreriauco.transversal.utilitarios.UtilObjeto;

public class DepartamentoEntidadAssembler implements EntidadAssembler<DepartamentoDominio, DepartamentoEntidad> {

	private static final EntidadAssembler<DepartamentoDominio, DepartamentoEntidad> instancia = new DepartamentoEntidadAssembler();

	private DepartamentoEntidadAssembler() {

	}

	public static EntidadAssembler<DepartamentoDominio, DepartamentoEntidad> getInstance() {
		return instancia;
	}

	@Override
	public DepartamentoEntidad convertirAEntidad(DepartamentoDominio dominio) {
		var dominioTmp = UtilObjeto.obtenerValorDefectoSiValorOriginalEsNulo(dominio,
				new DepartamentoDominio.Builder().build());

		return new DepartamentoEntidad(dominioTmp.getId(), dominioTmp.getNombre(), 
				PaisEntidadAssembler.getInstance().convertirAEntidad(dominioTmp.getPais()));
	}

	@Override
	public DepartamentoDominio convertirADominio(DepartamentoEntidad entidad) {
		var entidadTmp = UtilObjeto.obtenerValorDefectoSiValorOriginalEsNulo(entidad, new DepartamentoEntidad());

		return new DepartamentoDominio.Builder().id(entidadTmp.getId()).nombre(entidadTmp.getNombre())
				.pais(PaisEntidadAssembler.getInstance().convertirADominio(entidadTmp.getPais())).build();
	}
	
	@Override
	public List<DepartamentoDominio> convertirADominio(List<DepartamentoEntidad> listaEntidades) {
		return listaEntidades.stream().map(this::convertirADominio).toList();
	}

}
