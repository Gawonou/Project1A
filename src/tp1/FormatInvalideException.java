package tp1;

/**
 * Classe d'exception utilisée pour signaler
 * que le fichier image n'a pas un contenu valide.
 * 		- pas une extension supportée 
 * 
 * 
 * @author N'TSOUAGLO Kokou Gawonou
 * @author Cristian Gavidia
 * 
 * @version 8 Oct 2018
 * 
 */
public class FormatInvalideException extends Exception {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	/**
	 * 
	 */
	FormatInvalideException() {
		super();

	}

	/**
	 * @param message
	 * @param cause
	 */
	FormatInvalideException(String message, Throwable cause) {
		super(message, cause);
		// TODO Auto-generated constructor stub
	}

	/**
	 * @param message
	 */
	FormatInvalideException(String message) {
		super(message);
		
	}

	/**
	 * @param cause
	 */
	FormatInvalideException(Throwable cause) {
		super(cause);
	
	}

}
