package exceptions;

public class EmptyDataException extends Exception {
	
	private static final long serialVersionUID = 1L;
	
	@Override
	public String getMessage() {
		return "Faltan datos obligatorios.";
		
	}

}
