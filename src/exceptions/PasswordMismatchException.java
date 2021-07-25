package exceptions;

public class PasswordMismatchException extends Exception{
	private static final long serialVersionUID = 1L;
	
	public PasswordMismatchException() {}
	
	@Override
	public String getMessage() {
		return "La contraseña ingresada no corresponde a la confirmación de la misma.";
		
	}
}
