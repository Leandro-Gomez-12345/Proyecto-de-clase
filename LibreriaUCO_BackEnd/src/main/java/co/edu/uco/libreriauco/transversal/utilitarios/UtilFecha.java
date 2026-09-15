package co.edu.uco.libreriauco.transversal.utilitarios;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeFormatterBuilder;

public class UtilFecha {
	
	public static DateTimeFormatter formato = new DateTimeFormatterBuilder()
	        .appendPattern("dd/MM/yyyy")
	        .toFormatter();
	public static LocalDateTime FECHADEFECTO = LocalDateTime.parse("01/01/1000", formato);
}
