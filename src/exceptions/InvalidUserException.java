package exceptions;

public class InvalidUserException extends Exception{
	private static final long serialVersionUID = 1L;
	
	public InvalidUserException() {}
	
	@Override
	public String getMessage() {
		return "Username or password incorrect";
		
	}

}
