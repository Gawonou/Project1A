package tp1;
/**
 * Classe d'exception utilisée pour signaler
 * que la photo corrigé n'a pas pu être sauvée.
 * 		- toutes les exceptions en IO
 * 
 * 
 * @version 9 Oct 2018
 * 
 */
public class PasSauvegardeException extends Exception {

	private static final long serialVersionUID = 1L;
	
	PasSauvegardeException() {
		super();

	}

	/**
	 * @param message
	 * @param cause
	 */
	PasSauvegardeException(String message, Throwable cause) {
		super(message, cause);
		// TODO Auto-generated constructor stub
	}

	/**
	 * @param message
	 */
	PasSauvegardeException(String message) {
		super(message);
		
	}

	/**
	 * @param cause
	 */
	PasSauvegardeException(Throwable cause) {
		super(cause);
	
	}
}
