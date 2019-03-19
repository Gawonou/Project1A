package logPhoto;

/**
 * Classe d'exception utilisée pour signaler
 * que le fichier ne contient pas d'image valide
 * 		- vide 
 * 
 * @version 8 Oct 2018
 * 
 */
public class ImageInvalideException extends Exception {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * 
	 */
	ImageInvalideException() {
		super();

	}

	/**
	 * @param message
	 * @param cause
	 */
	ImageInvalideException(String message, Throwable cause) {
		super(message, cause);
		// TODO Auto-generated constructor stub
	}

	/**
	 * @param message
	 */
	ImageInvalideException(String message) {
		super(message);
		
	}

	/**
	 * @param cause
	 */
	ImageInvalideException(Throwable cause) {
		super(cause);
	
	}
	
}
