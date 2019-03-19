/**
 * 
 */
package tp1;

/**
 * Classe d'exception utilisée pour signaler
 * que le fichier image n'a pas pu être lu.
 *    - inexistant
 *    - pas de point dans le nom
 * 
 * 
 * @author N'TSOUAGLO Kokou Gawonou
 * @author Cristian Gavidia
 * 
 * @version 8 Oct 2018
 * 
 */
public class ImageNonLueException extends Exception {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	


	/**
	 * 
	 */
	ImageNonLueException() {
		super();
		
	}

	/**
	 * @param message
	 */
	ImageNonLueException(String message) {
		super(message);
	
	}

	/**
	 * @param cause
	 */
	ImageNonLueException(Throwable cause) {
		super(cause);
		 
	}

	/**
	 * @param message
	 * @param cause
	 */
	ImageNonLueException(String message, Throwable cause) {
		super(cause);
		 
	}	

}
