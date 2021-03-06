package rest.module.Movieflix.Exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(code=HttpStatus.NOT_FOUND)
public class AlreadyExistsException extends RuntimeException {

	private static final long serialVersionUID = 6381820252833965109L;

	public AlreadyExistsException(String message) {
		super(message);
		
	}
	
	public AlreadyExistsException(String message, Throwable cause){
		super(message, cause);
	}
}
