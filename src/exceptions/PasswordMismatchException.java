package exceptions;

public class PasswordMismatchException extends Exception{
	private static final long serialVersionUID = 1L;
	
	public PasswordMismatchException() {}
	
	@Override
	public String getMessage() {
		return "La contrase�a ingresada no corresponde a la confirmaci�n de la misma.";
		
	}
}
