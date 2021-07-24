package exceptions;

public class NoSelectionException extends Exception {
	private static final long serialVersionUID = 1L;
	
	public NoSelectionException() {}
	
	@Override
	public String getMessage() {
		return "Ning�n miembro fue seleccionado de la tabla.";
		
	}
	
}
