package rest.module.Movieflix.Exception;

public class NotFoundException extends RuntimeException {

	private static final long serialVersionUID = 6381820252833965109L;

	public NotFoundException(String message) {
		super(message);
		
	}
	
	public NotFoundException(String message, Throwable cause){
		super(message, cause);
	}
}
